package DesignPattern.BridgePattern.model;

import DesignPattern.BridgePattern.Color;
import DesignPattern.BridgePattern.Pen;

public class SmallPen extends Pen {

    @Override
    public void drawSomething(String name) {
        this.color.bePaint("SmallPen",name);
    }
}
