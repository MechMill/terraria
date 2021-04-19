
package net.mcreator.terariamod.block;

import net.minecraft.block.material.Material;

@TerariamodModElements.ModElement.Tag
public class RichMahoganyWoodBlock extends TerariamodModElements.ModElement {

	@ObjectHolder("terariamod:rich_mahogany_wood")
	public static final Block block = null;

	public RichMahoganyWoodBlock(TerariamodModElements instance) {
		super(instance, 86);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TerrariaBlockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("rich_mahogany_wood");
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(RichMahoganyWoodBlock.block, (int) (1));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(RichMahoganyWoodBlock.block, (int) (1)));
		}

	}

}
