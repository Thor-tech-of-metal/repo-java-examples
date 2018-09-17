package com.thor.tech.java8.examples.javaslang.exceptions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class StreamNoExceptionHandling {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	/**
	 * Converts given date string in format "MM/dd/yyyy" to LocalDate.
	 */
	private static LocalDate parseDate( String dateString) {
		return LocalDate.from(formatter.parse(dateString));
	}

	public static void main(String args[]) {

		Stream.of("12/31/2014",
				"01-01-2015",
				"12/31/2015",
				"not a date",
				"01/01/2016")
				.map( StreamNoExceptionHandling::parseDate) //parse string to LocalDate
				.map( DayOfWeek::from) // Map LocalDate to Day of Week
				.forEach(System.out::println); // Print
	}
}
