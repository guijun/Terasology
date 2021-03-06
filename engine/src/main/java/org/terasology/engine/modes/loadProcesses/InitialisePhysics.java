/*
 * Copyright 2014 MovingBlocks
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
package org.terasology.engine.modes.loadProcesses;

import org.terasology.physics.Physics;
import org.terasology.physics.bullet.BulletPhysics;
import org.terasology.physics.engine.PhysicsEngine;
import org.terasology.registry.CoreRegistry;
import org.terasology.world.WorldProvider;

/**
 * @author Immortius
 */
public class InitialisePhysics extends SingleStepLoadProcess {
    @Override
    public String getMessage() {
        return "Turning on gravity";
    }

    @Override
    public boolean step() {
        BulletPhysics physicsEngine = new BulletPhysics(CoreRegistry.get(WorldProvider.class));
        CoreRegistry.put(Physics.class, physicsEngine);
        CoreRegistry.put(PhysicsEngine.class, physicsEngine);
        return true;
    }

    @Override
    public int getExpectedCost() {
        return 1;
    }
}
