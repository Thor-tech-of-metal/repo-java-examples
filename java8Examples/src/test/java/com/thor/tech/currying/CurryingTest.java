package com.thor.tech.currying;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class CurryingTest {

    @Test
    public void testCurryOneParam() {

        // given f = x * y
        final Calculator converter = new Calculator();
        // when  we add the first parameter as f(x)
        final Function<Double, Double> functionCalculator = converter.curryFirstParam(1.0);
        // then f(1.0).appply(y)
        assertEquals(new Double(10.0), functionCalculator.apply(10.0));
        assertEquals(new Double(20.0), functionCalculator.apply(20.0));
        assertEquals(new Double(50.0), functionCalculator.apply(50.0));
    }


    @Test
    public void testCurryTwoParam() {

        // given f = x * y
        final Calculator converter = new Calculator();
        // when  we add the second parameter as f(y)
        final Function<Double, Double> functionCalculator = converter.currySecondParam(1.0);
        // then f(1.0).appply(x)
        assertEquals(new Double(10.0), functionCalculator.apply(10.0));
        assertEquals(new Double(20.0), functionCalculator.apply(20.0));
        assertEquals(new Double(50.0), functionCalculator.apply(50.0));
    }


    @Test
    public void testCurryOneParamWithFunction() {

        //given  f = x * y and g = n + 5  we would like to do  //f(x,y) = f(g(x),y)
        final Calculator converter = new Calculator();
        //when function  g = n + 5  and as first parameter is g()  we have f( g(x) ) as first parameter
        final Function<Double, Double> functionCalculator = converter.curryFirstParam(1.0).andThen(n -> n + 5);
        // then f( g(1.0)).appply(y)
        assertEquals(new Double(15.0), functionCalculator.apply(10.0));
        assertEquals(new Double(25.0), functionCalculator.apply(20.0));
        assertEquals(new Double(55.0), functionCalculator.apply(50.0));
    }

    @Test
    public void testCurryComposeOneParamWithFunction() {

        //given  f = x * y and g = n + 5  we would like to do  //f(x,y) = f(x, g(y) )
        final Calculator converter = new Calculator();
        //when function  g = n + 5  and as second parameter g() we have f( g(y) )
        final Function<Double, Double> functionCalculator = converter.composeSecondParameter((Double n) -> n + 5)
                .currySecondParam(2.0);

        //value is  (2+5)* 10 = 70
        assertEquals(new Double(70), functionCalculator.apply(10.0));
        assertEquals(new Double(140), functionCalculator.apply(20.0));
        assertEquals(new Double(350), functionCalculator.apply(50.0));
    }
}


