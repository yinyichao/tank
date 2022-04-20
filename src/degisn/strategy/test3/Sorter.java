package degisn.strategy.test3;


/**
 * 这是针对int的排序
 * 如果是float呢？
 */
public class Sorter {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i].compareTo(a[j]) == 1) {
                    swap(a,i,j);
                }
            }
        }
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
