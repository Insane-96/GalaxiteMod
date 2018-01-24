package net.insane96mcp.galaxite.capabilities;

import net.minecraft.item.ItemStack;

public class ItemSlot {
	public ItemStack itemStack;
	public int slot;
	
	public ItemSlot(ItemStack itemStack, int slot) {
		this.itemStack = itemStack;
		this.slot = slot;
	}
}
