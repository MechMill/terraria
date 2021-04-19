package net.mcreator.terariamod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.terariamod.TerariamodModElements;
import net.mcreator.terariamod.TerariamodMod;

import java.util.Map;

@TerariamodModElements.ModElement.Tag
public class TreedropProcedure extends TerariamodModElements.ModElement {
	public TreedropProcedure(TerariamodModElements instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TerariamodMod.LOGGER.warn("Failed to load dependency x for procedure Treedrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TerariamodMod.LOGGER.warn("Failed to load dependency y for procedure Treedrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TerariamodMod.LOGGER.warn("Failed to load dependency z for procedure Treedrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TerariamodMod.LOGGER.warn("Failed to load dependency world for procedure Treedrop!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
