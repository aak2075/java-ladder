package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.List;

public interface SimpleList<T> {

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    static <E> SimpleList<E> fromArrayToList(final E[] values){
        return new SimpleArrayList<>(values);
    }

    boolean remove(T value);

    T remove(int index);

    void clear();
}
