package degisn.iterator.test5;

public class LinkedList_<E> implements Collection_<E> {
    Node head;
    Node tail;
    private int index = 0;
    @Override
    public void add(E o) {
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
        public E next() {
            if (current == null) {
                current = head;
            } else {
                current = current.next;
            }
            currentIndex++;
            return (E)current.o;
        }
    }

    private class Node<E> {
        E o;
        Node next;
        public Node(E o) {
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
