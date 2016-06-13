package com.inaworld.domain.geography;

public class Perspective {
	private int horizonalFacing;
	private int verticalFacing;

	public Perspective(int horizonalFacing, int verticalFacing) {
		this.horizonalFacing = horizonalFacing;
		this.verticalFacing = verticalFacing;
	}

	public int getHorizonalFacing() {
		return horizonalFacing;
	}

	public void setHorizonalFacing(int horizonalFacing) {
		this.horizonalFacing = horizonalFacing;
	}

	public int getVerticalFacing() {
		return verticalFacing;
	}

	public void setVerticalFacing(int verticalFacing) {
		this.verticalFacing = verticalFacing;
	}
}