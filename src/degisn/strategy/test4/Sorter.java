package degisn.strategy.test4;



/**
 * 这是针对int的排序
 * 如果是float呢？
 */
public class Sorter<T> {
    public void sort(T[] a,Comparator<T> comparator) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(comparator.compare(a[i],a[j])==1) {
                    swap(a,i,j);
                }
            }
        }
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
