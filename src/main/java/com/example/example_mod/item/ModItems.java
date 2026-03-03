package com.example.example_mod.item;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.component.ModDataComponents;
import com.example.example_mod.item.custom.IdCard;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);
    // ----------------------------------------------------------------------
    // Add new items here
    // ----------------------------------------------------------------------

    // Simple Items
    public static final DeferredItem<Item> RAW_DENISON = ITEMS.register("raw_denison",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DENISON_INGOT = ITEMS.register("denison_ingot",
            () -> new Item(new Item.Properties()));

    // Fancy Items
    public static final DeferredItem<IdCard> ID_CARD = ITEMS.register("id_card",
            () -> new IdCard(new Item.Properties().stacksTo(1).component(ModDataComponents.FLEX_BALANCE, 0f)));




    // ----------------------------------------------------------------------
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
