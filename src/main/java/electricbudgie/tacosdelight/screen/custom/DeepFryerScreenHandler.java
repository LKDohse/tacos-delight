package electricbudgie.tacosdelight.screen.custom;

import electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import electricbudgie.tacosdelight.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class DeepFryerScreenHandler extends ScreenHandler {
    public final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final DeepFryerBlockEntity blockEntity;

    public DeepFryerScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }

    public DeepFryerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate){
        super(ModScreenHandlers.DEEP_FRYER_HANDLER, syncId);
        checkSize((Inventory)blockEntity, 2);
        this.inventory = (Inventory)blockEntity;
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = (DeepFryerBlockEntity)blockEntity;

        this.addSlot(new Slot(inventory, 0, 8, 62));
        this.addSlot(new Slot(inventory, 1, 54, 34));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowPixelSize = 24; //this is the width in pixels of the arrow texture

        return maxProgress != 0 && progress != 0? progress * arrowPixelSize/maxProgress : 0;
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    // Below is boilerplate code that will fill in the player inventory and hotbar of the standard GUI provided (pedestal_gui)
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
}
