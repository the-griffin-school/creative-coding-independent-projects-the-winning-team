package in.voidma.classroom.network.client.phisics;

import com.google.common.collect.BiMap;
import fisica.FWorld;

import java.util.UUID;

/**
 * TODO: Fill out javaDoc coment for in.voidma.classroom.network.client.phisics:World
 *
 * @author NthTensor
 * @version 1.0
 * @since 2017-05-04
 */
public class World extends FWorld {

    BiMap<UUID, Blob> uuidMap;
}
