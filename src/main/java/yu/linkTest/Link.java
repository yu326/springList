package yu.linkTest;

/**
 * Created by koreyoshi on 2017/7/27.
 */
public class Link {
    //头结点
    Node head = null;

    //节点类
    public class Node {
        Node next = null;
        Object data;

        public Node(Object data) {
            this.data = data;
        }
    }

    public void addNode(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = newNode;
    }


    public void findAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public Boolean deleteNode(int index) {
        if (index > getLength() || index < 0) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }
        Node tmp = head;
        int i = 1;
        Node preNode = head;
        Node curNode = head.next;
        while (tmp != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }


    public int getLength() {
        Node tmp = head;
        int num = 0;
        while (tmp != null) {
            num++;
            tmp = tmp.next;
        }
        return num;
    }

    public static void main(String[] args) {
        Link link = new Link();
        link.addNode("suixin");
        System.out.println("after add suixin is:");
        link.findAll();
        System.out.println("------------");
        link.addNode("yu");
        link.addNode("yu1");
        link.addNode("yu2");
        System.out.println("after add yu is:");
        link.findAll();
        System.out.println("------------");
        System.out.println("the arr length :" + link.getLength());
        link.deleteNode(3);
        link.findAll();
        System.out.println("the arr length :" + link.getLength());
    }


}
