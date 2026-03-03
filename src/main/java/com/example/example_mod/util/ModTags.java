package com.example.example_mod.util;

import com.example.example_mod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

public class ModTags {

    public static class Items {

        public static final TagKey<net.minecraft.world.item.Item> DENISON_ORES = createTag("denison_ore");

        public static final TagKey<net.minecraft.world.item.Item> FLEX_REFILLER = createTag("flex_refiller");

        private static TagKey<net.minecraft.world.item.Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name));
        }
    }


    public static class Blocks {



        private static TagKey<net.minecraft.world.level.block.Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name));
        }
    }
}
