package com.thor.tech.function.interfaze;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FunctionCalculationInterfaceTest {


	@Test
	public void testCurryOneParam(){

		// f = x * y
		final FunctionCalculationInterface f  = (int x)->x*x;

		assertEquals( f.calculate(3), new Integer (9) );
	}
}
