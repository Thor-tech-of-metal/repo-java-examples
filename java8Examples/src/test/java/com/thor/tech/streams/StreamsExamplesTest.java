package com.thor.tech.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamsExamplesTest {

    @Test
    public void  testGetAnStreamOfT(){
        //given
        final StreamsExamples streamsExamples = new <Integer>StreamsExamples();

        final List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(8);

        final List<Integer>  expected = new ArrayList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(8);

        // when
        final Stream<Integer> stream = streamsExamples.getAnStreamOfT(myList);
        //then
        assertEquals(stream.collect(Collectors.toList()),myList);
    }
}
