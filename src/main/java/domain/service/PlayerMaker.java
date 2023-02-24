package domain.service;

import domain.model.Players;
import domain.vo.Names;

public class PlayerMaker {

    public Players make(Names names) {
        return new Players(names.mapToPlayers());
    }
}