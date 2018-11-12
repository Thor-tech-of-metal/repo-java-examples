package com.thor.tech.optional;

import java.util.Optional;

public class OptionalBasicExample {

    public static void main(String[] args) {

        final Optional<String> gender = Optional.of("MALE");
        final String answer1 = "Yes";
        final String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

    }

}