package DesignPattern.BuilderPattern.utils;

import DesignPattern.BuilderPattern.model.Message;
import lombok.Getter;

/**
 * 转发器
 */
public class Sender {
    private static volatile Sender sender ;

    public static Sender getInstance(){
        if (sender==null){
            synchronized(Sender.class){
                if(sender==null){
                    sender = new Sender();
                }
            }
        }
        return sender;
    }

    /**
     *
     * @param msg 发送者
     * @return 处理后的信息
     */
    public Message send(Message msg){
        String str = msg.getSend(); // 获得发来的信息
        // 创建路由
        Router router = new Router(str);
        // 自定义转换规则
        msg.setResult(
                router
                        .setEmoji()
                        .setPicture()
                        .setTail("我的小尾巴～")
                        .build());
        return msg;
    }

    public enum Type{
        /**
         * 私聊，所有人，群组
         */
        EMPTY(null),SINGLE("私聊"),ALL("全部"),GROUP("群组");

        private String type;

        Type(String s) {
            this.type = s;
        }

        public String getType() {
            return type;
        }
    }

}
