package com.thor.tech.higher.order;

import java.util.function.Function;


public class HigherOderFunction<T,U>{

	public T convertTo(final U weight, final Function<U, T> converToFunction) {

		return  converToFunction.apply(weight);
	}

}
