package degisn.iterator.test3;

public class LinkedList_ implements Collection_{
    Node head;
    Node tail;
    private int index = 0;
    @Override
    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;
        if(head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        index++;
    }
    @Override
    public int size() {
        return index;
    }
    class Node {
        Object o;
        Node next;
        public Node(Object o) {
            this.o = o;
        }
    }
}
