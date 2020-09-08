### 观察者模式
 当观察对象的状态发生变化时，会通知给观察者。Observer模式适用于根据对象状态进行相应处理的场景
 
* Observer 表示观察者的接口
* NumberGenerator 表示生成数值的对象的抽象类
* RandomNumberGenerator 生成随机数的类
* DigitObserver 表示以数字形式显示数值的类
* GraphObserver 表示以简单的图示形式显示数值的类
