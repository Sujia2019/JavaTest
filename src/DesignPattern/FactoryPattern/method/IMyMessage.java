package DesignPattern.FactoryPattern.method;

import java.util.Map;

public interface IMyMessage {
    public Map<Integer,Object> getMessageParam();

    public void setMessageParam(Map<Integer,Object> messageParam);

    public void sendMessage();
}
