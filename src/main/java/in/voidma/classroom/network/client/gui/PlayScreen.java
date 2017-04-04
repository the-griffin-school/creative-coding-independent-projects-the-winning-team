package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.client.entity.Drawable;

/**
 * Created by Zane on 4/4/2017.
 */
public class PlayScreen extends Screen {

    public PlayScreen(Client client) {
        super(client);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        database.getAll().stream()
                .filter(e -> e instanceof Drawable)
                .forEach(e -> ((Drawable) e).draw(processing));
    }
}
