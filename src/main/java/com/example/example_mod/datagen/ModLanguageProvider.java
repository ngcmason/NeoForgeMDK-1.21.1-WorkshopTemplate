package com.example.example_mod.datagen;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import com.example.example_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        add(formatName(ModItems.RAW_DENISON), "Raw Denison");
        add(formatName(ModItems.DENISON_INGOT), "Denison Ingot");
        add(formatName(ModItems.ID_CARD), "ID Card");
        // Blocks
        add(formatName(ModBlocks.DENISON_BLOCK), "Block of Denison");
        add(formatName(ModBlocks.DENISON_ORE), "Denison Ore");
        add(formatName(ModBlocks.DEEPSLATE_DENISON_ORE), "Deepslate Denison Ore");
        add(formatName(ModBlocks.LAPTOP), "Laptop");
        add(formatName(ModBlocks.DINING_HALL), "Dining Hall");
        // Block Entities
        add("blockentity." + ExampleMod.MOD_ID + ".dining_hall", "Dining Hall");
        // Creative Mode Tab
        add("creativetab." + ExampleMod.MOD_ID + ".items", "Example Mod");
    }

    // Helper functions
    private <T extends Item> String formatName(DeferredItem<T> item) {
        return "item." + item.getRegisteredName().replace(":", ".");
    }
    private <T extends Block> String formatName(DeferredBlock<T> block) {
        return "block." + block.getRegisteredName().replace(":", ".");
    }
}
