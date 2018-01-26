package net.insane96mcp.galaxite.capabilities;

import net.minecraft.util.NonNullList;

public class PlayerData implements IPlayerData{

	NonNullList<ItemSlot> inventorySaved = NonNullList.create();
	
	@Override
	public NonNullList<ItemSlot> getInventorySaved() {
		return inventorySaved;
	}

	@Override
	public void addItemToInventorySaved(ItemSlot itemSlot) {
		inventorySaved.add(itemSlot);
	}

	@Override
	public void clearInventorySaved() {
		inventorySaved.clear();
	}

	@Override
	public void clone(NonNullList<ItemSlot> itemSlots) {
		inventorySaved = itemSlots;
	}

	
}
