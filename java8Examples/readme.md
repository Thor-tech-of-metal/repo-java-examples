# Notes of java 8 examples
 

#### function interface

@FunctionalInterface is used to define the signatures of a lambda esxpression.

```
@FunctionalInterface
interface FunctionCalculationInterface {

	Integer calculate(int param);
}


final FunctionCalculationInterface f  = (int x)->x*x;
```

#### default method

The **default** method, or changing a method from abstract to default, does not break compatibility with pre-existing binaries.
It resolve the diamond problem. default method can only access its arguments as interfaces do not have any state.

1) For instance  When you extends a class and interface and add functionality to existing methods.

```
public interface Iterable<T> {

public default void forEach(Consumer<? super T> consumer) {

    for (T t : this) { consumer.accept(t); }
}
```
2) When you have a class that implement multiple interfaces where all interfaces have the same method signature


#### currying
In java currying is resolved by using Function interfaces. We can extend pre-existing function interfaces such us BiFunction<Param1, Param2, Return> or 
create your own interfaces functions with more complex logic such us pass another functions as parameters

```
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

// how to use it 
final Function<Double, Double> functionCalculator = converter
    .composeSecondParameter((Double n) -> n + 5)
    .currySecondParam(2.0);
    
    Double value = functionCalculator.functionCalculator.apply(10.0);
    value is  (2+5)* 10 = 70
```

 

#### higher order functions

It is a function that receive another function as parameter and return the result of the execution of the f() passes as parameter.
```
public class HigherOderFunction<T,U>{

	public T convertTo(final U weight, final Function<U, T> converToFunction) {

		return  converToFunction.apply(weight);
	}

}
// how to use it 
assertEquals(higherOderFunction.convertTo(3, x -> new Long(x * x)), new Long(9));
```

mapToIn
Arrays.stream 
peek

https://www.sitepoint.com/java-8-streams-filter-map-reduce/