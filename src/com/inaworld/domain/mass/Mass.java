package com.inaworld.domain.mass;

public class Mass {
	int heightFeet = 0;
	int heightInches = 0;
	int height = 0;
	int width = 0;
	int weight = 0;
	
	public Mass (int heightFeet, int heightInches, int width) {
		this.heightFeet = heightFeet;
		this.heightInches = heightInches;
		/**
		 * only allow odd number widths so there can be a defined middle
		 * for example 15 inches and 1 inch and 15 inches. Position 16 is middle. 
		 */
		
		this.width = width % 2 == 0 ? width + 1 : width;
		this.height = this.heightFeet * 12 + heightInches;
	}
	
	public Mass (int heightFeet, int heightInches, int width, int weight) {
		this(heightFeet, heightInches, width);
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return heightFeet;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.heightFeet = height;
	}
	/**
	 * @return the heightInches
	 */
	public int getHeightInches() {
		return heightInches;
	}

	/**
	 * @param heightInches the heightInches to set
	 */
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
