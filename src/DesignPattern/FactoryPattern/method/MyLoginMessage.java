package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class MyLoginMessage extends IMyAbstractMessage {
    @Override
    public void setMessage(Message msg) {
        msg.setCode(CODE.SUCCESS);
        msg.setMsg("登录成功");
        this.msg = msg;
    }

    @Override
    public void sendMessage() {

        System.out.println("LOGIN------"+getMessage());
    }
}
