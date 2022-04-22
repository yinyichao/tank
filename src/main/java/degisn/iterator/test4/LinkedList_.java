package degisn.iterator.test4;

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

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {
        Node current;
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex >= index ? false : true;
        }

        @Override
        public Object next() {
            if (current == null) {
                current = head;
            } else {
                current = current.next;
            }
            currentIndex++;
            return current;
        }
    }

    private class Node {
        Object o;
        Node next;
        public Node(Object o) {
            this.o = o;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "o=" + o +
                    '}';
        }
    }
}
