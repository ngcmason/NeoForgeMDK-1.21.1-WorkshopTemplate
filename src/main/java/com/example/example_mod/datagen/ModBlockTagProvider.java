package com.example.example_mod.datagen;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import com.example.example_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DENISON_BLOCK.get())
                .add(ModBlocks.DENISON_ORE.get())
                .add(ModBlocks.DEEPSLATE_DENISON_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DENISON_BLOCK.get())
                .add(ModBlocks.DENISON_ORE.get())
                .add(ModBlocks.DEEPSLATE_DENISON_ORE.get());
    }
}
