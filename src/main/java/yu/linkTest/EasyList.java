package yu.linkTest;

/**
 * Created by koreyoshi on 2017/7/28.
 */
public class EasyList {
    Node head = null;

    public class Node {
        Object data = null;
        Node next;

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
        Node headNode = head;
        while (headNode.next != null) {
            headNode = headNode.next;
        }
        headNode.next = newNode;
    }

    public void findAll() {
        Node curNode = head;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    public int getLength(){
        Node curNode = head;
        int num =0;
        while (curNode != null) {
            num++;
            curNode = curNode.next;
        }
        return num;
    }

    public static void main(String[] args) {
        EasyList list = new EasyList();
        list.addNode("123");
        list.addNode("123");
        list.addNode("123");
        list.findAll();
        System.out.println(list.getLength());

    }


}
