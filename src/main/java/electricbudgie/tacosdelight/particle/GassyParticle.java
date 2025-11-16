package electricbudgie.tacosdelight.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class GassyParticle extends SpriteBillboardParticle {
    public GassyParticle(ClientWorld clientWorld, double x, double y, double z, SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
        this.scale(3.0F);
        this.velocityX = (random.nextFloat() - 0.5f) * 0.02f;
        this.velocityY = (random.nextFloat() - 0.5f) * 0.01f;
        this.velocityZ = (random.nextFloat() - 0.5f) * 0.02f;
        this.setAlpha(0.9f);
        this.gravityStrength = -0.002f;
        this.maxAge = 60 + random.nextInt(20);
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
       this.alpha *= 0.96f;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new GassyParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
