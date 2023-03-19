package techcourse.jcf.mission;

public interface SimpleList<E> {

    static <E extends Number> SimpleList<E> filterNegative(SimpleList<? extends E> values) {
        SimpleList<E> list = new SimpleArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).doubleValue() > 0) {
                list.add(values.get(i));
            }
        }

        return list;
    }

    static <E extends Number> double sum(SimpleList<E> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum = sum + values.get(i).doubleValue();
        }
        return sum;
    }

    static <E> SimpleList<E> fromArrayToList(final E[] values) {
        return new SimpleArrayList<>(values);
    }

    boolean add(E value);

    void add(int index, E value);

    E set(int index, E value);

    E get(int index);

    boolean contains(E value);

    int indexOf(E value);

    int size();

    boolean isEmpty();

    boolean remove(E value);

    E remove(int index);

    void clear();
}
