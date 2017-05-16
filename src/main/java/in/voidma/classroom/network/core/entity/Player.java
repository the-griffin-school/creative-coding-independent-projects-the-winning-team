package in.voidma.classroom.network.core.entity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by schan on 5/16/2017.
 */
public class Player extends Entity {

    int color;
    ArrayList<Cell> cells;
    String name;

    public Player(int color, String name) {
        this.color = color;
        this.name = name;

        cells = new ArrayList<Cell>();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void removeCell(Cell cell) {
        cells.remove(cell);
    }
}
