package com.inaworld.domain.geography;

import com.inaworld.domain.interfaces.Matter;

public class SkyBlock extends Block implements Matter {
	@Override
	public boolean isGas() {
		return true;
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean isLiquid() {
		return false;
	} 
}
