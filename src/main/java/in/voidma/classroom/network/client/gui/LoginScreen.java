package in.voidma.classroom.network.client.gui;

import fisica.FCompound;
import in.voidma.classroom.network.client.Client;

/**
 * Created by Zane on 4/4/2017.
 */
public class LoginScreen extends Screen {

    String nickname;

    public LoginScreen(Client client) {
        super(client);
    }

    @Override
    public void update(int seconds) {
        world.step(seconds);
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

        world.draw();

        processing.rectMode(processing.CENTER);
        processing.rect(processing.height/2, processing.width/2, 600, 300);
        processing.textAlign(processing.CENTER, processing.BOTTOM);
        processing.textSize(30);
        processing.text("InputOutput.io", processing.height/2, processing.width/2);
        processing.textSize(20);
        processing.text("Enter a nickname", processing.height/2, processing.width/2);


    }

    private void transitionToPlayState(FCompound compound) {
        PlayScreen playScreen = new PlayScreen(processing, world, compound);
        processing.setGui(playScreen);
    }
}
