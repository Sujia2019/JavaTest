package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class MessageHandler {
    private MessageInvoker invoker;


    void domain(Message msg){

        int code = msg.getCode();

        if(code == CODE.LOGIN){
            invoker = new LoginInvoker();
        }else{
            invoker = new OtherInvoker();

        }
        Object obj = invoker.sendMessage(msg);
        System.out.println(obj);
    }

}
