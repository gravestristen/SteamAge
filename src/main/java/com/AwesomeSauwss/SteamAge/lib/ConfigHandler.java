package com.AwesomeSauwss.SteamAge.lib;

import java.io.File;

import net.minecraftforge.common.config.Configuration;



public class ConfigHandler {

	private static final String CATEGORY_BLOCKS = "Blocks"; 
	
	//Blocks
		private static final String COPPER_PIPE = "Copper Pipe";
		private static final int COPPER_PIPE_DEFULT_ID = 4001;
		public static int COPPER_PIPE_ID;
	
		
	public static void init(File file){
		Configuration config = new Configuration(file);
		config.load();
		
		
		
		String Version = config.get("ModVersion", "", References.NAME).getString();
		
		//Blocks
			COPPER_PIPE_ID = config.get(CATEGORY_BLOCKS, COPPER_PIPE, COPPER_PIPE_DEFULT_ID).getInt();
			
			
		config.save();
	}
}
