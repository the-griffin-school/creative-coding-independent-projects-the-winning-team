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

package in.voidma.classroom.network.client.entity;

import fisica.FBlob;
import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;
import in.voidma.classroom.network.core.gameplay.entity.ICell;
import processing.core.PApplet;
import processing.core.PConstants;


/**
 * The client implementation of the common ICell class.
 *
 * @author Miles
 * @author Zane
 * @author Sam
 */
public class Cell extends ICell {

    protected Player player;
    protected FBlob blob;

    public Cell(Player player, Location location, Velocity velocity) {
        super(player, location, velocity);
        blob.setAsCircle(mass);
    }

    public void draw(PApplet processing) {

        float angle = PConstants.TWO_PI / (float) 25;

        processing.fill(player.color);
        processing.stroke(processing.lerpColor(player.color, processing.color(0), .2f));

        processing.beginShape();

        for (int i = 0; i < points; i++) {
            processing.point(
                    mass * PApplet.sin(angle * i),
                    mass * PApplet.cos(angle * i)
            );
        }

        processing.endShape(PConstants.CLOSE);
    }
}
