//
//  o8o                                         .        88                           .                              .        o8o
//  `"'                                       .o8       .8'                         .o8                            .o8        `"'
// oooo  ooo. .oo.   oo.ooooo.  oooo  oooo  .o888oo    .8'   .ooooo.  oooo  oooo  .o888oo oo.ooooo.  oooo  oooo  .o888oo     oooo   .ooooo.
// `888  `888P"Y88b   888' `88b `888  `888    888     .8'   d88' `88b `888  `888    888    888' `88b `888  `888    888       `888  d88' `88b
//  888   888   888   888   888  888   888    888    .8'    888   888  888   888    888    888   888  888   888    888        888  888   888
//  888   888   888   888   888  888   888    888 . .8'     888   888  888   888    888 .  888   888  888   888    888 . .o.  888  888   888
// o888o o888o o888o  888bod8P'  `V88V"V8P'   "888" 88      `Y8bod8P'  `V88V"V8P'   "888"  888bod8P'  `V88V"V8P'   "888" Y8P o888o `Y8bod8P'
//                    888                                                                  888
//                   o888o                                                                o888o
//
// Miles Silberling-Cook
// Zane Alversomething
// Samantha Channow
//

package in.voidma.classroom.network.client;

import in.voidma.classroom.network.client.gui.LoginScreen;
import in.voidma.classroom.network.client.gui.Screen;
import in.voidma.classroom.network.core.network.NetworkManager;
import processing.core.PApplet;
import processing.event.KeyEvent;


/**
 * This class is the main entry point for the Professing Client class.
 * Also starts net code.
 *
 * @author Miles
 * @author Zane
 */
public class Client extends PApplet {

    private static Client INSTANCE;
    private Screen gui;
    private int lastUpdate;
    private NetworkManager networkManager;

    public static void main(String[] args) {
        PApplet.main(Client.class, args);
    }

    public static Client getInstance() {
        return INSTANCE;
    }

    @Override
    public void settings() {
        Client.INSTANCE = this;
        size(800, 800);
        smooth();
    }

    @Override
    public void setup() {
        // Networking Setup

        // Graphics Setup
        gui = new LoginScreen(this);
    }

    @Override
    public void draw() {
        gui.update(millis() - lastUpdate);
        lastUpdate = millis();
        gui.draw();
    }

    public void setGui(Screen gui) {
        this.gui = gui;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    @Override
    public void keyPressed() {
        gui.keyPressed();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        gui.keyPressed(event);
    }
}
