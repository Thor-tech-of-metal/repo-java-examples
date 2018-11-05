package com.thor.tech.intefaz.defaultt;

public class Impl implements InterfaceA, InterfaceB {

    public String defaultMethod() {
        // existing code here..
        return InterfaceA.super.defaultMethod();
    }

}