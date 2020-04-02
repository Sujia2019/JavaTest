package DesignPattern.BridgePattern.model;

import DesignPattern.BridgePattern.Color;

public class Yellow implements Color {
    private String colorName;
    public Yellow(){
        colorName = "Yellow";
    }

    @Override
    public void bePaint(String penType, String name) {
        System.out.println("PenType:"+penType+"  ColorName:"+colorName+"  PaintSomething:"+name);
    }
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
