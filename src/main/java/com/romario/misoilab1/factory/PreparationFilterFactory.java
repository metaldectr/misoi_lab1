package com.romario.misoilab1.factory;

import com.romario.misoilab1.filter.AbstractFilter;
import com.romario.misoilab1.filter.PreparationFilter;

/**
 * Created by romario on 10/10/14.
 */
public class PreparationFilterFactory extends AbstractFilterFactory {

	public static PreparationFilterFactory getInstance() {
		return new PreparationFilterFactory();
	}


	@Override
	public AbstractFilter createFilter() {
		return new PreparationFilter();
	}
}
