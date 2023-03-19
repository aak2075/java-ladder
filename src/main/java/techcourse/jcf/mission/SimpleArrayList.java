package techcourse.jcf.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleArrayList<E> implements SimpleList<E> {

    private static final int DEFAULE_SIZE = 10;

    private Object[] values;
    private int size;

    public SimpleArrayList() {
        values = new Object[DEFAULE_SIZE];
        size = 0;
    }

    public SimpleArrayList(E v1, E v2) {
        values = new Object[DEFAULE_SIZE];
        values[0] = v1;
        values[1] = v2;
        size = 2;
    }

    public SimpleArrayList(final E[] arrays) {
        size = arrays.length;
        values = new Object[size];
        System.arraycopy(arrays, 0, values, 0, arrays.length);
    }

    @Override
    public boolean add(E value) {
        if (size > values.length) {
            return false;
        }
        add(size, value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index == size) {
            expend();
        }

        values[index] = value;
        size = size + 1;
    }

    private void expend() {
        int newCapacity = values.length + (values.length >> 1);
        values = Arrays.copyOf(values, newCapacity);
    }

    @Override
    public E set(int index, E value) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        values[index] = value;
        return value;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (E) values[index];
    }

    @Override
    public boolean contains(E value) {
        for (Object o : values) {
            if (o.equals(value)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(E value) {

        for (int i = 0; i < values.length; i++) {
            if (value.equals(values[i].toString())) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) values[index];
        final int newSize;
        newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(values, index + 1, values, index, newSize - 1);
        }
        values[size] = null;
        size = newSize;

        return oldValue;
    }

    @Override
    public void clear() {
        Arrays.fill(values, null);
        size = 0;
    }

}
