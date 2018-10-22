package com.thor.tech.java8.examples.mapandflatmap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapAndFlatMap {

    public Optional<String> getOptionalValueUpperCaseMap(Optional<String> optional){

        return optional.map(value -> value.toUpperCase());
    }


    public Optional<String> getOptionalValueUpperCaseFlatMap(Optional<String> optional){

        return optional.flatMap(value -> Optional.ofNullable( value.toUpperCase()));
    }

    public List<String> flatListOfList(List<List<String>> list){

        return list.stream()
                .flatMap(listParam -> listParam.stream())
                .collect(Collectors.toList());
    }

    public Optional<Integer> flaMaptSum(List<List<String>> list) {

        return list.stream()
                .flatMap(listParam -> listParam.stream())
                    .map(element -> Integer.valueOf(element))
                        .reduce((value1,value2) -> value1 + value2);
    }


    public List<Optional<Integer>> mapSum(List<List<String>> list) {

         return list.stream()
                    .map(listParam -> listParam.stream()
                        .map( element -> Integer.valueOf(element) )
                            .reduce((value1,value2) -> value1 + value2)
                    ).collect(Collectors.toList());

    }
}
