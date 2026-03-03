package com.example.example_mod.block.entity.custom;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.entity.ModBlockEntities;
import com.example.example_mod.screen.dining_hall.DiningHallMenu;
import com.example.example_mod.util.DiningHallFood;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class DiningHallBlockEntity extends BlockEntity implements MenuProvider {
    public static final int CARD_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;

    public static final List<DiningHallFood> menuItems = List.of(
            new DiningHallFood(Items.COOKED_BEEF, 1),
            new DiningHallFood(Items.COOKED_CHICKEN, 1),
            new DiningHallFood(Items.CARROT, 3),
            new DiningHallFood(Items.APPLE, 2)
    );

    public DiningHallBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.DINING_HALL_BE.get(), pos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("blockentity." + ExampleMod.MOD_ID + ".dining_hall");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new DiningHallMenu(containerId, inventory, this);
    }

    public ItemStack randomMenuItem() {
        Random r = new Random();
        int index = r.nextInt(menuItems.size());
        DiningHallFood selected = menuItems.get(index);
        return new ItemStack(selected.item(), selected.count());
    }
}
