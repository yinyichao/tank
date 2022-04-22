package degisn.iterator.test5;

public class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[])new Object[10];
    private int index = 0;
    @Override
    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[])new Object[objects.length * 10];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index++] = o;
    }
    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex >= index ? false : true;
        }

        @Override
        public E next() {
            return objects[currentIndex++];
        }
    }
}
