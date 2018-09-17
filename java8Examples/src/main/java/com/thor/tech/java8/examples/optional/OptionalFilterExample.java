package com.thor.tech.java8.examples.optional;

import java.util.Optional;

public class OptionalFilterExample {

    public static void main(String[] args) {

        final Optional<String> gender = Optional.of("MALE");
        final Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty

    }

}