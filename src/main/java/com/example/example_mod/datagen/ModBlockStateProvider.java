package com.example.example_mod.datagen;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // ----------------------------------------------------------------------
        // Add new blocks here
        // ----------------------------------------------------------------------
        blockWithItem(ModBlocks.DENISON_BLOCK);
        blockWithItem(ModBlocks.DENISON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_DENISON_ORE);

        horizontalBlockTopBottomWithItem(ModBlocks.DINING_HALL);
        // ----------------------------------------------------------------------
    }

    // Helper Methods
    private <T extends Block> void blockWithItem(DeferredBlock<T> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private <T extends Block> void horizontalBlockTopBottomWithItem(DeferredBlock<T> deferredBlock) {
        ModelFile model = models().cubeBottomTop(
                name(deferredBlock.get()),
                extend(blockTexture(deferredBlock.get()), "_side"),
                extend(blockTexture(deferredBlock.get()), "_bottom"),
                extend(blockTexture(deferredBlock.get()), "_top"));
        simpleBlockItem(deferredBlock.get(), model);
        horizontalBlock(deferredBlock.get(), model);
    }
    private <T extends Block> void axisBlockWithItem(DeferredBlock<T> deferredBlock){
        axisBlockWithItem(deferredBlock, extend(blockTexture(deferredBlock.get()), "_side"), extend(blockTexture(deferredBlock.get()), "_end"));
    }
    private <T extends Block> void axisBlockWithItem(DeferredBlock<T> deferredBlock, ResourceLocation baseNameSide, ResourceLocation baseNameEnd){
        axisBlock((RotatedPillarBlock) deferredBlock.get(), baseNameSide, baseNameEnd);
        simpleBlockItem(deferredBlock.get(), models().cubeColumn(name(deferredBlock.get()), baseNameSide, baseNameEnd));
    }
    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
    }
    private String name(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }
}
