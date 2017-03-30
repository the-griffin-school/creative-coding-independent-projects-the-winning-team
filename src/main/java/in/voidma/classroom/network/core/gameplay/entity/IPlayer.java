package in.voidma.classroom.network.core.gameplay.entity;

import java.util.ArrayList;
import java.util.UUID;

public class IPlayer extends Entity {

    private String name;
    private ArrayList<ICell> cells;

    public IPlayer(String name, ArrayList<ICell> cells) {
        super(UUID.randomUUID());
        this.name = name;
        this.cells = cells;
    }
}
