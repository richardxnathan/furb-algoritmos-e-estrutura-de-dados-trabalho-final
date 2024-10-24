package org.furb.dataStructure;

public class StaticList<T> {
    private Object[] info;
    private int size;

    public StaticList() {
        this.info = new Object[10];
        size = 0;
    }

    private void resize() {
        Object[] temp = new Object[info.length + 10];

        for (int i = 0; i < size; i++) {
            temp[i] = info[i];
        }
        info = temp;
    }

    public void insert(T x) {
        if (size == info.length)
            resize();

        info[size] = x;
        size++;
    }

    public int search(T x) {
        for (int i = 0; i < size; i++) {
            if (info[i].equals(x)) return i;
        }
        return -1;
    }

    public void remove(T x) {
        int index = search(x);

        if (index == -1) throw new IllegalArgumentException("Number not found");

        if (index == size) info[index] = null;

        for (int i = index; i < size; i++) {
            info[i] = info[i + 1];
        }

        size--;
    }

    public void removeElementsInRange(int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            info[i] = null;
        }
        for (int i = fim + 1; i < size; i++) {
            info[i - (fim - inicio + 1)] = info[i];
        }
        size = size - (fim - inicio + 1);
    }

    public void free() {
        info = new Object[10];
        size = 0;
    }

    public T get(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        return (T) info[index];
    }

    public void invert() {
        int j = size - 1;

        for (int i = 0; i < j; i++) {
            T firstValue = get(i);
            info[i] = info[j];
            info[j] = firstValue;
            j--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String toStringList = "";
        for (int i = 0; i < size; i++) {
            toStringList = toStringList.concat(info[i] + ",");

            if (i == size - 1) {
                toStringList = toStringList.substring(0, toStringList.length() - 1);
            }
        }
        return toStringList;
    }
}
