package com.example.example_mod.component;

import com.example.example_mod.ExampleMod;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ExampleMod.MOD_ID);
    // Add new data components here
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> FLEX_BALANCE = register("flex_balance",
            floatBuilder -> floatBuilder.persistent(Codec.FLOAT));


    // Helper functions
    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
