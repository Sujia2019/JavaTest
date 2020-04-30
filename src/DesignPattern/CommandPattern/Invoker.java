package DesignPattern.CommandPattern;

public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }

    public static void main(String[] args) {
        Receiver r = new TestReceiver();
        Command c = new ConcreteCommand(r);
        Invoker i = new Invoker();
        i.setCommand(c);
        i.executeCommand();

    }
}
