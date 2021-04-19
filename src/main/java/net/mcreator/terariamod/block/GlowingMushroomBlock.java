
package net.mcreator.terariamod.block;

import net.minecraft.block.material.Material;

@TerariamodModElements.ModElement.Tag
public class GlowingMushroomBlock extends TerariamodModElements.ModElement {

	@ObjectHolder("terariamod:glowing_mushroom")
	public static final Block block = null;

	public GlowingMushroomBlock(TerariamodModElements instance) {
		super(instance, 95);

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

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("glowing_mushroom");
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(GlowingMushroomBlock.block, (int) (1));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(GlowingMushroomBlock.block, (int) (1)));
		}

	}

}
