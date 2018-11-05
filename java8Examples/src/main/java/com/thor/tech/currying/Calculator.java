package com.thor.tech.currying;

public class Calculator implements CurryingBiFunction<Double, Double, Double> {

	@Override
	public Double apply(Double conversionRate, Double value) {
		return conversionRate * value;
	}

}
