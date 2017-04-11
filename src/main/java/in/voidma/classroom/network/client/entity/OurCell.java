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

import in.voidma.classroom.network.core.gameplay.Location;
import in.voidma.classroom.network.core.gameplay.Velocity;

/**
 * The client implementation of the common IPlayer class.
 *
 * @author Zane
 * @author Sam
 */
public class OurCell extends Cell {

    public OurCell(Player player, Location location, Velocity velocity) {
        super(player, location, velocity);
    }

    public void move(int mouseX, int mouseY) {
        float Xdif = mouseX - 25;
        float Ydif = mouseY - 25;
        float angle = (float)(Math.atan2(Ydif, Xdif) * 180 / Math.PI);
        float dX = (float)Math.cos(angle * Math.PI/180) * 8;
        float dY = (float)Math.sin(angle * Math.PI/180) * 8;
        setVelocity(new Velocity(dX, dY));
    }
}
