package com.AwesomeSauwss.SteamAge;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.AwesomeSauwss.SteamAge.blocks.BlockCopperPipe;
import com.AwesomeSauwss.SteamAge.items.ObsidianStick;
import com.AwesomeSauwss.SteamAge.lib.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = References.MODID, name = References.NAME , version = References.VERSION)

public class SteamAge {
	
	@Instance(References.MODID)
	public static SteamAge instance;
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	
	//CreativeTabs
		public static CreativeTabs SteamAge = new CreativeTabs("SteamAge"){
			@Override
			public Item getTabIconItem() {
				return ObsidianStick;
				
				
			}
		};
	
		
	//InitializationLoad	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){	
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		proxy.registerRenderInformation(); 
		proxy.registerSoundInformation();
		
		
		
	}
	
	
	//Items
		public static Item ObsidianStick = new ObsidianStick(4002);
	//Blocks
		public static Block CopperPipe = new BlockCopperPipe(ConfigHandler.COPPER_PIPE_ID, Material.rock);
	
	//DuringLoad
	@EventHandler
	public void load(FMLInitializationEvent event){		
		proxy.registerRenderInformation();
		
		//Recipes
				//Crafting
					//Shapeless
						GameRegistry.addShapelessRecipe(new ItemStack(Blocks.farmland, 1), Blocks.dirt, Items.stone_hoe);
					//Shaped
						GameRegistry.addShapedRecipe(new ItemStack(Blocks.command_block), "X X", " Y ", "X X", 'X', Blocks.noteblock, 'Y', Items.redstone);
				//Smelting
						GameRegistry.addSmelting(Blocks.coal_block, new ItemStack(Blocks.water), 20f);
						GameRegistry.addSmelting(Items.iron_axe, new ItemStack(Items.diamond_axe), 600f);
		//Creativetabs
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSteamAge", "en_US", "SteamAge");
		
	}
	
	//Post Load
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event){
		
	}
	
	public SteamAge() {
		//Item registry
			//GameReg
				GameRegistry.registerItem(ObsidianStick, "Ostick");
			//LangReg
				LanguageRegistry.addName(ObsidianStick, "Ostick");
				
		//Block registry
			//GameReg
				GameRegistry.registerBlock(CopperPipe, "Cpipe");
			//LangReg
				LanguageRegistry.addName(CopperPipe, "Copper Pipe");
	}
}


