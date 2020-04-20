package DesignPattern.FactoryPattern.abstractFactory;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public abstract class MessageInvoker {

    ResponseFactory factory;


    abstract Object handle();

    void sendMessage(Message msg){
        int code = msg.getCode();
        if(code == CODE.LOGIN){
            factory = new LoginResponse();
        }

    }

    void getMessage(){

    }

}
