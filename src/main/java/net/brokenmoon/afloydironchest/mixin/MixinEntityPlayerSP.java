package net.brokenmoon.afloydironchest.mixin;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.gui.GuiDiamondChest;
import net.brokenmoon.afloydironchest.gui.GuiIronChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.core.player.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = EntityPlayerSP.class, remap = false)
public class MixinEntityPlayerSP implements IEntityPlayer {
    @Unique
    private EntityPlayerSP thisAs = (EntityPlayerSP)(Object)this;
    @Shadow
    protected Minecraft mc;
    public void displayGUIIronChest(IInventory iinventory) {
        this.mc.displayGuiScreen(new GuiIronChest(thisAs.inventory, iinventory));
    }

    public void displayGUIDiamondChest(IInventory iinventory) {
        this.mc.displayGuiScreen(new GuiDiamondChest(thisAs.inventory, iinventory));
    }
}
