package com.ahsan.groundBeefMc;

import com.ahsan.groundBeefMc.registry.ModBlocks;
import com.ahsan.groundBeefMc.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class GroundBeefMc implements ModInitializer {
    public static final String MOD_ID = "ground-beef-mc";


    private static final ConfiguredFeature<?, ?> GENERATE_GROUND_BEEF = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.GROUND_BEEF_ORE.getDefaultState(),
                    6)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    60)))
            .spreadHorizontally()
            .repeat(10); // number of veins per chunk

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        RegistryKey<ConfiguredFeature<?, ?>> generateGroundBeef = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(MOD_ID, "generate_ground_beef"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, generateGroundBeef.getValue(), GENERATE_GROUND_BEEF);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, generateGroundBeef);

    }
}
