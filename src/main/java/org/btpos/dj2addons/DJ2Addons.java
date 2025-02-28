package org.btpos.dj2addons;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btpos.dj2addons.crafttweaker.CommandHandler;
import org.btpos.dj2addons.registry.Potions;

@Mod(modid = DJ2Addons.MOD_ID, name = DJ2Addons.MOD_NAME, version = DJ2Addons.VERSION, dependencies = DJ2Addons.DEPENDENCIES)
public class DJ2Addons {
	public static final String MOD_ID = "dj2addons";
	public static final String MOD_NAME = "Divine Journey 2 Addons";
	public static final String VERSION = "1.1.0";
	
	public static final String DEPENDENCIES = 	"required-after:crafttweaker;" +
												"before:totemic;" +
												"after:botania";
	
	public static final Logger LOGGER = LogManager.getLogger("Divine Journey 2");
	
	/**
	 * This is the instance of your mod as created by Forge. It will never be null.
	 */
	@Mod.Instance(MOD_ID)
	public static DJ2Addons INSTANCE;
	
	/**
	 * This is the first initialization event. Register tile entities here.
	 * The registry events below will have fired prior to entry to this method.
	 */
	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		CTChatCommand.registerCommand(new CommandHandler());
		CraftTweakerAPI.tweaker.loadScript(false, "dj2addons");
	}
	
	/**
	 * This is the second initialization event. Register custom recipes
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		LOGGER.log(Level.INFO, "Voted \"Most Likely to be Factorio\"!");
		
	}
	
	/**
	 * This is the final initialization event. Register actions from other mods here
	 */
	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event) {
//		if (Loader.isModLoaded("botania")) {
//			Brew b = BrewHandler.buildBrew("saturegen","dj2addons.brew.saturegen", MobEffects.SATURATION.getLiquidColor(), 500, new PotionEffect(Potions.Registered.saturegen, 1000, 3));
//			BrewHandler.registerBrew(b);
//			BrewHandler.registerBrewRecipe(b, new ItemStack[] {
//					new ItemStack(net.minecraft.init.Items.COOKED_BEEF)
//			});
//		}
	}
	
//	@GameRegistry.ObjectHolder(MOD_ID)
//	public static class Blocks {
//      public static final Block resourcename = null;
//	}

	
	
	
	/**
	 * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
	 */
	@Mod.EventBusSubscriber(modid=DJ2Addons.MOD_ID)
	public static class ObjectRegistryHandler {
		@SubscribeEvent
		public static void addPotions(RegistryEvent.Register<Potion> evt) {
			Potions.init(evt);
		}
	}
}
