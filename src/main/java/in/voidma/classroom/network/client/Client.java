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
import processing.core.PApplet;


/**
 * This class is the main entry point for the Professing Client class.
 * Also starts net code.
 *
 * @author Miles
 * @author Zane
 */
public class Client extends PApplet {

    private Screen gui;
    private PApplet p = new PApplet();

    public static void main(String[] args) {
        PApplet.main(Client.class, args);
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        // Networking Setup

        // Graphics Setup
        p.background(0);

        gui = new LoginScreen(this);
    }

    @Override
    public void draw() {
        gui.update();
        gui.draw();
    }

    public void setGui(Screen gui) {
        this.gui = gui;
    }

    public PApplet getProsessing() {
        return p;
    }
}
