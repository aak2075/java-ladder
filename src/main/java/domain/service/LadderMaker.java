package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.vo.Height;
import domain.vo.Width;

public class LadderMaker {
    private final BooleanGenerator booleanGenerator;

    public LadderMaker(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder make(final Height height, final Width width) {
        Ladder ladder = new Ladder(height, width);
        for (int i = 0; i < height.getValue(); i++) {
            ladder.addLayer(makeLayer(width.getValue()));
        }
        return ladder;
    }

    private Layer makeLayer(final int lineCount) {
        Layer layer = new Layer();
        for (int i = 0; i < lineCount; i++) {
            layer.makeLine(booleanGenerator.generate());
        }
        return layer;
    }
}
