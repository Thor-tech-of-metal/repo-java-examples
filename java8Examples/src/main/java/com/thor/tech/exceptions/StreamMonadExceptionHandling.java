package com.thor.tech.exceptions;

import javaslang.control.Try;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.Stream;

public class StreamMonadExceptionHandling {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private static final DateTimeFormatter alternateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

	/**
	 * Converts given date string in format "MM/dd/yyyy" to LocalDate.
	 * Returns Try of LocalDate representing valid LocalDate or Throwable in case of invalid value.
	 */
	private static Try<LocalDate> parseDate( String dateString){

		return Try.of( () -> LocalDate.from(formatter.parse(dateString)) );
	}

	/**
	 * Converts given date string in format "MM/dd/yyyy" to LocalDate.
	 * Returns Try of LocalDate representing valid LocalDate or Throwable in case of invalid value.
	 */
	private static Try<LocalDate> parseDateAlternate( String dateString){
		return Try.of( () -> LocalDate.from(alternateFormatter.parse(dateString)));
	}


	//The main purpose of peek() is to support debugging, When you want to see ( peek ) the elements as they flow through the certain point in a stream pipeline.
	//It is used to debug the result of some stream operations.

	public static void main(String args[]) {
		Stream.of("12/31/2014",
				"01-01-2015",
				"12/31/2015",
				"not a date",
				"01/01/2016")
				.map(StreamMonadExceptionHandling::parseDate)//Parse String to LocalDate
				//first attempt to recover the error with recoverWith.
				.map(localDateTry-> localDateTry.recoverWith( exception -> parseDateAlternate(((DateTimeParseException) exception ).getParsedString()))) //Try recovering with alternate formatter
				//after second attempt we can assume that it is a pure error so lets handle it onFailure()
				.map(localDateTry-> localDateTry.onFailure(exception -> System.out.println("Failed due to " + exception.getMessage())))//Print error on failure
				.filter(Try::isSuccess)//Filter valid results.
				.map(Try::get)//Get wrapped value in the Try.
				.map( DayOfWeek::from)//Map to day of week
				.forEach(System.out::println);//Print
	}
}

