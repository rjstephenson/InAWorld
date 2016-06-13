package com.inaworld.domain.geography;

import com.inaworld.domain.interfaces.Matter;

public class DirtBlock extends Block implements Matter {
	@Override
	public boolean isLiquid() {
		return false;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public boolean isGas() {
		return false;
	} 
}
