package in.voidma.classroom.network.core.gameplay.newEntity;

public interface IPhisicsObject {

    void add();

    void delete();

    int getMass();

    void setMass(int mass);

    void setPosition(float x, float y);

    float getX();

    void setX(float x);

    float getY();

    void setY(float y);

    void setForce(float fx, float fy);

    float getForceX();

    void setForceX(float fx);

    float getForceY();

    void setForceY(float fy);

}
