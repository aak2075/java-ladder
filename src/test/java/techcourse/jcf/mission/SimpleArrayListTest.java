package techcourse.jcf.mission;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SimpleArrayListTest {
    SimpleList<String> values;

    @BeforeEach
    void setUp() {
        values = new SimpleArrayList<>();
    }

    @Test
    void add() {
        assertThat(values.add("first")).isTrue();
        assertThat(values.get(0)).isEqualTo("first");
    }

    @Test
    void testAdd() {
        values.add("first");
        values.add(0, "zero");
        assertThat(values.get(0)).isEqualTo("zero");
    }

    @Test
    void set() {
        values.add("first");
        values.add("third");
        assertThat(values.set(1, "second")).isEqualTo("second");
        assertThat(values.get(1)).isEqualTo("second");
    }

    @Test
    void get() {
        values.add("first");
        assertThat(values.get(0)).isEqualTo("first");
    }

    @Test
    void contains() {
        values.add("first");
        values.add("second");

        assertThat(values.contains("first")).isTrue();
    }

    @Test
    void indexOf() {
        values.add("first");
        values.add("second");
        values.add("third");

        assertThat(values.indexOf("second")).isEqualTo(1);
    }

    @Test
    void size() {
        values.add("first");

        assertThat(values.size()).isEqualTo(1);

        values.add("second");

        assertThat(values.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        assertThat(values.isEmpty()).isTrue();
        values.add("first");
        assertThat(values.isEmpty()).isFalse();

    }

    @Test
    void remove() {
        values.add("first");
        values.add("second");
        values.add("third");

        assertThat(values.remove(1)).isEqualTo("second");
        assertThat(values.remove(1)).isEqualTo("third");
        assertThat(values.remove(0)).isEqualTo("first");

        values.add("first");
        values.add("second");
        values.add("third");

        assertThat(values.remove("second")).isTrue();
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.get(1)).isEqualTo("third");
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
        values.add("first");
        values.add("second");
        values.add("third");

        values.clear();

        assertThat(values.size()).isEqualTo(0);
        assertThatThrownBy(() -> values.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void fromArrayToList() {
        final String[] arrays = {"first", "second"};

        final SimpleList<String> values = SimpleList.<String>fromArrayToList(arrays);
        assertThat(values.contains("first")).isTrue();
        assertThat(values.contains("second")).isTrue();
    }

    @Test
    void mission3() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(1, 2);

        final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
        final double intTotal = SimpleList.sum(intValues); // 3

        assertThat(doubleTotal).isEqualTo(1.2);
        assertThat(intTotal).isEqualTo(3);
    }

    @Test
    void mission4() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(-0.1, 0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(-10, 1, 2);

        final SimpleList<Double> filteredDoubleValues = SimpleList.filterNegative(doubleValues);
        final SimpleList<Integer> filteredIntValues = SimpleList.filterNegative(intValues);

        assertThat(filteredDoubleValues.get(0)).isEqualTo(0.5);
        assertThat(filteredDoubleValues.get(1)).isEqualTo(0.7);
        assertThat(filteredIntValues.get(0)).isEqualTo(1);
        assertThat(filteredIntValues.get(1)).isEqualTo(2);
    }
}
