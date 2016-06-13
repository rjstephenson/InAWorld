package com.inaworld.domain.geography;

public class Location {
	int x;
	int y;
	int z;

	public Location (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}

}
