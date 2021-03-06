package degisn.iterator.test3;

public class ArrayList_ implements Collection_{
    Object[] objects = new Object[10];
    private int index = 0;
    @Override
    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 10];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index++] = o;
    }
    @Override
    public int size() {
        return index;
    }
}
