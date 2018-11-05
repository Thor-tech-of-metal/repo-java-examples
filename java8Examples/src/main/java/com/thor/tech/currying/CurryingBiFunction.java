package com.thor.tech.currying;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface CurryingBiFunction<Param1, Param2, Return> extends BiFunction<Param1, Param2, Return> {


	default Function<Param2, Return> curryFirstParam(Param1 firstParam) {
		return u -> apply(firstParam, u);
	}

	default Function<Param1, Return> currySecondParam(Param2 secondParam) {

		return t -> apply(t, secondParam);
	}

	// compose functions to have pure function as parameters

	default <V> CurryingBiFunction<V, Param2, Return> composeFirstParameter(Function<? super V, ? extends Param1> before) {
		return (v, u) -> apply(before.apply(v), u);
	}

	default <V> CurryingBiFunction<Param1, V, Return> composeSecondParameter(Function<? super V, ? extends Param2> before) {
		return (t, v) -> apply(t, before.apply(v));
	}
}
