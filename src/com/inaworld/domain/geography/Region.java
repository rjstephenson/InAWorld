package com.inaworld.domain.geography;

public class Region {
	private Location startLocation;
	private Location endLocation;
	
		/**
	 * @return the startLocation
	 */
	public Location getStartLocation() {
		return startLocation;
	}

	/**
	 * @param startLocation the startLocation to set
	 */
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/**
	 * @return the endLocation
	 */
	public Location getEndLocation() {
		return endLocation;
	}

	/**
	 * @param endLocation the endLocation to set
	 */
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

		public Region (Location startLocation, Location endLocation) {
			this.startLocation = startLocation;
			this.endLocation = endLocation;
		}

		
}
