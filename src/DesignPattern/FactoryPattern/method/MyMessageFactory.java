package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

import java.util.HashMap;
import java.util.Map;

public class MyMessageFactory implements IMessageFactory{
//    @Override
//    public IMyMessage createMessage(int code) {
//        IMyMessage myMessage;
//        Map<Integer,Object> messageParam = new HashMap<>();
//        if(code == CODE.LOGIN){
//            myMessage = new MyLoginMessage();
//            messageParam.put(1,"登录");
//        }else if(code == CODE.CHAT){
//            myMessage = new MyChatMessage();
//            messageParam.put(2,"聊天");
//        }else{
//            myMessage = new MyExceptionMessage();
//            messageParam.put(500,"Error");
//        }
//        myMessage.setMessageParam(messageParam);
//        return myMessage;
//    }

    @Override
    public IMyMessage handler(Message msg) {
        int code = msg.getCode();
        IMyMessage myMessage;
        if(code == CODE.LOGIN){
            myMessage = new MyLoginMessage();
        }else if(code == CODE.CHAT){
            myMessage = new MyChatMessage();
        }else{
            myMessage = new MyExceptionMessage();
        }
        myMessage.setMessage(msg);
        return myMessage;
    }
}
