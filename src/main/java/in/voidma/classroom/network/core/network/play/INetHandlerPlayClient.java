package in.voidma.classroom.network.core.network.play;

import in.voidma.classroom.network.core.network.INetHandler;
import in.voidma.classroom.network.core.network.play.Server.*;

public interface INetHandlerPlayClient extends INetHandler {

    void processCell(SCell packet);

    void processMassUpdate(SMassUpdate packet);

    void processMove(SMove packet);

    void processDeregister(SDeregister packet);

    void processDeath(SDeath packet);
}
