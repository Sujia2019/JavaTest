#include <iostream>
#include <string>

using namespace std;

class node{
    struct node *next;
};
class student{
    string id;
    struct node t;
};

class teacher{
    string name;
    struct node t;
};
int main(int num, char *args[]){

    student s1;
    s1.id=1234;
    node *ps=s1->t;

    teacher t1;
    node *pt=t1->t;

}
