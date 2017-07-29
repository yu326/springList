package yu;

/**
 * Created by korey on 2017/7/29.
 */
public class MytestLink<AnyType> implements Iterable<AnyType> {
    //

    //定义数组大小，操作次数，还有开始和结束的节点
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    //定义node类
    //声明为static,嵌套类，类的一部分，并且独立于外围类对象存在
    private static class Node<AnyType> {
        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            pre = p;
            next = n;
        }

        public AnyType data;
        public Node<AnyType> pre;
        public Node<AnyType> next;
    }

    public MytestLink() {
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

    public void add(int size, AnyType x) {
        Node<AnyType> tail = endMarker;
        addBefore(tail, x);
    }

    public void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newMarker = new Node<AnyType>(x, p.pre, p);
        p.pre.next = newMarker;
        p.pre = newMarker;
        theSize++;
        modCount++;
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public Node<AnyType> getNode(int idx) {
        Node<AnyType> p;//一个引用
        int size = size();
        //下标检测
        if (idx > size() || idx < 0)
            throw new IndexOutOfBoundsException();


        if (idx < size / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }

        } else {
            p = endMarker;
            for (int i = 0; i < size - idx; i++) {
                p = p.pre;
            }
        }
        return p;
    }

    public Boolean set(int idx, AnyType data) {
        Node<AnyType> idxNode = getNode(idx);
        idxNode.data = data;
        return true;
    }

    public Boolean remove(int idx) {
        remove(getNode(idx));
        return true;
    }

    public Boolean remove(Node<AnyType> p) {
        p.pre.next = p.next;
        p.next.pre = p.pre;
        theSize--;
        modCount++;
        return true;
    }

    public Boolean isEmpty() {
        return size() == 0;
    }

    public java.util.Iterator<AnyType> iterator() {
        return new MyLinkList();
    }

    private class MyLinkList implements java.util.Iterator<AnyType> {
        //在迭代器内容进行迭代
        private Node<AnyType> current = beginMarker.next;

        //检测在迭代期间集合被修改的情况，分别在next()和迭代器自己的remove()中检查，如果修改次数不同说明在迭代器迭代之外发生了修改行为
        //迭代器自己的remove()调用外层类的remove,其中有modCount++,迭代器做出remove()动作后将expectecModCount++,保证迭代期间二者保持一致
        private int expectedModCount = modCount;


        //okToRemove在next()执行后被置为true,在迭代器自己的remove()执行完后置为false,迭代器自己的remove()执行前检查其是否为true才执行，保证迭代一次才能删除一个，没有其他迭代时删除的方式
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public AnyType next(){
            if(modCount !=expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if(!hasNext())
                throw new java.util.NoSuchElementException();
            //用一个引用指向并从外部类获取前一个元素数据
            AnyType curItem = current.data;
            //实际是改变一个引用的指向使其前进
            current = current.next;
            okToRemove = true;
            return  curItem;
        }

        public void remove(){
            if(modCount !=expectedModCount)
                throw new java.util.ConcurrentModificationException();
            //不是迭代期间调用此迭代器remove()方法
            if(!okToRemove)
                throw new IllegalStateException();
            //调用外部类方法
            //next()使current先指向下一元素，这里移除current前一个元素，这样边迭代边移除，先后移后删除前一个元素
            MytestLink.this.remove(current.pre);
            okToRemove = false;
            expectedModCount --;
        }

    }
}
