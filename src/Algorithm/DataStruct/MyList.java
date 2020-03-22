package Algorithm.DataStruct;


public class MyList<T> {

//    private final static int CAPACITY = 10;
//    private final static Object[] EMPTY_ARRAY  = {};
    private MyNode<T> root ;
    private int index=-1;
    private int size=0;
    private MyNode last;


    static class MyNode<T>{
        int i;
        T t;
        MyNode next;
        MyNode(int i,T t ,MyNode next){
            this.i=i;
            this.t=t;
            this.next=next;
        }
        MyNode(){
            this.i=0;
            this.t=null;
            this.next=null;
        }
    }
    MyList(){
        root=new MyNode<>();
    }
    private MyNode last(){
        MyNode n = root;
        for(;;){
            if(n.next!=null){
                n=n.next;
            }else{
                return n;
            }
        }
    }

    private MyNode newNode(T t){
        return new MyNode<T>(index,t,null);
    }

    public void add(T t){
        last=last();
        index++;
        if (size==0){
            root.t=t;
        }else{
            last.next=newNode(t);
        }
        size++;
    }

    public void remove(int x){
        MyNode n = root;
    }

    public Object get(int i){
        MyNode n = root;
        for(;i<size;){
            if (n.i==i){
                return n.t;
            }else{
                n=n.next;
            }
        }
        return null;
    }

    public void replace(int i,T t){
        MyNode n = root;
        for(;;){
            if (n.i==i){
                n.t=t;
                break;
            }else{
                n=n.next;
            }
        }
    }


    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
//        list.remove(1);

        for(int i=0;i<list.size;i++){
            System.out.println(list.get(i));
        }

    }
}
