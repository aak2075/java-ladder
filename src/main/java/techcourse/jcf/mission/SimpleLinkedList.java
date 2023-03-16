package techcourse.jcf.mission;

public class SimpleLinkedList<E> implements SimpleList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean add(E value) {
        if (first == null) {
            first = new Node<>(null, value, null);
            last = first;
            size = size + 1;
            return true;
        }
        last.next = new Node<>(last, value, null);
        last = last.next;
        size = size + 1;
        return true;
    }

    // index = 1, now
    @Override
    public void add(int index, E value) {
        if (index == 0) {
            Node<E> newNode = new Node<>(null, value, first);
            first.prev = newNode;
            first = newNode;
            size = size + 1;
            return;
        }
        // 0 first 1 second 2 fourth || index : 2, value : third
        if (index > 0 && index < size) {
            Node<E> now = first;
            for (int i = 0; i < index; i++) {
                now = now.next;
            }
            Node<E> newNode = new Node<>(now.prev, value, now);
            now.prev.next = newNode;
            now.prev = newNode;
            size = size + 1;
            return;
        }
        if (index == size) {
            Node<E> newNode = new Node<>(last, value, null);
            last.next = newNode;
            last = newNode;
            size = size + 1;
            return;
        }
        if (index == size + 1) {
            add(value);
        }

    }

    @Override
    public E set(int index, E value) {
        Node<E> now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        E oldItem = now.item;
        now.item = value;
        return oldItem;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return now.item;
    }

    @Override
    public boolean contains(E value) {
        Node<E> now = first;
        while (!now.item.equals(value)) {
            if (now.next == null) {
                return false;
            }
            now = now.next;
        }
        return true;
    }

    @Override
    public int indexOf(E value) {
        Node<E> now = first;
        int count = 0;
        while (now.next != null) {
            if (value.equals(now.item)) {
                return count;
            }
            count = count + 1;
            now = now.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (first == null) && (last == null);
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return remove(index).equals(value);
    }

    @Override
    public E remove(int index) {
        Node<E> now = first;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        E item = now.item;
        if (index == 0) {
            now.next.prev = null;
            first = now.next;
            return item;
        }
        if (index > 0 && index < size - 1) {
            now.next.prev = now.prev;
            now.prev.next = now.next;
            return item;
        }
        if (index == size - 1) {
            now.prev.next = null;
            last = now.prev;
            return item;
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


}
