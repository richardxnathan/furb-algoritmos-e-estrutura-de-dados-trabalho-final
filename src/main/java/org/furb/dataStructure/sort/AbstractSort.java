package org.furb.dataStructure.sort;

public abstract class AbstractSort<T extends Comparable<T>> {
    private T[] info;

    public AbstractSort(T[] info) {
        this.info = info;
    }

    public void swap(int a, int b) {
        if(a == b) return;

        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    public abstract void sort();

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }
}
