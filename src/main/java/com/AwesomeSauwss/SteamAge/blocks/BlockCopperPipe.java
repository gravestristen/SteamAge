package com.AwesomeSauwss.SteamAge.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

	public class BlockCopperPipe extends Block{
		
		public BlockCopperPipe(int i, Material m) {
			super (m);
			this.setBlockName("Copper Pipe");
			this.setBlockTextureName("steamage:CopperPipe");
			this.setCreativeTab(CreativeTabs.tabBlock);
			this.setStepSound(Block.soundTypeMetal);
			this.setHardness(6f);
			this.setResistance(10f);
			this.setLightLevel(0.8f);
			
		}

		
	}

