package DesignPattern.AdapterPattern;

import DesignPattern.AdapterPattern.modle.Adaptee;
import DesignPattern.AdapterPattern.modle.Adapter;
import DesignPattern.AdapterPattern.modle.Target;

public class Test {

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.adapteeMethod();

        target.adapterMethod();
    }
}
