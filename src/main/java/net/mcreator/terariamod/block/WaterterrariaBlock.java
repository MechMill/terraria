
package net.mcreator.terariamod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Block;

import net.mcreator.terariamod.itemgroup.TerrariaBlockItemGroup;
import net.mcreator.terariamod.TerariamodModElements;

@TerariamodModElements.ModElement.Tag
public class WaterterrariaBlock extends TerariamodModElements.ModElement {
	@ObjectHolder("terariamod:waterterraria")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("terariamod:waterterraria_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public WaterterrariaBlock(TerariamodModElements instance) {
		super(instance, 25);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());
	}
	private static class FluidRegisterHandler {
		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("terariamod:blocks/water_still"), new ResourceLocation("terariamod:blocks/water_flow"))
						.luminosity(0).density(1000).viscosity(1000)).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("waterterraria");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("waterterraria_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
		}.setRegistryName("waterterraria"));
		elements.items
				.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(TerrariaBlockItemGroup.tab))
						.setRegistryName("waterterraria_bucket"));
	}
}
