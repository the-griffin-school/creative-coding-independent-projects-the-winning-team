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

package in.voidma.classroom.network.core.gameplay.entity;

import java.util.UUID;

/**
 * Common cell data class
 *
 * @author Miles
 */
@Deprecated
public class ICell extends Entity {

    protected IPlayer player;
    protected int mass;

    public ICell(IPlayer player) {
        super(UUID.randomUUID());
        this.player = player;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
