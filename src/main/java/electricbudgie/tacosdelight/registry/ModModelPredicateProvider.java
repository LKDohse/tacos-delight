package electricbudgie.tacosdelight.registry;

import electricbudgie.tacosdelight.block.ModBlocks;
import electricbudgie.tacosdelight.components.ModComponents;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {

    public static void registerModelPredicateProviders() {
        ModelPredicateProviderRegistry.register(ModBlocks.CHEESE_WHEEL_BLOCK.asItem(), Identifier.of("age"),
                (itemStack, clientWorld, livingEntity, seed) -> {
                    Integer age = itemStack.get(ModComponents.AGE_COMPONENT);
                    if (age == null) return 0.0f;
                    return switch (age) {
                        case 0 -> 0.0f;
                        case 1 -> 0.5f;
                        case 2 -> 1.0f;
                        default -> 0f;
                    };
                });
    }
}
