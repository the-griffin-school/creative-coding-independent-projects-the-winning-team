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

package in.voidma.classroom.network.core.protocol;

import io.netty.buffer.ByteBuf;

/**
 * Encodes a Packet into serializable data with ID and Payload
 *
 * @author Miles
 * @author Sam
 */
public class Envelope {
    private byte id;
    private ByteBuf payload;
    //constructor
    Envelope() {
    }
    //base functions to be inherited
    byte getID() {
        return id;
    }

    void setID(byte type) {
        this.id = type;
    }

    ByteBuf getPayload() {
        return payload;
    }

    void setPayload(ByteBuf payload) {
        this.payload = payload;
    }
}