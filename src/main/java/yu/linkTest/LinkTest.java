package yu.linkTest;

import java.util.Iterator;

/**
 * Created by koreyoshi on 2017/10/10.
 */
public class LinkTest<Anytype> implements Iterable<Anytype> {

    private int theSize;
    private int modCount = 0;
    private Node<Anytype> beginMarker;
    private Node<Anytype> endMarker;

    private static class Node<Anytype> {

        public Anytype data;
        public Node<Anytype> prev;
        public Node<Anytype> next;

        public Node(Anytype data, Node<Anytype> prev, Node<Anytype> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    //初始化链表
    public LinkTest() {
        beginMarker = new Node<Anytype>(null, null, null);
        endMarker = new Node<Anytype>(null, null, null);
        beginMarker.next = endMarker;
        endMarker.prev = beginMarker;
        theSize = 0;
        modCount++;
    }

    //清空链表
    public void clear() {
        beginMarker.next = endMarker;
        endMarker.prev = beginMarker;
        theSize = 0;
        modCount++;
    }

    //添加数据
    public boolean add(Anytype data) {
        return add(size(), data);
    }

    public boolean add(int idx, Anytype data) {

        return addBefore(getNode(idx), data);
    }

    //判断节点是在前半段还是后半段，略微提高效率
    public Node<Anytype> getNode(int idx) {
        Node<Anytype> p;//一个引用
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        //链表前半段
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++)
                p = p.next;
        } else {
            p = endMarker;
            for (int i = 0; i < size() - idx; i++)
                p = p.prev;
        }
        return p;
    }

    public boolean addBefore(Node<Anytype> oldNode, Anytype data) {
        Node<Anytype> newNode = new Node<Anytype>(data, oldNode.prev, oldNode);
        newNode.prev.next = newNode;
        oldNode.prev = newNode;
        theSize++;
        modCount++;
        return true;
    }


    // TODO: 2017/10/10 set
    public boolean set(int idx, Anytype data) {
        return add(idx, data);
    }

    //// TODO: 2017/10/10 get
    public Anytype get(int idx) {
        return getNode(idx).data;
    }

    //返回链表长度
    public int size() {
        return theSize;
    }

    //// TODO: 2017/10/10 remove
    public Anytype remove(int idx) {
        return remove(getNode(idx));
    }

    public Anytype remove(Node<Anytype> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        theSize--;
        modCount++;
        return node.data;
    }

    public boolean remove(Object data) {
        if (size() == 0)
            throw new IndexOutOfBoundsException();
        Node<Anytype> node;
        for (int i = 0; i < size(); i++) {
            node = beginMarker.next;
            if (data.equals(node.data)) {
                remove(node);
                break;
            }
        }
        return true;
    }

    public Iterator<Anytype> iterator() {
        return new LinkTest.LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Anytype> {

        private Node<Anytype> current = beginMarker.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public Anytype next() {
            if (modCount != expectedModCount)
                //同一时间修改冲突异常！！
                throw new java.util.ConcurrentModificationException();
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            Anytype nextItem = current.data;
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
            LinkTest.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }


    }


    //测试main方法
    public static void main(String[] args) {
        LinkTest linkTest = new LinkTest();
        linkTest.add("sui");
        System.out.println(linkTest.size());

        linkTest.add("xin");
        linkTest.add("yu");
        linkTest.add("yi");

        System.out.println(linkTest.size());

//        linkTest.clear();
//        System.out.println(linkTest.size());


//        System.out.println(linkTest.get(1));
//        System.out.println(linkTest.set(1,"koreyoshi"));
//        System.out.println(linkTest.get(1));
//        System.out.println(linkTest.remove(1));
//        System.out.println(linkTest.size());
//        System.out.println(linkTest.get(0));

//        List list = new ArrayList();
//        list.remove("a");
        linkTest.remove("sui");
        Iterator iterator = linkTest.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }


}
