/*
 * Copyright 2012  Benjamin Glatzel <benjamin.glatzel@me.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.game.modes.loadProcesses;

import org.terasology.entitySystem.EntityManager;
import org.terasology.entitySystem.PersistableEntityManager;
import org.terasology.entitySystem.metadata.EntitySystemLibrary;
import org.terasology.game.ComponentSystemManager;
import org.terasology.game.CoreRegistry;
import org.terasology.game.modes.LoadProcess;
import org.terasology.network.NetworkSystem;
import org.terasology.world.BlockEntityRegistry;

/**
 * @author Immortius
 */
public class InitialiseSystems implements LoadProcess {
    @Override
    public String getMessage() {
        return "Initialising Systems...";
    }

    @Override
    public boolean step() {
        CoreRegistry.get(NetworkSystem.class).connectToEntitySystem((PersistableEntityManager) CoreRegistry.get(EntityManager.class), CoreRegistry.get(EntitySystemLibrary.class), CoreRegistry.get(BlockEntityRegistry.class));
        CoreRegistry.get(ComponentSystemManager.class).initialise();
        return true;
    }

    @Override
    public int begin() {
        return 1;
    }

}
