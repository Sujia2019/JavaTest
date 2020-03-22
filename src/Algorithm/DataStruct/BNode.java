package Algorithm.DataStruct;

import java.util.Map;

public class BNode {
    private BNode lChild;
    private BNode rChild;
    private int value;


    public BNode(int value){
        this.value=value;
    }

    public void add(BNode node){
        if (node == null) {
            return;
        }
        if(node.value<this.value){
            if(this.lChild==null){
                node=this.lChild;
            }else{
                this.lChild.add(node);
            }
        }else{
            if(this.rChild==null){
                this.rChild=node;
            }else{
                this.rChild.add(node);
            }
        }
        //判断是否平衡   把树转成平衡二叉树
        //首先是左边比右边的高，右旋
//            System.out.println(leftHeight()+"---------"+rightHeight());
        if(leftHeight()-rightHeight()>=2){
            //如果出现左子树的右子树比左子树的左子树高，双旋转
            if(lChild!=null&&lChild.leftHeight()<lChild.rightHeight()){
                lChild.turnLeft();;
                turnRight();
            }else{
                turnRight();
            }
        }

        if(rightHeight()-leftHeight()>=2){
            if(rChild!=null&&rChild.leftHeight()>rChild.rightHeight()){
                rChild.turnRight();
                turnLeft();
            }else{
                turnLeft();
            }
        }
    }



    private void turnLeft(){
        BNode node = new BNode(this.value);
        node.lChild=this.lChild;
        node.rChild=this.rChild.lChild;
        this.value=this.rChild.value;
        this.rChild=this.rChild.rChild;
        this.lChild=node;
    }

    private void turnRight(){
        BNode node = new BNode(this.value);
        node.rChild=this.rChild;
        node.lChild=this.lChild.rChild;
        this.value=this.lChild.value;
        this.lChild=this.lChild.lChild;
        this.rChild=node;
    }

    //取树高度
    public int height(){
        return Math.max(lChild==null?0:lChild.height(),rChild==null?0:rChild.height())+1;
    }

    //获取左子树高度
    public int leftHeight(){
        if(lChild==null){
            return 0;
        }
        return lChild.height();
    }

    public int rightHeight(){
        if(rChild==null){
            return 0;
        }
        return rChild.height();
    }

    public void midlSHow(){
        if(this.lChild!=null){
            this.lChild.midlSHow();
        }
        System.out.println(this.value);
        if(this.rChild!=null){
            this.rChild.midlSHow();
        }
    }

    public BNode search(int value){
        if (this.value==value){
            return this;
        }else{
            if(this.value>value){
                if(this.lChild==null){
                    return null;
                }
                return this.lChild.search(value);
            }else{
                if(this.rChild==null){
                    return null;
                }
                return this.rChild.search(value);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class BTree{
    private BNode root;
    public void insert(BNode node){
        if(root==null){
            this.root=node;
        }else{
            root.add(node);
        }
    }

    public BNode search(int value){
        if(root==null){
            return null;
        }else{
            return root.search(value);
        }
    }

    public void delete(int value){
        if(root==null){
            return;
        }else{
            BNode t = search(value);
            if(t==null){
                return;
            }else{
//                BNode target = search()
            }
        }
    }
}
