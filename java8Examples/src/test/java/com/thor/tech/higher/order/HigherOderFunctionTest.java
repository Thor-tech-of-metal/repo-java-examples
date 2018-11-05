package com.thor.tech.higher.order;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HigherOderFunctionTest {

    @Test
    public void testHigherOrderFunctionStringParam() {

        final HigherOderFunction<String, Integer> higherOderFunction = new HigherOderFunction();

        assertEquals(higherOderFunction.convertTo(3, x -> new Integer(x + x).toString()), "6");
    }

    @Test
    public void testHigherOrderFunctionLongParam() {

        final HigherOderFunction<Long, Integer> higherOderFunction = new HigherOderFunction();

        assertEquals(higherOderFunction.convertTo(3, x -> new Long(x * x)), new Long(9));
    }

}




