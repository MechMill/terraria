package net.mcreator.terariamod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.terariamod.block.PalmWoodBlock;
import net.mcreator.terariamod.TerariamodModElements;
import net.mcreator.terariamod.TerariamodMod;

import java.util.Map;
import java.util.HashMap;

@TerariamodModElements.ModElement.Tag
public class PalmdropProcedure extends TerariamodModElements.ModElement {
	public PalmdropProcedure(TerariamodModElements instance) {
		super(instance, 104);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TerariamodMod.LOGGER.warn("Failed to load dependency x for procedure Palmdrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TerariamodMod.LOGGER.warn("Failed to load dependency y for procedure Palmdrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TerariamodMod.LOGGER.warn("Failed to load dependency z for procedure Palmdrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TerariamodMod.LOGGER.warn("Failed to load dependency world for procedure Palmdrop!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomdrop = 0;
		randomdrop = (double) Math.random();
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (((randomdrop) >= 0.75)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			} else if (((randomdrop) >= 0.5)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PalmWoodBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 1);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onGemDropped(ItemTossEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
		ItemStack itemstack = event.getEntityItem().getItem();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemstack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
