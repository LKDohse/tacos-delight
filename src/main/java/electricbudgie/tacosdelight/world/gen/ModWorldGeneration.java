package electricbudgie.tacosdelight.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGeneration() {
        ModGeodeGeneration.generateGeodes();
        ModOreGeneration.generateOres();
        ModVegetalGeneration.generateVegetation();
    }
}
