package in.voidma.classroom.network.core.gameplay.newEntity;

import in.voidma.classroom.network.core.gameplay.entity.ICell;

import java.util.ArrayList;

public interface IPlayer extends IEntity, IDatabaseObject {

    String getName();

    void setName(String name);

    ArrayList<ICell> getCells();

    void setCells(ArrayList<ICell> cells);

    void addCell(ICell cell);

    void removeCells(ArrayList<ICell> cells);

    void removeCell(ICell cell);
}
