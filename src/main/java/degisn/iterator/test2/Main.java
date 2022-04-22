package degisn.iterator.test2;

public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

class LinkedList_ {
    Node head;
    Node tail;
    int index = 0;

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
