package DesignPattern.FactoryPattern.abstractFactory;

public class LoginInvoker extends MessageInvoker{




    Object handle(ResponseFactory response) {
        this.factory = response;
        return login();
    }

    private String login(){

        return "LOGIN";
    }

    @Override
    Object handle() {
        return null;
    }

//    @Override
//    Object handle() {
//        return null;
//    }
}
