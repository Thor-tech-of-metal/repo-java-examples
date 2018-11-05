package com.thor.tech.intefaz.defaultt;


import com.thor.tech.higher.order.HigherOderFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ImplTest {

    @Test
    public void testImplDefault() {

        final String value = new Impl().defaultMethod();
        assertEquals("InterfaceA", value);
    }
}
