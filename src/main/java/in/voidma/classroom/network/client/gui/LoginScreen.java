package in.voidma.classroom.network.client.gui;

import fisica.FWorld;
import fisica.Fisica;
import in.voidma.classroom.network.client.Client;

/**
 * Created by Zane on 4/4/2017.
 */
public class LoginScreen extends Screen{

    FWorld world;
    String nickname;

    public LoginScreen(Client client) {
        super(client);

        Fisica.init(client);
        this.world = new FWorld();
    }

    @Override
    public void update(int seconds) {

    }

    @Override
    public void keyPressed(){
        nickname += processing.key;
        if (processing.key == processing.ENTER){

        }
    }


    @Override
    public void draw() {

        processing.background(0,77,153);
        processing.rectMode(processing.CENTER);
        processing.rect(processing.height/2, processing.width/2, 600, 300);
        processing.textAlign(processing.CENTER, processing.BOTTOM);
        processing.textSize(30);
        processing.text("InputOutput.io", processing.height/2, processing.width/2);
        processing.textSize(20);
        processing.text("Enter a nickname", processing.height/2, processing.width/2);


    }

    private void transitionToPlayState() {
        PlayScreen playScreen = new PlayScreen(processing, world);
        processing.setGui(playScreen);
    }
}
