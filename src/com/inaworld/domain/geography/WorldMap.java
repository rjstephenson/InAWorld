package com.inaworld.domain.geography;

import com.didact.issuemanagement.InAWorldException;
import com.inaworld.domain.interfaces.Occupant;

public class WorldMap {
	private Block[][][] matrix;
	private int xBoundary;
	private int yBoundary;
	private int zBoundary;
	private static WorldMap instance = null;

	public static WorldMap getInstance() throws InAWorldException {
		if (instance == null) {
			throw new InAWorldException("Failure: WorldMap needs to be instantiated with x,y,z boundaries before use.");
		}
		return instance;
	}

	public static WorldMap getInstance(int x, int y, int z) {
		instance = new WorldMap(x, y, z);
		return instance;
	}

	public WorldMap(int x, int y, int z) {
		xBoundary = x;
		yBoundary = y;
		zBoundary = z;
		matrix = new Block[xBoundary][yBoundary][zBoundary];
		for (z = 0; z < zBoundary; z++) {
			for (y = 0; y < yBoundary; y++) {
				for (x = 0; x < xBoundary; x++) {
					matrix[x][y][z] = new SkyBlock();
				}
			}
		}

	}

	/**
	 * @param matrix
	 *            the matrix to set
	 */
	public void setMatrix(Block[][][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * @return the matrix
	 */
	public Block[][][] getMatrix() {
		return matrix;
	}

	/**
	 * @return the xBoundary
	 */
	public int getxBoundary() {
		return xBoundary;
	}

	/**
	 * @return the yBoundary
	 */
	public int getyBoundary() {
		return yBoundary;
	}

	/**
	 * @return the zBoundary
	 */
	public int getzBoundary() {
		return zBoundary;
	}

	public Block getBlock(Location location) {
		return matrix[location.getX()][location.getY()][location.getZ()];
	}

	public Block getBlock(int x, int y, int z) {
		return matrix[x][y][z];
	}

	public void setBlock(Block block, Location location) {
		matrix[location.getX()][location.getY()][location.getZ()] = block;
	}

	public void setBlockRegion(Terrain terrain, Region region) {
		Block block = BlockFactory.makeBlock(terrain);
		for (int z = region.getStartLocation().getZ(); z < region.getEndLocation().getZ(); z++) {
			for (int y = region.getStartLocation().getY(); y < region.getEndLocation().getY(); y++) {
				for (int x = region.getStartLocation().getX(); x < region.getEndLocation().getX(); x++) {
					setBlock(block, new Location(x, y, z));
				}
			}
		}

	}
	public boolean isRegionObstructed(Region region) {
		for (int z = region.getStartLocation().getZ(); z < region.getEndLocation().getZ(); z++) {
			for (int y = region.getStartLocation().getY(); y < region.getEndLocation().getY(); y++) {
				for (int x = region.getStartLocation().getX(); x < region.getEndLocation().getX(); x++) {
					for (Occupant occupant : getBlock(new Location(x, y, z)).getOccupants()) {
						if (occupant.isObstruction()) return false;
					}
				}
			}
		}
		return true;
	}
	
}
