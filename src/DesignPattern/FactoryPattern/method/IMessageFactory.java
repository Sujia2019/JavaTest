package DesignPattern.FactoryPattern.method;

public interface IMessageFactory {
    public IMyMessage createMessage(int code);
}
