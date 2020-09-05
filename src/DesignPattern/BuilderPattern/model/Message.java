package DesignPattern.BuilderPattern.model;

import DesignPattern.BuilderPattern.utils.Sender;
import lombok.Data;

@Data
public class Message {
    private Sender.Type type; // 传递类型
    private String send; // 传递内容
    private String result; // 解析结果
    private User from; // 发送人
    private User to; // 发给谁

    @Override
    public String toString(){
        return "["+type.getType()+"] "+from.getName()+" 对 "+to.getName()+" 说 : "+result;
    }
}
