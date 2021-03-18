# Notes of java 8 examples
 


#### Lambda expressions

This expressions has been created to avoid the use of anonymous inner classes.

 
#### function interface

@FunctionalInterface is used to define the signatures of a lambda esxpression.

```
@FunctionalInterface
interface FunctionCalculationInterface {

	Integer calculate(int param);
}

final FunctionCalculationInterface f  = (int x)->x*x;
assertEquals( f.calculate(3), new Integer (9) );
```

#### function interfaces
All interfaces are in java.util.function

* Predicate: The Predicate interface has an abstract method test which gives a Boolean value as a result for the specified argument.  

* Function: The Function interface has an abstract method apply which takes argument of type T and returns a result of type R. 
```
public interface Function<T, R> { … }

```

#### UnaryOperator<T>

It is used when a functions whose argument and return value are of this same type. Similar to  Function<Integer,Integer>


####  BinaryOperator

In Java, a function that receives two arguments of the same type is called BinaryOperator.

BinaryOperator<Integer> sum = (a,b) -> a + b;
Integer res = sum.apply(1,2); // yields 3


#### BiFunction: 
```  
public interface BiFunction<T, U, R> {}
```

#### BiPredicate
```
BiPredicate<Integer, String> condition = (i,s)-> i>20 && s.startsWith("R"); always return boolean
```


#### The use of ::

:: will return the function definition or a pointer to the declared function.
We can manipulate functions without evaluating them.

```
public class Utils {
   public static Integer add1(Integer x) { return x + 1; }
}

Function<Integer,Integer> add1 = Utils::add1;
Integer two = add1.apply(1); //yields 2
```


#### More thann two parameters

```
@FunctionalInterface
public interface TriFunction<T,U,S, R> {
    /**
    * Applies this function to the given arguments.
    * @param t the first function argument
    * @param u the second function argument
    * @param s the third function argument
    * @return the function result
    */
    R apply(T t, U u, S s);
}

final TriFunction volume = (x,y,z) -> x*y*z

volume.apply(2.4, 5.3, 10.4)

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
final Function<Integer, Function<Integer, Integer>> sum = x -> y -> x + y;
final Function<Integer, Integer> plus5 = sum.apply(10);
final Integer res = plus5.apply(5); //yields 15

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

#### Streams collections remember

1) List to Stream
```
final List<Integer> myList = new ArrayList<Integer>();
final Stream<Integer> myStream = myList.stream();
```

2)  Convert an array to stream using Arrays
```
final Integer[] myArray = {1, 5, 8};
final Stream<Integer> myStream = Arrays.stream(myArray);

final myList = Arrays.asList(8)
```

3) collect from Stream
```
final Integer[] myArray = {1, 5, 8};
final Stream<Integer> myStream = Arrays.stream(myArray);
final List<Integer> list = myStream.collect(Collectors.toList());

```
4) myNewStream.toArray

```
final Stream<Integer> myStream = myList.stream();
final String[] myNewArray = myNewStream.toArray(String[]::new);
```

5) stream<T> and [GENERIC_VALUE]stream
```
IntStream.of(1, 2, 3);

IntStream.iterate(0, i -> i + 2).limit(3);  result ->  0, 2, 4

```

6) The Stream.peek(Consumer) method expects a Consumer, which is essentially a block of code that accepts a single argument and returns nothing. 
    peek() is normally used for debug.
```
The Stream.peek(Consumer) 
```

#### Map and flatMap in the world of java

* T.map(F) always return T
* T.flatMap(F) always return T

* java has map().orElse()

* stream.flatMapTo[GENERIC] always return [GENERIC]Stream
* stream.mapTo[GENERIC] always return [GENERIC]Stream

* mapToObject will simply return a Stream of the type that the mapping returns.
Convert from stream[T] in to another stream[B].

```
final Stream<Color> stream = IntStream.range(1, 5).mapToObj(i -> getColor(i));
```
From Stream[Intege] to Stream [Color]


#### Flat a List of List to a Flat List

```
public List<String> flatListOfList(List<List<String>> list){

        return list.stream()
                .flatMap(listParam -> listParam.stream())
                .collect(Collectors.toList());
    }
```

or

```
public <T> List<T> flattenListOfListsStream(List<List<T>> list) {
    return list.stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toList());    
}
```

### List of List flat in one number 

```
public Optional<Integer> flaMapSum(List<List<String>> list) {

        return list.stream()
                .flatMap(listParam -> listParam.stream())
                    .map(element -> Integer.valueOf(element))
                        .reduce((value1,value2) -> value1 + value2);
    }
    
```

### Sum each values of the sublist and produce a new list

Arrays.asList( Arrays.asList("1","2","3"), Arrays.asList("2","2"));

```
public List<Optional<Integer>> mapSum(List<List<String>> list) {

         return list.stream()
                    .map(listParam -> listParam.stream()
                        .map( element -> Integer.valueOf(element) )
                            .reduce((value1,value2) -> value1 + value2)
                    ).collect(Collectors.toList());

    }
```


### Why order matters

The next example consists of two intermediate operations map and filter and the terminal operation forEach. 
Let's once again inspect how those operations are being executed:

```
Stream.of("d2", "a2", "b1", "b3", "c")
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .filter(s -> {
        System.out.println("filter: " + s);
        return s.startsWith("A");
    })
    .forEach(s -> System.out.println("forEach: " + s));

// map:     d2
// filter:  D2
// map:     a2
// filter:  A2 (found something for the final collectt in the filter)
// forEach: A2
// map:     b1
// filter:  B1
// map:     b3
// filter:  B3
// map:     c
// filter:  C

``` 

### Stateless Intermediate Operations 

Stateless intermediate operations are the opposite of stateful and do not store any state across passes. 
This not only improves the performance of these operations, which include among others filter(), map(), findAny(), it also helps in executing the Stream operation invocations in parallel as there is no information to be shared, or any order to be maintained, between these invocations or passes. 
These are lazy representation and are donde in memory.


### Terminal Operations

Terminal operations are responsible for giving the ‘final’ output for a Stream in operation, and in the process they terminate a Stream. Terminal Operations thus do not return a Stream as their output.  Terminal operation are executed at the end. For example:
 * forEach
 * forEachOrdered
 * toArray
 * reduce
 * collect
 * min /max
 * count
 * anyMatch
 * allMatch
 * noneMatch
 * findFirst    
 * findAny
### List Java-8 Streams intermediate operations.

* filter()
* map()
* flatMap()
* distinct() : remove duplicated items in a stream of data.
* sorted()
* peek()
* limit()
* skip()

#### Optional 

* Optional.of("test") yo create an optional of String. It will not handle the case tha String can be null

* Use optional to wrap possible null pointer exceptions 

    Optional.ofNullable( value.toUpperCase()) when value can be null.

* Optional.empty(); is Optional.empty();

* Map an optional get an Optional 
optional.map(value -> value.toUpperCase()); --> Optional.of(value)

* FlatMap an Optional remove the Optional
 
    optional.flatMap(value ->  value.toUpperCase()); --> value
    
* Remove an Optional 
```
// when final Optional<List<String>> ids ....
final List<String> listOfIds = ids.orElse(Collections.emptyList());
or 
final List<String> listOfIds = ids.map(myIds-> myIds).orElse(Collections.emptyList());

```
    



