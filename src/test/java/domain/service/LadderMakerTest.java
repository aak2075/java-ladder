package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderMakerTest {
    private static final BooleanGenerator TRUE_BOOLEAN_GENERATOR = () -> true;
    private static final BooleanGenerator FALSE_BOOLEAN_GENERATOR = () -> false;

    private LadderMaker ladderMaker;

    @Test
    @DisplayName("사다리를 생성한다")
    void ladderMake() {
        ladderMaker = new LadderMaker(new RandomBooleanGenerator());
        Ladder ladder = ladderMaker.make(5, 5);

        assertThat(ladder.getHeight()).isEqualTo(5);
        assertThat(ladder.getWidth()).isEqualTo(5);
    }

    @Test
    @DisplayName("생성조건이 TRUE이면 다리가 연속으로 연결되 않게 사다리를 생성한다.")
    void ladderMakerAlwaysTrueTest() {
        ladderMaker = new LadderMaker(TRUE_BOOLEAN_GENERATOR);
        Ladder ladder = ladderMaker.make(5, 5);

        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            assertEachLineTrue(layer);
        }
    }

    @Test
    @DisplayName("생성조건이 FALSE이면 모든 다리가 연결되지 않게 사다리를 생성한다.")
    void ladderMakerAlwaysFalseTest() {
        ladderMaker = new LadderMaker(FALSE_BOOLEAN_GENERATOR);
        Ladder ladder = ladderMaker.make(5, 5);

        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            assertEachLineFalse(layer);
        }
    }

    private void assertEachLineTrue(final Layer layer) {
        for (int i = 0; i < layer.getLines().size(); i++) {
            assertLineTrue(i, layer);
        }
    }

    private void assertLineTrue(int index, Layer layer) {
        if (index % 2 == 0) {
            assertThat(layer.getLines().get(index)).isTrue();
        }
        if (index % 2 == 1) {
            assertThat(layer.getLines().get(index)).isFalse();
        }
    }

    private void assertEachLineFalse(final Layer layer) {
        for (int i = 0; i < layer.getLines().size(); i++) {
            assertThat(layer.getLines().get(i)).isFalse();
        }
    }

}
