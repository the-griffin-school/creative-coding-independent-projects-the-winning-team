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

import in.voidma.classroom.network.client.entity.Cell;
import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;
import processing.core.PApplet;


/**
 * This class is the main entry point for the Professing Client class.
 * Also starts net code.
 *
 * @author Miles
 * @author Zane
 */
public class Client extends PApplet {

    Cell cell;
    PApplet p = new PApplet();

    public static void main(String[] args) {
        PApplet.main(Client.class, args);
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        p.background(0);
        cell = new Cell(new Location(), new Velocity(0, 0), p);

    }

    @Override
    public void draw() {
        //background(0);
        p.fill(255);
        p.ellipse(height/2, width/2,50,50);
        p.noStroke();
        cell.display();
        //cell.move();
    }
}
