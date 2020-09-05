package DesignPattern.BridgePattern.example;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("HELLO"));
        Display d2 = new Display(new StringDisplayImpl("HELLO PATTERN"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("HELLO BRIDGE PATTERN"));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }

}
