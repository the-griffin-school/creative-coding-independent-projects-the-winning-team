package in.voidma.classroom.network.core.entity;

import in.voidma.classroom.network.core.util.Color;
import in.voidma.classroom.network.core.util.Location;
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

    public Location calculateCenterPoint() {

        //Weighted algebraic mean

        int totalMass = 0;
        float weightedX = 0;
        float weightedY = 0;

        for (UUID id : cells) {
            Cell cell = entityStore.get(id, Cell.class);

            totalMass += cell.getMass();
            weightedX += (float) cell.getMass() * cell.getX();
            weightedY += (float) cell.getMass() * cell.getY();
        }

        float averageX = weightedX / totalMass;
        float averageY = weightedY / totalMass;

        return new Location(averageX, averageY);
    }

    public int totalMass() {

        return cells
                .stream()
                .map(c -> entityStore.getBlob(c))
                .mapToInt(Blob::getMass)
                .sum();
    }
}
