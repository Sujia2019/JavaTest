package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class MyChatMessage extends IMyAbstractMessage{
    @Override
    public void setMessage(Message msg) {
        msg.setCode(CODE.SUCCESS);
        msg.setMsg("发起聊天");
        this.msg = msg;
    }

    @Override
    public void sendMessage() {
        System.out.println("CHAT------"+getMessage());
    }
}
