package com.ahsan.groundBeefMc.registry;

import com.ahsan.groundBeefMc.GroundBeefMc;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Mod Items
    public static final Item GROUND_BEEF = new Item(
            new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder()
                    .hunger(2)
                    .saturationModifier(1.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*10), 0.3f)
                    .build()
    ));
    public static final Item GROUND_BEEF_COOKED = new Item(
            new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(5.2f)
                    .build()
    ));

    //Mod Blocks
    public static final BlockItem GROUND_BEEF_ORE = new net.minecraft.item.BlockItem(ModBlocks.GROUND_BEEF_ORE, new Item.Settings()
        .group(ItemGroup.BUILDING_BLOCKS)
    );

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(GroundBeefMc.MOD_ID, "ground_beef"), GROUND_BEEF);
        Registry.register(Registry.ITEM, new Identifier(GroundBeefMc.MOD_ID, "ground_beef_cooked"), GROUND_BEEF_COOKED);
        Registry.register(Registry.ITEM, new Identifier(GroundBeefMc.MOD_ID, "ground_beef_ore"), GROUND_BEEF_ORE);
    }
}
