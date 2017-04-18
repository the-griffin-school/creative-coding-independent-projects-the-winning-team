package in.voidma.classroom.network.core.gameplay.newEntity;

import in.voidma.classroom.network.core.gameplay.entity.IPlayer;

public interface ICell extends IEntity, IPhisicsObject, IDatabaseObject {

    IPlayer getPlayer();

    void setPlayer(IPlayer player);


}
