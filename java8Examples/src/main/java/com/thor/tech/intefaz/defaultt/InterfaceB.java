package com.thor.tech.intefaz.defaultt;

public interface InterfaceB {

    default String defaultMethod(){

        System.out.println("Interface B default method");
        return "InterfaceB";

    }

}