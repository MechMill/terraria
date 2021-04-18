
package net.mcreator.terariamod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.terariamod.block.DirtBlock;
import net.mcreator.terariamod.TerariamodModElements;

@TerariamodModElements.ModElement.Tag
public class TerrariaBlockItemGroup extends TerariamodModElements.ModElement {
	public TerrariaBlockItemGroup(TerariamodModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabterraria_block") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DirtBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
