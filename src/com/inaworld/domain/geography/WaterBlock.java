package com.inaworld.domain.geography;

import com.inaworld.domain.interfaces.Matter;

public class WaterBlock extends Block implements Matter {
	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean isLiquid() {
		return true;
	}

	@Override
	public boolean isGas() {
		return false;
	} 
}
