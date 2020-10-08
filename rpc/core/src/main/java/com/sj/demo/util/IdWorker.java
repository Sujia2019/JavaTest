package com.sj.demo.util;

public class IdWorker {
    //因为二进制里面第一个bit位 1代表复数，但我们要生成的id都是正数则首位为0

    // 机器ID 2进制5位，32位减掉1位 31个
    private long machineId;
    // 机房ID
    private long roomId;
    // 一毫秒内生成的多个id的最新序列号 12位 4096-1
    private long sequence;
    // 设置一个时间初始值 2^41
    private long time = 1585644268888L;
    // 5位的机器id
    private long machineIdBits = 5L;
    // 5位的机房id
    private long roomIdBits = 5L;
    // 每毫秒内产生的id数 2的12次方
    private long sequenceBits = 12L;
    // 这个是2进制运算，就是5 bit 最多只能有31个数字，也就是说机器id最多只能32以内
    private long maxMachineId = ~(-1L << machineIdBits);
    private long maxRoomId = ~(-1L << roomIdBits);

    private long machineIdShift = sequenceBits;
    private long roomIdShift = sequenceBits + machineIdBits;
    private long timestampLeftShift = sequenceBits + machineIdBits + roomIdBits;
    private long sequenceMask = ~(-1L << sequenceBits);
    // 记录产生时间毫秒数，判断是否是同1毫秒
    private long lastTimestamp = -1L;
    public long getMachineId(){
        return machineId;
    }
    public long getRoomId(){
        return roomId;
    }
    public long getTimestamp(){
        return System.currentTimeMillis();
    }
    public IdWorker(long machineId, long roomId, long sequence){
        //检查机房id和机器id是否超过31 不能小于0
        if(machineId > maxMachineId || machineId < 0){
            throw new IllegalArgumentException(
                    String.format("机器Id不能比 %d 大，不能小于 0 ",maxMachineId)
            );
        }

        if(roomId > maxRoomId || roomId < 0){
            throw new IllegalArgumentException(
                    String.format("机房Id不能比 %d 大，不能小于0",maxRoomId)
            );
        }
        this.roomId=roomId;
        this.machineId=machineId;
        this.sequence=sequence;
    }

    /**
     * 核心方法，让当前这台机器上的雪花算法生成全局唯一的Id
     * @return
     */
    public synchronized long nextId(){
        // 获取当前时间戳
        long timestamp = getTimestamp();
        if(timestamp < lastTimestamp){
            System.err.printf("clock is moving backwards. Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }

        //假设再同一毫秒又发送了一个请求生成一个id
        //把sequence序号递增，最多是4096
        if(lastTimestamp == timestamp){
            // 一个毫秒内最多只能有4096个数字，无论你传递多少进来
            // 位运算保证始终是在4096这个范围内，避免你自己传递个sequence超过了4096
            sequence = (sequence + 1) & sequenceMask;
            // 当某一毫秒的时间，产生的id数超过4095，系统会进入等待，直到下一毫秒，系统继续产生id
            if (sequence == 0){
                timestamp = waitNextMills(lastTimestamp);
            }
        } else {
          sequence = 0;
        }
        // 记录一下最近一次生成id的时间戳 毫秒为单位
        lastTimestamp = timestamp;
        // 最核心的二进制位运算操作，生成一个64bit的id
        // 先将当前时间戳左移，放到41 bit那儿；将机房id左移放到5 bit那儿；将机器id左移放到5 bit那儿；将序号放最后12 bit
        // 最后拼接起来成一个64 bit的二进制数字，转换成10进制就是个long型
        return (timestamp - time << timestampLeftShift) |
                (roomId << roomIdShift) |
                (machineId << machineIdBits) | sequence;
    }

    /**
     * 当某一毫秒时间，产生的id数超过4095，系统进入等待，直到下一毫秒，系统继续产生id
     * @param lastTimestamp
     * @return
     */
    private long waitNextMills(long lastTimestamp){
        long timestamp = getTimestamp();
        while (timestamp <= lastTimestamp){
            timestamp = getTimestamp();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(1L,1L,1L);
        System.out.println(idWorker.nextId());
        System.out.println(idWorker.nextId());
        System.out.println(idWorker.nextId());
    }
}
