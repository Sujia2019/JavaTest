package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.Message;

import java.util.Map;

public interface IMyMessage {
//    public Map<Integer,Object> getMessageParam();

//    public void setMessageParam(Map<Integer,Object> messageParam);

    public void setMessage(Message msg);

    public Message getMessage();

    public void sendMessage();

}
