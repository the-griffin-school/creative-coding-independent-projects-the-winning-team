package in.voidma.classroom.network.core.entity;

/**
 * Created by schan on 5/16/2017.
 */
public class Cell extends Blob {

    private Player player;

    public Cell(Player player, int mass, long x, long y) {
        super(mass, x, y);
        this.player = player;
    }

    public void consume() {

    }

}
