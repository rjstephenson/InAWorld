package com.inaworld.domain.geography;

public class BlockFactory {
	private BlockFactory() {
		// Prevent instantiation
	}

	public static Block makeBlock(Terrain terrain) {
		// Use location specific car factory
		Block block;
		switch (terrain) {
		case SKY:
			block = new SkyBlock();
			break;
		case DIRT:
			block =  new DirtBlock();
			break;
		case WATER:
			block =  new WaterBlock();
			break;
		default: 
			block = new SkyBlock();
		}
		return block;

	}
}
