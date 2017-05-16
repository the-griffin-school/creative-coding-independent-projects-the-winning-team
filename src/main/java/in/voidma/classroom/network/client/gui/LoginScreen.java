package in.voidma.classroom.network.client.gui;

import in.voidma.classroom.network.client.Client;
import in.voidma.classroom.network.core.network.NetworkManager;
import processing.core.PConstants;

import java.net.InetAddress;

/**
 * Created by Zane on 4/4/2017.
 */

public class LoginScreen extends Screen {

    public LoginScreen(Client client, InetAddress address, int port) {
        super(client);

        NetworkManager networkManager = NetworkManager.createNetworkManagerAndConnect(address, port, true);

        processing.background(0, 77, 153);
        // Draw here

        cp5.addTextfield("nickname", (processing.width / 2) - 150, processing.height / 2, 300, 50);

        processing.rectMode(PConstants.CENTER);
        processing.rect(processing.width / 2, processing.height / 2, 600, 400, 10);
        processing.textAlign(PConstants.CENTER, PConstants.BOTTOM);
        processing.textSize(30);
        processing.text("InputOutput.io", processing.width / 2, processing.height / 2);
        processing.textSize(20);
        processing.text("Enter a nickname", processing.width / 2, processing.height / 2);
    }

    @Override
    public void update(int seconds) {
        //Step simulation here
    }

    @Override
    public void draw() {

    }

    public void nickname(String theValue) {
       System.out.println("### got an event from textA : "+theValue);
    }

    private void transitionToPlayState() {

        PlayScreen playScreen = new PlayScreen(processing, null);
        processing.setGui(playScreen);
    }
}
