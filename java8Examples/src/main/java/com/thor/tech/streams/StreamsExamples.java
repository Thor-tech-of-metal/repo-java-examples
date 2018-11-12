package com.thor.tech.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples<T> {

    public Stream<T> getAnStreamOfT(final List<T> myList) {
        return myList.stream();
    }

    public List<T> filterValues(final T[] myArray, final Predicate<T> f) {

        final Stream<T> myStream = Arrays.stream(myArray);
        return myStream.filter(f).collect(Collectors.toList());

    }

    public Optional<T> reduceAll(final T[] myArray, BinaryOperator<T> f) {

        final Stream<T> myStream = Arrays.stream(myArray);
        return myStream.reduce(f);
    }
}
