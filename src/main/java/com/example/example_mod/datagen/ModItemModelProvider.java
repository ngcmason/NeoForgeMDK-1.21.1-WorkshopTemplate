package com.example.example_mod.datagen;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_DENISON.get());
        basicItem(ModItems.DENISON_INGOT.get());
        handheldItem(ModItems.ID_CARD.get());
    }
}
