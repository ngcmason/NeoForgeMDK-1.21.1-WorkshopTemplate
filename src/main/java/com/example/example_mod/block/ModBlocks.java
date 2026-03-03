package com.example.example_mod.block;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.custom.DiningHallBlock;
import com.example.example_mod.block.custom.LaptopBlock;
import com.example.example_mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MOD_ID);
    // ----------------------------------------------------------------------
    // Add new blocks here
    // ----------------------------------------------------------------------
    // Simple Blocks
    public static final DeferredBlock<Block> DENISON_BLOCK = registerBlock("denison_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> DENISON_ORE = registerBlock("denison_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_DENISON_ORE = registerBlock("deepslate_denison_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    // Fancy Blocks
    public static final DeferredBlock<LaptopBlock> LAPTOP = registerBlock("laptop",
            () -> new LaptopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    // Block Entities
    public static final DeferredBlock<DiningHallBlock> DINING_HALL = registerBlock("dining_hall",
            () -> new DiningHallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)));


    // ----------------------------------------------------------------------
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
