package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.Message;

import java.util.Map;

public abstract class IMyAbstractMessage implements IMyMessage{
//    private Map<Integer,Object> messageParam;
    protected Message msg;

//    @Override
//    public Map<Integer, Object> getMessageParam() {
//        return messageParam;
//    }
    @Override
    public Message getMessage() {
        return msg;
    }
//    @Override
//    public void setMessageParam(Map<Integer, Object> messageParam) {
//        this.messageParam = messageParam;
//    }
}
