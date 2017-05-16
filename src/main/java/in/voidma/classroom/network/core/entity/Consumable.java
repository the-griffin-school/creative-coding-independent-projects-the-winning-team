package in.voidma.classroom.network.core.entity;

import in.voidma.classroom.network.core.util.Color;

import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public class Consumable extends Blob {

    Color color;

    public Consumable(UUID id, int mass, float x, float y) {

        super(id, mass, x, y);
        color = Color.randomColor();
    }

    @Override
    Color getColor() {

        return color;
    }
}
