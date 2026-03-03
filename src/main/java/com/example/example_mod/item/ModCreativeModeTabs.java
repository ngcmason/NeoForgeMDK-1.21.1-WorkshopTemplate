package com.example.example_mod.item;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MOD_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("mod_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab." + ExampleMod.MOD_ID + ".items"))
                    .icon(() -> new ItemStack(ModItems.RAW_DENISON.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        // ----------------------------------------------------------------------
                        // Add items here
                        // ----------------------------------------------------------------------
                        output.accept(ModBlocks.DENISON_ORE);
                        output.accept(ModBlocks.DEEPSLATE_DENISON_ORE);

                        output.accept(ModItems.RAW_DENISON);
                        output.accept(ModItems.DENISON_INGOT);

                        output.accept(ModBlocks.DENISON_BLOCK);

                        output.accept(ModBlocks.LAPTOP);
                        output.accept(ModItems.ID_CARD);
                        output.accept(ModBlocks.DINING_HALL);
                        // ----------------------------------------------------------------------
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
