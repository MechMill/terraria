
package net.mcreator.terariamod.block;

import net.minecraft.block.material.Material;

@TerariamodModElements.ModElement.Tag
public class BorealBlock extends TerariamodModElements.ModElement {

	@ObjectHolder("terariamod:boreal")
	public static final Block block = null;

	public BorealBlock(TerariamodModElements instance) {
		super(instance, 70);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TerrariaBlockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(1)
							.harvestTool(ToolType.AXE).setRequiresTool().notSolid().setOpaque((bs, br, bp) -> false));

			setRegistryName("boreal");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(BorealBlock.block, (int) (1));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(BorealWoodBlock.block, (int) (2)));
		}

	}

}
