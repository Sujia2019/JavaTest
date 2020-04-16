package DesignPattern.FactoryPattern.method;

import java.util.Map;

public abstract class IMyAbstractMessage implements IMyMessage{
    private Map<Integer,Object> messageParam;


    @Override
    public Map<Integer, Object> getMessageParam() {
        return messageParam;
    }

    @Override
    public void setMessageParam(Map<Integer, Object> messageParam) {
        this.messageParam = messageParam;
    }
}
