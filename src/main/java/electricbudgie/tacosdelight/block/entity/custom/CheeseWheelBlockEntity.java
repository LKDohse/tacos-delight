package electricbudgie.tacosdelight.block.entity.custom;

import electricbudgie.tacosdelight.block.custom.CheeseWheelBlock;
import electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CheeseWheelBlockEntity extends BlockEntity {
    protected int age = 0;
    private int progress = 0;
    private final int maxProgress = 24000;
    private static final int maxAge = 2;

    protected final PropertyDelegate propertyDelegate;

    public CheeseWheelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHEESE_WHEEL_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CheeseWheelBlockEntity.this.progress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CheeseWheelBlockEntity.this.progress = value;
                }
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    public int getAge(){
        return age;
    }

    public void setAge(int updatedAge){
        age = updatedAge;
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("age", age);
        nbt.putInt("progress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        age = nbt.getInt("age");
        progress = nbt.getInt("progress");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        //20 ticks per second
        if (age >= maxAge) return;
        if (progress == maxProgress){
            age++;
            progress = 0;
            updateAge(age, pos, state);
        }
        progress++;
        markDirty(world, pos, state);
    }

    private void updateAge(int age, BlockPos pos, BlockState state){
        if (state.get(CheeseWheelBlock.AGE) != age)
            world.setBlockState(pos, state.with(CheeseWheelBlock.AGE, age), CheeseWheelBlock.NOTIFY_ALL);
    }
}
