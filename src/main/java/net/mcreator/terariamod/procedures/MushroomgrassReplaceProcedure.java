package net.mcreator.terariamod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.terariamod.block.MushroomsBlock;
import net.mcreator.terariamod.block.MushroomgrassUnbreakableBlock;
import net.mcreator.terariamod.block.MushroomgrassBlock;
import net.mcreator.terariamod.TerariamodModElements;
import net.mcreator.terariamod.TerariamodMod;

import java.util.Map;

@TerariamodModElements.ModElement.Tag
public class MushroomgrassReplaceProcedure extends TerariamodModElements.ModElement {
	public MushroomgrassReplaceProcedure(TerariamodModElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TerariamodMod.LOGGER.warn("Failed to load dependency x for procedure MushroomgrassReplace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TerariamodMod.LOGGER.warn("Failed to load dependency y for procedure MushroomgrassReplace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TerariamodMod.LOGGER.warn("Failed to load dependency z for procedure MushroomgrassReplace!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TerariamodMod.LOGGER.warn("Failed to load dependency world for procedure MushroomgrassReplace!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == MushroomsBlock.block.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MushroomgrassBlock.block.getDefaultState()
						.getBlock()))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = MushroomgrassUnbreakableBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MushroomgrassUnbreakableBlock.block.getDefaultState()
						.getBlock()))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = MushroomgrassBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
