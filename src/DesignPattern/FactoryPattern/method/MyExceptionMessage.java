package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class MyExceptionMessage extends IMyAbstractMessage {
    @Override
    public void setMessage(Message msg) {
        msg.setCode(CODE.FAIL);
        msg.setMsg("错误信息");
        this.msg = msg;
    }

    @Override
    public void sendMessage() {
        System.out.println("Send ErrorMessage------"+getMessage());
    }
}
