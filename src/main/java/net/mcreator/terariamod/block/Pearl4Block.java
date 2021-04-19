
package net.mcreator.terariamod.block;

import net.minecraft.block.material.Material;

@TerariamodModElements.ModElement.Tag
public class Pearl4Block extends TerariamodModElements.ModElement {

	@ObjectHolder("terariamod:pearl_4")
	public static final Block block = null;

	public Pearl4Block(TerariamodModElements instance) {
		super(instance, 81);

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

			setRegistryName("pearl_4");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(Pearl4Block.block, (int) (1));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(PearlWoodBlock.block, (int) (2)));
		}

		@Override
		public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(state, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 10);
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				TreedropProcedure.executeProcedure($_dependencies);
			}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 10);
		}

	}

}
