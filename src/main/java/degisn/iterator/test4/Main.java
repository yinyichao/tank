package degisn.iterator.test4;

/**
 * v1:构造一个容器，可以添加对象
 * v2：用链表来实现一个容器
 * v3：添加容器的共同接口，实现容器的替换
 * v4：如何对容器遍历呢？
 */
public class Main {
    public static void main(String[] args) {
        Collection_ collection = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            collection.add(new String("s" + i));
        }
        System.out.println(collection.size());
        Iterator_ iterator_ = collection.iterator();
        while(iterator_.hasNext()) {
            System.out.println(iterator_.next());
        }
    }
}
