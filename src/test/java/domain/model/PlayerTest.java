package domain.model;

import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import domain.wrapper.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {

    Ladder ladder;
    @BeforeEach
    void setUp() {
        ladder = new Ladder(new Height(3), new Width(4));

        Layer layer1 = new Layer();
        layer1.makeLine(true);
        layer1.makeLine(false);
        layer1.makeLine(true);

        Layer layer2 = new Layer();
        layer2.makeLine(false);
        layer2.makeLine(true);
        layer2.makeLine(false);

        Layer layer3 = new Layer();
        layer3.makeLine(true);
        layer3.makeLine(false);
        layer3.makeLine(true);

        ladder.addLayer(layer1);
        ladder.addLayer(layer2);
        ladder.addLayer(layer3);
    }
    @Test
    void move() {
        Player player = Player.of(new Name("name1"), Position.of(0));

        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(1);
        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(2);
        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(3);

    }
}