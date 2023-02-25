package domain.model;

import domain.vo.Name;
import domain.wrapper.Position;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name) {
        this.name = name;
    }

    public void initPosition(final int index) {
        position = Position.of(index);
    }

    public void move(Ladder ladder) {
        if (ladder.hasLeftAt(position)) {
            moveLeft();
            return;
        }
        if (ladder.hasRightAt(position)) {
            moveRight();
            return;
        }
        position.addY();
    }

    private void moveLeft() {
        position.subX();
        position.addY();
    }

    private void moveRight() {
        position.addX();
        position.addY();
    }

    public int getXPosition() {
        return position.getX();
    }

    public int getYPosition() {
        return position.getY();
    }

    public Name getName() {
        return name;
    }
}
