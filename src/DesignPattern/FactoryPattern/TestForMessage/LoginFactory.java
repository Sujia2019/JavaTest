package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.abstractFactory.User;

public class LoginFactory implements MessageFactory {

    @Override
    public Object handle(Object obj) {
        return doLogin(obj);

    }

    private User doLogin(Object obj){
        String name = (String)obj;
        User user = new User();
        user.setUsername(name);
        return user;
    }

}
