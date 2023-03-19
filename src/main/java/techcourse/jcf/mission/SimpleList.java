package techcourse.jcf.mission;

import java.util.Arrays;
import java.util.List;

public interface SimpleList<E> {

    boolean add(E value);

    void add(int index, E value);

    E set(int index, E value);

    E get(int index);

    boolean contains(E value);

    int indexOf(E value);

    int size();

    boolean isEmpty();

    static <E extends Number> double sum(SimpleList<E> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum = sum + values.get(i).doubleValue();
        }
        return sum;
    }

    static <E> SimpleList<E> fromArrayToList(final E[] values){
        return new SimpleArrayList<>(values);
    }

    boolean remove(E value);

    E remove(int index);

    void clear();
}
