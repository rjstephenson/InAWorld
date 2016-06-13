package com.inaworld.domain.test.geography;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.inaworld.domain.character.Character2;
import com.inaworld.domain.character.Human;
import com.inaworld.domain.geography.Block;
import com.inaworld.domain.geography.Location;
import com.inaworld.domain.geography.Region;
import com.inaworld.domain.geography.Terrain;
import com.inaworld.domain.geography.WorldMap;
import com.inaworld.domain.mass.Mass;

public class TestWorld {
	WorldMap worldMap;
	int xLowerBoundary; 
	int yLowerBoundary;
	int zLowerBoundary; 
	int xUpperBoundary; 
	int yUpperBoundary;
	int zUpperBoundary; 
	Block block;

	@Before
	public void setUp() throws Exception {
		xLowerBoundary = 0;
		yLowerBoundary = 0;
		zLowerBoundary = 0;
		xUpperBoundary = 100;
		yUpperBoundary = 100;
		zUpperBoundary = 65;
		WorldMap.getInstance(xUpperBoundary, yUpperBoundary, zUpperBoundary);
		Region dirtRegion = new Region(new Location(xLowerBoundary,yLowerBoundary,zLowerBoundary),new Location(xUpperBoundary,yUpperBoundary,10)); 
		WorldMap.getInstance().setBlockRegion(Terrain.DIRT, dirtRegion);
		Region pondRegion = new Region(new Location(50,50,7), new Location(80,80,10));
		WorldMap.getInstance().setBlockRegion(Terrain.WATER, pondRegion);

	}

	@Test
	public void populateSkyLandWater() throws Exception {
	
		// Land check
		block = WorldMap.getInstance().getBlock(new Location(0, 0, 0));
		Assert.assertEquals(block.isSolid(), true);
		Assert.assertEquals(block.isGas(), false);
		Assert.assertEquals(block.isLiquid(), false);
		// Water check
		block = WorldMap.getInstance().getBlock(55, 55, 8);
		Assert.assertEquals(block.isSolid(), false);
		Assert.assertEquals(block.isGas(), false);
		Assert.assertEquals(block.isLiquid(), true);
		// Sky check
		block = WorldMap.getInstance().getBlock(3, 3, 50);
		Assert.assertEquals(block.isSolid(), false);
		Assert.assertEquals(block.isGas(), true);
		Assert.assertEquals(block.isLiquid(), false);
	}

	@Test
	public void populateCharacter() throws Exception {
		Character2 randy = new Human(new Mass(6,1,36));
	}

	@After
	public void tearDown() throws Exception {
		block = null;
	}

}
