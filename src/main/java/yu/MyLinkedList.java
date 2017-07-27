package yu;

//自定义双向链表
//实现Iterable接口，可迭代
//
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    //声明为static,嵌套类，类的一部分，并且独立于外围类对象存在
    private static class Node<AnyType> {
        //初始化：值，前驱和后继节点
        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }

        //外围均可访问
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        //endMarker后于beginMarker定义，初始化时指向beginMarker,beginMarker无法在初始化时指向endMarker
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //加到末尾
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx), x);
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

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);//双链表，新增节点插入指向前后
        //前后两个节点的指向变化
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        //修改次数+1
        modCount++;
    }

    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        //修改次数仍+1
        modCount++;
        return p.data;
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

    public java.util.Iterator<AnyType> iterator() {
        //返回一个实例化的内部类，该类是迭代器，内部实现
        return new LinkedListIterator();
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
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;
}