/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.github.liachmodded.doublecart.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancement.Advancement;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

final class CartAdvancementProvider implements DataProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator root;
    private final List<Consumer<Consumer<Advancement>>> tabGenerators = ImmutableList.of(new CartAdvancementTab());

    CartAdvancementProvider(DataGenerator dataGenerator) {
        this.root = dataGenerator;
    }

    private static Path getOutput(Path root, Advancement advancement) {
        return root.resolve("data/" + advancement.getId().getNamespace() + "/advancements/" + advancement.getId().getPath() + ".json");
    }

    @Override
    public void run(DataCache dataCache) {
        Path outputRoot = this.root.getOutput();
        Set<Identifier> ids = new HashSet<>();
        Consumer<Advancement> writer = advancement -> {
            if (!ids.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement " + advancement.getId());
            }
            Path output = getOutput(outputRoot, advancement);

            try {
                DataProvider.writeToPath(GSON, dataCache, advancement.createTask().toJson(), output);
            } catch (IOException ex) {
                LOGGER.error("Couldn't save advancement {}", output, ex);
            }
        };
        for (Consumer<Consumer<Advancement>> generator : this.tabGenerators) {
            generator.accept(writer);
        }
    }

    @Override
    public String getName() {
        return "Mod Advancements";
    }
}
