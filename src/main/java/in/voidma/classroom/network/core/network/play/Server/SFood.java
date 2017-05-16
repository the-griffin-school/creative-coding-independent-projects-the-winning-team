package in.voidma.classroom.network.core.network.play.Server;

import in.voidma.classroom.network.core.network.play.INetHandlerPlayClient;

import java.util.UUID;

/**
 * Created by Miles on 5/16/2017.
 */
public class SFood extends SBlob {

    public SFood(UUID uuid, int mass, float x, float y) {

        super(uuid, mass, x, y);
    }

    public void processPacket(INetHandlerPlayClient handler) {

        handler.processFood(this);
    }
}
