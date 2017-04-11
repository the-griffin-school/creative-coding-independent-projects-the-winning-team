package in.voidma.classroom.network.client.gui;

import fisica.FWorld;
import fisica.Fisica;
import in.voidma.classroom.network.client.Client;

/**
 * Created by Zane on 4/4/2017.
 */
public class LoginScreen extends Screen{

    FWorld world;

    public LoginScreen(Client client) {
        super(client);

        Fisica.init(client);
        this.world = new FWorld();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

        processing.background(0,77,153);
    }

    private void transitionToPlayState() {
        PlayScreen playScreen = new PlayScreen(processing, world);
        processing.setGui(playScreen);
    }
}
