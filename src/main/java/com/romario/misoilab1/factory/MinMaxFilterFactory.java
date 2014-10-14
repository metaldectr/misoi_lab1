package com.romario.misoilab1.factory;

import com.romario.misoilab1.filter.AbstractFilter;
import com.romario.misoilab1.filter.MinMaxFilter;

/**
 * Created by romario on 10/14/14.
 */
public class MinMaxFilterFactory extends AbstractFilterFactory {
	@Override
	public AbstractFilter createFilter() {
		return new MinMaxFilter();
	}

	public static MinMaxFilterFactory getInstance() {
		return new MinMaxFilterFactory();
	}
}
