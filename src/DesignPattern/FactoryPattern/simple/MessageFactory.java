package DesignPattern.FactoryPattern.simple;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class MessageFactory {

    public static MessageHandler handleMessage (int type){
        switch (type){
            case CODE.LOGIN:
                return new MessageLogin();
            case CODE.CHAT:
                return new MessageChat();
        }
        return null;
    }

}
