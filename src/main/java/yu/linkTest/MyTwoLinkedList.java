package yu.linkTest;

/**
 * Created by koreyoshi on 2017/7/28.
 */
public class MyTwoLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;                //链表size
    private int modCount = 0;           //操作数
    private Node<AnyType> beginMarker;  //头结点
    private Node<AnyType> endMarker;    //尾节点

    private static class Node<AnyType> {  //链表节点的结构
        public AnyType data;                //数据
        public Node<AnyType> prev;          //上一个节点
        public Node<AnyType> next;          //下一个节点

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyTwoLinkedList() {   //构造方法，初始化。
        clear();
    }



    public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public Boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx), x);
    }

    //搜索节点，先判断节点在前半段还是后半段，略提高效率，双链表可以从两个方向查找
    private Node<AnyType> getNode(int idx) {
        Node<AnyType> p;//一个引用

        if (idx < 0 || idx > size())
            throw new IndexOutOfBoundsException();
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++)
                p = p.next;
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--)
                p = p.prev;
        }
        return p;
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);//双链表，新增节点插入指向前后
        //前后两个节点的指向变化
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        //修改次数+1
        modCount++;
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        //一个引用，改变节点值
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        //修改次数仍+1
        modCount++;
        return p.data;
    }


    public java.util.Iterator<AnyType> iterator() {
        //返回一个实例化的内部类，该类是迭代器，内部实现
        return new MyTwoLinkedList.LinkedListIterator();
    }

    //实现Iterator接口
    private class LinkedListIterator implements java.util.Iterator<AnyType> {
        //在内部指向第一个元素
        private Node<AnyType> current = beginMarker.next;

        //检测在迭代期间集合被修改的情况，分别在next()和迭代器自己的remove()中检查，如果修改次数不同说明在迭代器迭代之外发生了修改行为
        //迭代器自己的remove()调用外层类的remove,其中有modCount++,迭代器做出remove()动作后将expectecModCount++,保证迭代期间二者保持一致
        private int expectedModCount = modCount;

        //okToRemove在next()执行后被置为true,在迭代器自己的remove()执行完后置为false,迭代器自己的remove()执行前检查其是否为true才执行，保证迭代一次才能删除一个，没有其他迭代时删除的方式
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public AnyType next() {
            if (modCount != expectedModCount)
                //同一时间修改冲突异常！！
                throw new java.util.ConcurrentModificationException();
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            //用一个引用指向并从外部类获取前一个元素数据
            AnyType nextItem = current.data;
            //实际是改变一个引用的指向使其前进
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            //不是迭代期间调用此迭代器remove()方法
            if (!okToRemove)
                throw new IllegalStateException();
            //调用外部类方法
            //next()使current先指向下一元素，这里移除current前一个元素，这样边迭代边移除，先后移后删除前一个元素


            MyTwoLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }


    public static void main(String[] args) {

    }
}
