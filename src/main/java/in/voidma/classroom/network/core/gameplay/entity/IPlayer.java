package in.voidma.classroom.network.core.gameplay.entity;

import java.util.ArrayList;
import java.util.UUID;

public class IPlayer extends Entity {

    public IPlayer(UUID uuid, String name, ArrayList<ICell> cells) {
        super(UUID.randomUUID());
        this.name = name;
        this.cells = cells;
    }

    private String name;

    public IPlayer(UUID uuid, String name, ArrayList<ICell> cells) {
        super(UUID.randomUUID());
        this.name = name;
        this.cells = cells;
    }

    private ArrayList<ICell> cells;
}
