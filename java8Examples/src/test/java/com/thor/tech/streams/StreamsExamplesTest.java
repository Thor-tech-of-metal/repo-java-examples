package com.thor.tech.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    @Test
    public void testFilter(){

        //given
        final StreamsExamples streamsExamples = new <Integer>StreamsExamples();

        final Integer[] myArray = {1, 5, 8};

        // when
        final List<Integer> filterList = streamsExamples.filterValues(myArray,  x -> Integer.parseInt(x.toString()) >  5 );

        //then
        assertEquals(filterList, Arrays.asList(8));
    }
    @Test
    public void testReduce(){

        //given
        final StreamsExamples streamsExamples = new <Integer>StreamsExamples();

        final Integer[] myArray = {1, 5, 8};

        // when
        final Optional<Integer> filterList = streamsExamples.reduceAll(
                myArray,
                (element1, element2) -> Integer.parseInt(element1.toString()) + Integer.parseInt(element2.toString())
        );

        //then
        assertEquals( Optional.of(14),filterList);
    }

}
