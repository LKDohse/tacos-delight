package electricbudgie.tacosdelight.tags;

import electricbudgie.tacosdelight.TacosDelight;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
        public static final TagKey<Biome> IS_TROPICAL = createTag("is_tropical");
        public static final TagKey<Biome> IS_SNOWY = createTag("is_snowy");
        public static final TagKey<Biome> IS_WARM = createTag("is_warm");
        public static final TagKey<Biome> IS_COOL = createTag("is_cool");

        private static TagKey<Biome> createTag(String name){
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(TacosDelight.MOD_ID, name));
        }



}
