package DesignPattern.DecoratorPattern;
/*
子类爆炸问题如何解决？

例如：饮料为父类
父类中有各种材料，并实现cost方法，也就是各种材料加起来对应的价钱
 */

public abstract class Drink {
    Sugar sugar;
    Mocha mocha;
}
