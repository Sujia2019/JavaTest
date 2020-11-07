struct Node{
    struct Node *next;
}

struct Stu{       //结构体内的内存是连续的！紧密联系，内存对齐
    char *id;
    struct Node t;  //实体
}

struct Tea{           //从这里    ---
    char *name;         //        x
    struct Node t;       //到这里 ---
}  

零类型     (struct Stu *)0   确定的数字都有确定的地址，   强制类型转换成stu，
                            然后在其中找t的位置，0的头位置减去t的位置求出差值x，
     
写这个作业
用sizeof算一下占多少个





c++

struct Person{     //默认public    声明数据类型时习惯用struct， 带方法的话习惯用class类

};
区别
class person{    //开源习惯编码风格   
    int age;           //默认从头开始都是private，直到声明了别的为止
    char *name;
    int age;
public:           //从这里开始都是public
    person(int age){
       this->age=age;
    }    
    person(){    
       cout<<"person"<<endl;
    }
    ~person(){    //析构函数  在销毁之前，释放内存之前调用函数。
       free(name);   //要释放name，不然可能造成内存泄露
       cout<<"~person"<<endl;
    }
};

class myptr{
public:
    myptr(person *p){
        this->p=p;
    }
    ~myptr(){
        delete p;
    }
private 
    person *p;
}

int main(){
    int a=1;
    int a1(1);   //=号和（）效果一样，声明。
    person p(1);   //这里面向对象构造方法等效果与java类似。
    person *p=new person;     //new 了，在堆里
    cout<<"xxx"<<endl;
//     delete p;
//     return 0;      
    myptr p=new person      //两种写法一个意思myptr p(new person)栈内存了栈变量默认走析构函数
                                                     //释放 delete
}




#include <iostream>
#include <string>

using namespace std;

class car{
public:
    car(int id){
        this->id=id;
        cout<<"car"<<endl;
    }
    int getID(){
        return this->id;
    }

    virtual void show(){         //类似abstruct
        cout<<"car id:"<<this->id<<endl;
    } 
    ~car(){
        this->show();
        cout<<"~car"<<endl;
    }
private:      //类外只能用public    private 不能被继承
    int id;
};

class truck:public car {    //冒号代表继承
public:
    truck(int id, int n) : car(id), num(n) {    //必须 强调 是调什么东西，怎么调（private/public）
        cout << "truck" << endl;
    }

    void show(){
        cout<<"truck id:"<<this->getID()<<"\t"<<this->num<<endl;
    }

    ~truck() {
        this->show();
        cout << "~truck" << endl;
    }
private:
    int num;
};

int main(int num, char *args[]){
    truck t(10,20);
    t.show();
}



引用
void swap(int &a,int &b){   //起外号
    int a=t;
    a=b;
    b=t;
}

.h
class stu{
    int id;
public:
    stu(int id);
    void show();
public:
    void xxxx();     //在头文件中可以只声明不定义
} 

.cpp
stu::stu(int id) {     
    this->id=id;
}
void stu::xxxx(){     //在外定义，在源文件中定义（库）
    this->id;
}








static    不属于任何对象，全局的，数据端
.cpp源文件中这么写
#include <iostream>
#include "stu.h"指针指向结构体中的指针
using namespace std;

int stu::i=0;
stu::stu(int id) {
    this->id=id;=&pt;

    this->incr();
}

void stu::show() {
    cout<<this->id<<endl;
    cout<<"已经拥有"<<i<<"个&s0;对象了"<<endl;

}

int stu::incr() {
    i++;
}

头文件定义
class stu {
public:
    static int i;
    stu(int id);
    void show();
    static int incr();
private:
    int id;

};

int main(){
    stu s(12);
    stu s1(12);
    stu s2(12);
    stu s3(12);
//    s1.i=100;
//    stu::i=99;
    s3.show();
    return 0;
}

结果：12
已经拥有4个对象了



template<class T> 


inline函数 少写几行


运算符重载
单目 ++ -- ! * & [] ()
双目 


