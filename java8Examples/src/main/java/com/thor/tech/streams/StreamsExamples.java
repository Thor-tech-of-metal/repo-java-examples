package com.thor.tech.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsExamples <T> {

    public Stream<T> getAnStreamOfT(final List<T> myList){
        return myList.stream();
    }
}
