package net.insane96mcp.galaxite.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface IPlayerData {
	public NonNullList<ItemSlot> getInventorySaved();
	public void addItemToInventorySaved(ItemSlot itemSlot);
	public void clone(NonNullList<ItemSlot> itemSlots);
	public void clearInventorySaved(); 
}
