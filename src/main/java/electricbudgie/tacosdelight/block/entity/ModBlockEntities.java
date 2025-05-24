package electricbudgie.tacosdelight.block.entity;

import electricbudgie.tacosdelight.TacosDelight;
import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<DeepFryerBlockEntity> DEEP_FRYER_BE;

    public static void registerBlockEntities(){
        DEEP_FRYER_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(TacosDelight.MOD_ID, "deep_fryer_be"),
                FabricBlockEntityTypeBuilder.create(DeepFryerBlockEntity::new,
                        ModBlocks.DEEP_FRYER_BLOCK).build());
        TacosDelight.LOGGER.info("Registering block entities for " + TacosDelight.MOD_ID);
    }
}
