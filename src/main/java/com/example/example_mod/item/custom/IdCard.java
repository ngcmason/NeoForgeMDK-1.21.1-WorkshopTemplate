package com.example.example_mod.item.custom;

import com.example.example_mod.component.ModDataComponents;
import com.example.example_mod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class IdCard extends Item {
    public IdCard(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Float flexBalance = stack.get(ModDataComponents.FLEX_BALANCE);

        if (flexBalance != null) {
            tooltipComponents.add(Component.literal("Current Balance: " + flexBalance.toString()));
        }



        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide) {
            // Get the current balance from the data component
            Float balance = 0f;

            float toAdd = 0f;

            // Iterate over the crafting grid slots
            if (player.containerMenu instanceof CraftingMenu craftingMenu) {
                for (int i = 1; i <= 9; i++) {
                    Slot craftingSlot = craftingMenu.getSlot(i);
                    ItemStack item = craftingSlot.getItem();
                    if (item.is(Items.GOLD_INGOT)) toAdd += 1.0f;
                    else if (item.is(Items.GOLD_BLOCK)) toAdd += 9.0f;
                    else if (item.is(Items.GOLD_NUGGET)) toAdd += 0.11f;
                    else if (item.is(ModItems.ID_CARD)) balance = item.get(ModDataComponents.FLEX_BALANCE);
                }
            } else if (player.containerMenu instanceof InventoryMenu inventoryMenu) {
                for (int i = 1; i <= 4; i++) {
                    Slot craftingSlot = inventoryMenu.getSlot(i);
                    ItemStack item = craftingSlot.getItem();
                    if (item.is(Items.GOLD_INGOT)) toAdd += 1.0f;
                    else if (item.is(Items.GOLD_BLOCK)) toAdd += 9.0f;
                    else if (item.is(Items.GOLD_NUGGET)) toAdd += 0.11f;
                    else if (item.is(ModItems.ID_CARD)) balance = item.get(ModDataComponents.FLEX_BALANCE);
                }
            }

            if (balance == null) balance = 0f;

            // Update the data component
            stack.set(ModDataComponents.FLEX_BALANCE, balance + toAdd);
        }
    }
}
