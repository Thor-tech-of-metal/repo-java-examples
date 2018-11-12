package com.thor.tech.optional;

import java.util.Optional;

public class OptionalMapFlapMapExample {

    public static void main(String[] args) {

        final Optional<String> nonEmptyGender = Optional.of("male");
        final Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        final Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));

        final String flattenInJava =nonEmptyOtionalGender.flatMap(
                gender -> gender.map( element->element.toUpperCase()  )
        ).orElse( "no value" );

        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
        System.out.println("flatten in java :: " + flattenInJava);

    }

}
