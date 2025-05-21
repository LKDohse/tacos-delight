package electricbudgie.tacosdelight.tags;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
        public static final TagKey<Biome> IS_TROPICAL = createTag("is_tropical");
        public static final TagKey<Biome> IS_COLD_FOREST = createTag("is_cold_forest");

        private static TagKey<Biome> createTag(String name){
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(TacosDelight.MOD_ID, name));
        }



}
