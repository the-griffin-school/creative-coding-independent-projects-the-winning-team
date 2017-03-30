package in.voidma.classroom.network.core.gameplay;

public class PCell extends Entity {

    protected float x, y, w, h;

    public PCell(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
