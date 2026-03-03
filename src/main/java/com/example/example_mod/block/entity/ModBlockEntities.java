package com.example.example_mod.block.entity;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import com.example.example_mod.block.entity.custom.DiningHallBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE,
            ExampleMod.MOD_ID);
    public static final Supplier<BlockEntityType<DiningHallBlockEntity>> DINING_HALL_BE =
            BLOCK_ENTITES.register("dining_hall_be", () -> BlockEntityType.Builder.of(
                    DiningHallBlockEntity::new, ModBlocks.DINING_HALL.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITES.register(eventBus);
    }
}
