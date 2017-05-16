package in.voidma.classroom.network.core.entity;

import in.voidma.classroom.network.core.util.Color;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public class Player extends Entity implements Drawable {

    private Color color;
    private ArrayList<UUID> cells;
    private String name;

    public Player(UUID id, int color, String name) {

        super(id);
        this.color = Color.fromProsessingColor(color);
        this.name = name;

        cells = new ArrayList<UUID>();
    }

    public void draw(PApplet processing) {
        // TODO, DRAW PLAYER NAME
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int color) {

        this.color = Color.fromProsessingColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void registerCell(Cell cell) {

        cells.add(entityStore.get(cell));
    }

    public void deregisterCell(Cell cell) {

        cells.remove(entityStore.get(cell));
    }
}
