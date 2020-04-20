package DesignPattern.FactoryPattern.TestForMessage;

public class OtherFactory implements MessageFactory {
    @Override
    public Object handle(Object obj) {


        return "xxx";
    }
}
