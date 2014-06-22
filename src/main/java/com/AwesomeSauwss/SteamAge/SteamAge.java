package com.AwesomeSauwss.SteamAge;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.AwesomeSauwss.SteamAge.blocks.*;
import com.AwesomeSauwss.SteamAge.items.*;
import com.AwesomeSauwss.SteamAge.lib.*;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = References.MODID, name = References.NAME , version = References.VERSION)

public class SteamAge {
	
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	
	//CreativeTabs
		public static CreativeTabs SteamAge = new CreativeTabs("AwesomeSauwss SteamAge Addon"){
			@Override
			public Item getTabIconItem() {
				return ObsidianStick;
				
				
			}
		};
	
	//Items
		public static Item ObsidianStick = new ObsidianStick(4002);
	//Blocks
		public static Block Steam = new BlockSteam(4001, Material.iron);
		public static Block CopperPipe = new BlockCopperPipe(4003, Material.rock);
		
	@EventHandler
	public void init(FMLInitializationEvent event){	
		
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
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSteamAge", "en_US", "AwesomeSauwss SteamAge Addon");
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){		
		proxy.registerRenderInformation();
		
	}
	
	public SteamAge() {
		//Item registry
			//GameReg
				GameRegistry.registerItem(ObsidianStick, "Ostick");
			//LangReg
				LanguageRegistry.addName(ObsidianStick, "Ostick");
				
		//Block registry
			//GameReg
				GameRegistry.registerBlock(Steam, "Steam");
				GameRegistry.registerBlock(CopperPipe, "Cpipe");
			//LangReg
				LanguageRegistry.addName(Steam, "Steam");
				LanguageRegistry.addName(CopperPipe, "Copper Pipe");
	}
}


