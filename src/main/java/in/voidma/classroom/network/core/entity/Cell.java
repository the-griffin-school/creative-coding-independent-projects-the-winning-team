package in.voidma.classroom.network.core.entity;

import in.voidma.classroom.network.core.util.Color;

import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public class Cell extends Blob {

    private UUID playerID;

    public Cell(UUID id, UUID playerID, int mass, float x, float y) {

        super(id, mass, x, y);
        this.playerID = playerID;

        getPlayer().registerCell(this);
    }

    public void consume(Consumable consumable) {

        addMass(consumable.getMass());
        consumable.remove();
    }

    @Override
    Color getColor() {

        return getPlayer().getColor();
    }

    private Player getPlayer() {

        return entityStore.getPlayer(playerID);
    }

    @Override
    public void remove() {

        getPlayer().deregisterCell(this);
        super.remove();
    }
}
