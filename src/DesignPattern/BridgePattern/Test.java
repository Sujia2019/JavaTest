package DesignPattern.BridgePattern;

import DesignPattern.BridgePattern.model.*;

public class Test {


    public static void main(String[] args) {
        Pen small = new SmallPen();
        Pen mid = new MidPen();
        Pen big = new BigPen();

        small.setColor(new Red());
        mid.setColor(new Black());
        mid.drawSomething("drawing...");
        big.setColor(new Blue());
        big.drawSomething("drawing...");

        big.setColor(new Yellow());
        big.drawSomething("drawing...");
        mid.drawSomething("drawing...");

        small.setColor(new Green());
        small.drawSomething("drawing...");




    }

}
