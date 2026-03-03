package com.example.example_mod.datagen;

import com.example.example_mod.ExampleMod;
import com.example.example_mod.block.ModBlocks;
import com.example.example_mod.item.ModItems;
import com.example.example_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // ----------------------------------------------------------------------
        // Add new recipes here
        // ----------------------------------------------------------------------
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_DENISON), RecipeCategory.MISC,
                        ModItems.DENISON_INGOT, 0.1f, 200)
                .unlockedBy("has_raw_denison", has(ModItems.RAW_DENISON))
                .save(recipeOutput, ExampleMod.MOD_ID + "denison_ingot_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_DENISON), RecipeCategory.MISC,
                        ModItems.DENISON_INGOT, 0.1f, 100)
                .unlockedBy("has_raw_denison", has(ModItems.RAW_DENISON))
                .save(recipeOutput, ExampleMod.MOD_ID + "denison_ingot_blasting");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DENISON_BLOCK, 1)
                .requires(ModItems.DENISON_INGOT, 9)
                .unlockedBy("has_denison_ingot", has(ModItems.DENISON_INGOT))
                .save(recipeOutput, ExampleMod.MOD_ID + "denison_block_from_ingots");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DENISON_INGOT, 9)
                .requires(ModBlocks.DENISON_BLOCK, 1)
                .unlockedBy("has_denison_block", has(ModBlocks.DENISON_BLOCK))
                .save(recipeOutput, ExampleMod.MOD_ID + "denison_ingots_from_block");

        for (int i = 1; i <= 9; i++) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ID_CARD, 1)
                    .requires(ModItems.ID_CARD, 1)
                    .requires(Ingredient.of(ModTags.Items.FLEX_REFILLER), i)
                    .unlockedBy("has_id_card", has(ModItems.ID_CARD))
                    .save(recipeOutput, ExampleMod.MOD_ID + "flex_refill" + i);
        }



        // ----------------------------------------------------------------------
    }
}
