package com.thor.tech.intefaz.defaultt;

public interface InterfaceA {

    default String defaultMethod() {

        System.out.println("Interface A default method");
        return "InterfaceA";
    }
}

