package com.ahsan.groundBeefMc.registry;

import com.ahsan.groundBeefMc.GroundBeefMc;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block GROUND_BEEF_ORE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .strength(3.0f, 15.0f)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE)
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(GroundBeefMc.MOD_ID, "ground_beef_ore"), GROUND_BEEF_ORE);
    }
}
