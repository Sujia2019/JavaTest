package DesignPattern.BridgePattern;

import DesignPattern.BridgePattern.model.*;

public class Test {


    public static void main(String[] args) {
        Pen small = new SmallPen();
        Pen mid = new MidPen();
        Pen big = new BigPen();
        Color red = new Red();
        Color black = new Black();
        Color yellow = new Yellow();
        Color green = new Green();
        Color blue = new Blue();

        small.setColor(red);
        mid.setColor(black);
        mid.drawSomething("drawing...");
        big.setColor(blue);
        big.drawSomething("drawing...");

        big.setColor(red);
        big.drawSomething("drawing...");
        mid.drawSomething("drawing...");

        small.setColor(green);
        small.drawSomething("drawing...");




    }

}
