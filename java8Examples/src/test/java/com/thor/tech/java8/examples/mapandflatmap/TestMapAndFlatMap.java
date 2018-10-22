package com.thor.tech.java8.examples.mapandflatmap;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TestMapAndFlatMap {

    private  final MapAndFlatMap mapAndFlatMap = new MapAndFlatMap();

    @Test
    public void test_getOptionalValueUpperCaseMap() {


        assertEquals(Optional.of("TEST"), mapAndFlatMap.getOptionalValueUpperCaseMap(Optional.of("test")));
    }


    @Test(expected = NullPointerException.class)
    public void test_getOptionalValueUpperCaseMapNull() {

        assertEquals(Optional.empty(), mapAndFlatMap.getOptionalValueUpperCaseMap(Optional.of(null)));
    }

    @Test
    public void test_getOptionalValueUpperCaseFlatMap() {

        assertEquals(Optional.of("TEST"), mapAndFlatMap.getOptionalValueUpperCaseFlatMap(Optional.of("test")));
    }

    @Test
    public void test_getOptionalValueUpperCaseFlatMapNull() {

        assertEquals(Optional.ofNullable(null), mapAndFlatMap.getOptionalValueUpperCaseFlatMap(Optional.ofNullable(null)));
    }

    @Test
    public void test_flatListOfList() {

        final List<List<String>> list = Arrays.asList( Arrays.asList("a"), Arrays.asList("b"));
        final List<String> expectedResult = Arrays.asList("a","b");

        assertEquals(expectedResult, mapAndFlatMap.flatListOfList( list));
    }


    @Test
    public void test_flatSum() {

        final List<List<String>> list = Arrays.asList( Arrays.asList("1","2","3"), Arrays.asList("2","2"));
        final Optional<Integer> expectedResult = Optional.of(10);

        assertEquals(expectedResult, mapAndFlatMap.flaMaptSum( list));
    }


    @Test
    public void test_mapSum() {

        final List<List<String>> list = Arrays.asList( Arrays.asList("1","2","3"), Arrays.asList("2","2"));
        final List<Optional<Integer>> expectedResult = Arrays.asList(  Optional.of(6), Optional.of(4));

        mapAndFlatMap.mapSum( list);
        assertEquals(expectedResult, mapAndFlatMap.mapSum( list));
    }


}