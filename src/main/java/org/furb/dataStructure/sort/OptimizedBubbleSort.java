package org.furb.dataStructure.sort;

public class OptimizedBubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public OptimizedBubbleSort(T[] info) {
        super(info);
    }

    @Override
    public void sort() {
        boolean swapped = false;
        for (int i = getInfo().length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
