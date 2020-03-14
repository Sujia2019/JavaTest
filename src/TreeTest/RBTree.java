package TreeTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//   仿HashMap实现 数组->链表->红黑树
//   ConcurrentHashMap线程安全，多处使用到CAS算法，以无锁方式修改值的操作
//   hash冲突---->两个不同对象的hashCode相同
public class RBTree<K,V> extends AbstractMap<K,V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    //链表结点
    static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldeValue = value;
            value = newValue;
            return oldeValue;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) obj;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    Node<K,V> newNode(int hash,K key,V value,Node<K,V> next){
        return new Node<>(hash,key,value,next);
    }
    Node<K,V> replacementNode(Node<K,V> p,Node<K,V> next){
        return new Node<>(p.hash,p.key,p.value,next);
    }

    TreeNode<K,V> newTreeNode(int hash,K key,V value,Node<K,V> next){
        return new TreeNode<>(hash,key,value,next);
    }

    TreeNode<K,V> replacementTreeNode(Node<K,V> p,Node<K,V> next){
        return new TreeNode<>(p.hash,p.key,p.value,next);
    }

    static final class TreeNode<K,V> extends Node<K, V> {
        TreeNode<K,V> parent;
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;
        boolean red;
        TreeNode(int hash,K key,V val,Node<K,V> next){
            super(hash,key,val,next);
        }
        //返回包含此节点的树的根。
        final TreeNode<K,V> root(){
            for (TreeNode<K,V> r = this,p;;){
                if((p=r.parent)==null)
                    return r;
                r=p;
            }
        }


        //确保给定的根是其bin的第一个节点。
        static <K,V> void moveRootToFront(Node<K,V>[] tab,TreeNode<K,V> root){
            int n;
            if(root!=null&&tab!=null&&(n=tab.length)>0){
                int index = (n-1)&root.hash;
                TreeNode<K,V> first = (TreeNode<K,V>)tab[index];
                if(root!=first){
                    Node<K,V> rn;
                    tab[index]=root;
                    TreeNode<K,V> rp = root.prev;
                    if((rn=root.next)!=null)
                        ((TreeNode<K,V>)rn).prev=rp;
                    if(rp!=null)
                        rp.next=rn;
                    if(first!=null)
                        first.prev=root;
                    root.next=first;
                    root.prev=null;
                }
                assert checkInvariants(root);
            }
        }


        final TreeNode<K,V> find(int h,Object k,Class<?> kc){
            TreeNode<K,V> p = this;
            do{
                int ph,dir;K pk;
                TreeNode<K,V> pl = p.left,
                        pr = p.right,q;
                if((ph=p.hash)>h)
                    p=pl;
                else if(ph<h)
                    p=pr;
                else if((pk=p.key)==k||(k!=null&&k.equals(pk)))
                    return p;
                else if(pl==null)
                    p=pr;
                else if(pr==null)
                    p=pl;
                else if ((kc != null ||
                        (kc = comparableClassFor(k)) != null) &&
                        (dir = compareComparables(kc, k, pk)) != 0)
                    p = (dir < 0) ? pl : pr;
                else if ((q = pr.find(h, k, kc)) != null)
                    return q;
                else
                    p = pl;
            } while (p != null);
            return null;
        }

        final TreeNode<K,V> getTreeNode(int h,Object k){
            return ((parent!=null)?root():this).find(h,k,null);
        }
        static int tieBreakOrder(Object a, Object b) {
            int d;
            if (a == null || b == null ||
                    (d = a.getClass().getName().
                            compareTo(b.getClass().getName())) == 0)
                d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
                        -1 : 1);
            return d;
        }

        final void treeify(Node<K,V>[] tab){
            TreeNode<K,V> root=null;
            for(TreeNode<K,V> x = this,next;x!=null;x=next){
                next=(TreeNode<K,V>)x.next;
                x.left=x.right=null;
                if(root==null){
                    x.parent=null;
                    x.red=false;
                    root=x;
                }
                else{
                    K k = x.key;
                    int h=x.hash;
                    Class<?> kc=null;
                    for(TreeNode<K,V> p=root;;){
                        int dir,ph;
                        K pk = p.key;
                        if((ph=p.hash)>h)
                            dir=-1;
                        else if(ph<h)
                            dir=1;
                        else if ((kc == null &&
                                (kc = comparableClassFor(k)) == null) ||
                                (dir = compareComparables(kc, k, pk)) == 0)
                            dir = tieBreakOrder(k, pk);
                        TreeNode<K,V> xp = p;
                        if((p=(dir<=0)?p.left:p.right)==null){
                            x.parent=xp;
                            if(dir<=0)
                                xp.left=x;
                            else
                                xp.right=x;
                            root = balanceInsertion(root,x);
                            break;
                        }
                    }
                }
            }
            moveRootToFront(tab,root);
        }


        final Node<K,V> untreeify(RBTree<K,V> map) {
            Node<K,V> hd = null, tl = null;
            for (Node<K,V> q = this; q != null; q = q.next) {
                Node<K,V> p = map.replacementNode(q, null);
                if (tl == null)
                    hd = p;
                else
                    tl.next = p;
                tl = p;
            }
            return hd;
        }

        final TreeNode<K,V> putTreeVal(RBTree map,Node<K,V>[] tab,
                                       int h,K k,V v){
            Class<?> kc=null;
            boolean searched=false;
            TreeNode<K,V> root = (parent!=null)?root():this;
            for(TreeNode<K,V> p = root;;){
                int dir,ph;K pk;
                if((ph=p.hash)>h)
                    dir=-1;
                else if(ph<h)
                    dir=1;
                else if((pk=p.key)==k||(k!=null&&k.equals(pk)))
                    return p;
                else if((kc==null&&
                        (kc=comparableClassFor(k))==null)||
                        (dir=compareComparables(kc,k,pk))==0){
                    if (!searched){
                        TreeNode<K,V> q,ch;
                        searched = true;
                        if(((ch=p.left)!=null&&
                                (q=ch.find(h,k,kc))!=null)||
                                ((ch=p.right)!=null&&
                                        (q=ch.find(h,k,kc))!=null))
                            return q;
                    }
                    dir=tieBreakOrder(k,pk);
                }
                TreeNode<K,V> xp = p;
                if((p=(dir<=0)?p.left:p.right)==null){
                    Node<K,V> xpn = xp.next;
                    TreeNode<K,V> x = map.newTreeNode(h,k,v,xpn);
                    if(dir<=0)
                        xp.left=x;
                    else
                        xp.right=x;
                    xp.next=x;
                    x.parent=x.prev=xp;
                    if(xpn!=null)
                        ((TreeNode<K,V>)xpn).prev = x;
                    moveRootToFront(tab,balanceInsertion(root,x));
                    return null;
                }
            }
        }
        final void removeTreeNode(RBTree<K,V> map,Node<K,V>[] tab,
                                  boolean movable){
            int n;
            if(tab==null||(n=tab.length)==0)
                return ;
            int index=(n-1)&hash;
            TreeNode<K,V> first=(TreeNode<K,V>)tab[index],root=first,rl;
            TreeNode<K,V> succ=(TreeNode<K,V>)next,pred=prev;
            if(pred==null)
                tab[index]=first=succ;
            else
                pred.next=succ;
            if(succ!=null)
                succ.prev=pred;
            if(first==null)
                return ;
            if(root.parent!=null)
                root=root.root();
            if(root==null
                ||(movable
                    &&(root.right==null
                        ||(rl=root.left)==null
                        ||rl.left==null))){
                tab[index]=first.untreeify(map);//too small
                return;
            }
            TreeNode<K,V> p = this,pl=left,pr=right,replacement;
            if(pl!=null&&pr!=null){
                TreeNode<K,V> s = pr,sl;
                while((sl=s.left)!=null)//找后继，找继承结点
                    s=sl;
                boolean c = s.red;s.red=p.red;p.red=c;//交换颜色
                TreeNode<K,V> sr = s.right;
                TreeNode<K,V> pp = p.parent;
                if(s==pr){
                    p.parent=s;
                    s.right=p;
                }
                else{
                    TreeNode<K,V> sp = s.parent;
                    if((p.parent=sp)!=null){
                        if(s==sp.left)
                            sp.left=p;
                        else
                            sp.right=p;
                    }
                    if((s.right=pr)!=null)
                        pr.parent=s;
                }
                p.left=null;
                if((p.right=sr)!=null)
                    sr.parent=p;
                if((s.left=pl)!=null)
                    pl.parent=s;
                if((s.parent=pp)==null)
                    root=s;
                else if(p==pp.left)
                    pp.left=s;
                if(sr!=null)
                    replacement=sr;
                else
                    replacement=p;
            }
            else if(pl!=null)
                replacement =pl;
            else if(pr!=null)
                replacement=pr;
            else
                replacement=p;
            if(replacement!=p){
                TreeNode<K,V> pp = replacement.parent=p.parent;
                if(pp==null)
                    root=replacement;
                else if(p==pp.left)
                    pp.left=replacement;
                else
                    pp.right=replacement;
                p.left=p.right=p.parent=null;
            }

            TreeNode<K,V> r = p.red?root:balanceDeletion(root,replacement);

            if(replacement == p){//detach
                TreeNode<K,V> pp = p.parent;
                p.parent=null;
                if(pp!=null){
                    if(p==pp.left)
                        pp.left=null;
                    else if(p==pp.right)
                        pp.right=null;
                }
            }
            if(movable)
                moveRootToFront(tab,r);
        }


        static <K,V> TreeNode<K,V> rotateLeft(TreeNode<K,V> root,
                                              TreeNode<K,V> p){
            TreeNode<K,V> r,pp,rl;
            if(p!=null&&(r=p.right)!=null){
                if((rl=p.right=r.left)!=null)
                    rl.parent=p;
                if((pp=r.parent=p.parent)==null)
                    (root=r).red=false;
                else if(pp.left==p)
                    pp.left=r;
                else
                    pp.right=r;
                r.left=p;
                p.parent=r;
            }
            return root;
        }

        static <K,V> TreeNode<K,V> rotateRight(TreeNode<K,V> root,TreeNode<K,V> p){
            TreeNode<K,V> l,pp,lr;
            if(p!=null&&(l=p.left)!=null){
                if((lr=p.left=l.right)!=null)
                    lr.parent=p;
                if((pp=l.parent=p.parent)==null)
                    (root=l).red=false;
                else if(pp.right==p)
                    pp.right=l;
                else
                    pp.left=l;
                l.right=p;
                p.parent=l;
            }
            return root;
        }
        static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
                                                    TreeNode<K,V> x){
            x.red=true;
            for(TreeNode<K,V> xp,xpp,xppl,xppr;;){
                if((xp=x.parent)==null){
                    x.red=false;
                    return x;
                }
                else if(!xp.red||(xpp=xp.parent)==null)
                    return root;
                if(xp==(xppl=xpp.left)){
                    if((xppr=xpp.right)!=null&&xppr.red){
                        xppr.red=false;
                        xp.red=false;
                        xpp.red=true;
                        x=xpp;
                    }
                    else{
                        if(x==xp.right){
                            root=rotateLeft(root,x=xp);
                            xpp=(xp=x.parent)==null?null:xp.parent;
                        }
                        if(xp!=null){
                            xp.red=false;
                            if(xpp!=null){
                                xpp.red=true;
                                root=rotateRight(root,xpp);
                            }
                        }
                    }
                }
                else{
                    if(xppl!=null&&xppl.red){
                        xppl.red=false;
                        xp.red=false;
                        xpp.red=true;
                        x=xpp;
                    }
                    else{
                        if(x==xp.left){
                            root=rotateRight(root,x=xp);
                            xpp=(xp=x.parent)==null?null:xp.parent;
                        }
                        if(xp!=null){
                            xp.red=false;
                            if(xpp!=null){
                                xpp.red=true;
                                root=rotateLeft(root,xpp);
                            }
                        }
                    }
                }
            }
        }
        static <K,V> TreeNode<K,V> balanceDeletion(TreeNode<K,V> root,
                                                   TreeNode<K,V> x){
            for(TreeNode<K,V> xp,xpl,xpr;;){
                if(x==null||x==root)
                    return root;
                else if((xp=x.parent)==null){
                    x.red=false;
                    return x;
                }
                else if(x.red){
                    x.red=false;
                    return root;
                }
                else if((xpl=xp.left)==x){
                    if((xpr=xp.right)!=null&&xpr.red){
                        xpr.red=false;
                        xp.red=true;
                        root=rotateLeft(root,xp);
                        xpr=(xp=x.parent)==null?null:xp.right;
                    }
                    if(xpr==null)
                        x=xp;
                    else{
                        TreeNode<K,V> sl = xpr.left,sr=xpr.right;
                        if((sr==null||!sr.red)&&
                                (sl==null||!sl.red)){
                            xpr.red=true;
                            x=xp;
                        }
                        else{
                            if(sr==null||!sr.red){
                                if(sl!=null)
                                    sl.red=false;
                                xpr.red=true;
                                root=rotateRight(root,xpr);
                                xpr=(xp=x.parent)==null?
                                        null:xp.right;
                            }
                            if(xpr!=null){
                                xpr.red=(xp==null)?false:xp.red;
                                if((sr=xpr.right)!=null)
                                    sr.red=false;
                            }
                            if(xp!=null){
                                xp.red=false;
                                root=rotateLeft(root,xp);
                            }
                            x=root;
                        }
                    }
                }
                else{//对称的
                    if(xpl!=null&&xpl.red){
                        xpl.red=false;
                        xp.red=true;
                        root=rotateRight(root,xp);
                        xpl=(xp=x.parent)==null?null:xp.left;
                    }
                    if(xpl==null)
                        x=xp;
                    else{
                        TreeNode<K,V> sl = xpl.left, sr = xpl.right;
                        if ((sl == null || !sl.red) &&
                                (sr == null || !sr.red)) {
                            xpl.red = true;
                            x = xp;
                        }
                        else {
                            if (sl == null || !sl.red) {
                                if (sr != null)
                                    sr.red = false;
                                xpl.red = true;
                                root = rotateLeft(root, xpl);
                                xpl = (xp = x.parent) == null ?
                                        null : xp.left;
                            }
                            if(xpl!=null){
                                xpl.red = (xp == null) ? false : xp.red;
                                if((sl=xpl.left)!=null)
                                    sl.red=false;
                            }
                            if(xp!=null){
                                xp.red=false;
                                root=rotateRight(root,xp);
                            }
                            x=root;
                        }
                    }
                }
            }
        }



        static <K,V> boolean checkInvariants(TreeNode<K,V> t){
            TreeNode<K,V> tp = t.parent,tl=t.left,tr=t.right,
                    tb=t.prev,tn=(TreeNode<K,V>)t.next;
            if(tb!=null&&tb.next!=t)
                return false;
            if(tn!=null&&tn.prev!=t)
                return false;
            if(tp!=null&&t!=tp.left&&t!=tp.right)
                return false;
            if(tl!=null&&(tl.parent!=t||tl.hash>t.hash))
                return false;
            if(tr!=null&&(tr.parent!=t||tr.hash<t.hash))
                return false;
            if(t.red&&tl!=null&&tl.red&&tr!=null&&tr.red)
                return false;
            if(tl!=null&&!checkInvariants(tl))
                return false;
            if(tr!=null&&!checkInvariants(tr))
                return false;
            return true;
        }


    }
    /**
     * Returns x's Class if it is of the form "class C implements
     * Comparable<C>", else null.
     */
    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType)t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }

    /**
     * Returns k.compareTo(x) if x matches kc (k's screened comparable
     * class), else 0.
     */
    @SuppressWarnings({"rawtypes","unchecked"}) // for cast to Comparable
    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable)k).compareTo(x));
    }

}
