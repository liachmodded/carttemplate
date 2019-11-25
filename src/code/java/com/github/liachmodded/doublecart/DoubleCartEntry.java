/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package com.github.liachmodded.doublecart;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

/**
 * The main entrypoint for the mod.
 */
public final class DoubleCartEntry implements ModInitializer {

    /**
     * The mod's namespace or id.
     */
    public static final String ID = "doublecart";

    /**
     * Creates an {@link Identifier} with {@link #ID the mod's id} as {@link Identifier#getNamespace() namespace}
     * and the passed string as the {@link Identifier#getPath() name or path}.
     *
     * @param name the name for the identifier
     * @return the created identifier
     */
    public static Identifier name(String name) {
        return new Identifier(ID, name);
    }

    /**
     * Performs initialization logic.
     *
     * <p>This method is called before most of the game code.
     */
    @Override
    public void onInitialize() {
    }
}
