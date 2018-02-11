package net.insane96mcp.galaxite.capabilities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerDataStorage implements IStorage<IPlayerData> {

	@Override
	public NBTBase writeNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side) {
		NBTTagCompound tags = new NBTTagCompound();
		saveAllItems(tags, instance.getInventorySaved());
		return tags;
	}

	@Override
	public void readNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound tags = (NBTTagCompound)nbt;
		NonNullList<ItemSlot> readList = NonNullList.create();
		loadAllItems(tags, readList);
		instance.clone(readList);
	}
	
	private NBTTagCompound saveAllItems(NBTTagCompound tag, NonNullList<ItemSlot> itemSlots) {
		NBTTagList nbttaglist = new NBTTagList();

        for (ItemSlot itemSlot : itemSlots)
        {
            ItemStack itemstack = itemSlot.itemStack;

            if (!itemstack.isEmpty())
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)itemSlot.slot);
                itemstack.writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        if (!nbttaglist.hasNoTags())
        {
            tag.setTag("Items", nbttaglist);
        }

        return tag;
	}
	
	private static void loadAllItems(NBTTagCompound tag, NonNullList<ItemSlot> list)
    {
        NBTTagList nbttaglist = tag.getTagList("Items", 10);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            byte slot = nbttagcompound.getByte("Slot");

            ItemSlot toAdd = new ItemSlot(new ItemStack(nbttagcompound), slot);
            list.add(toAdd);
        }
    }
}
