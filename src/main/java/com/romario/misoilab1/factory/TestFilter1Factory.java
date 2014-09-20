package com.romario.misoilab1.factory;

import com.romario.misoilab1.filter.AbstractFilter;
import com.romario.misoilab1.filter.TestFilter1;

/**
 * Created by romario on 9/20/14.
 */
public class TestFilter1Factory extends FilterAbstractFactory {

	public static TestFilter1Factory getInstance() {
		return new TestFilter1Factory();
	}

	@Override
	public AbstractFilter createFilter() {
		return new TestFilter1();
	}
}
