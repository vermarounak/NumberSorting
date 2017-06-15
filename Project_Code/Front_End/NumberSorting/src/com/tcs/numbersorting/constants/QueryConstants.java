/**
 * 
 */
package com.tcs.numbersorting.constants;

/**
 * @author 669517
 * This file contains queries used in the project
 */
public class QueryConstants {

	private QueryConstants() {

	}

	// Query to store results in the database along with input values
	public static final StringBuilder STORE_SORTED_NUMBERS = new StringBuilder(
			"insert into number_tbl (s_no, input_numbers, sorted_numbers) "
					+ "values (numbersorting_sno_seq.nextval, ?, ?)");

	// Query to fetch data from the database
	public static final StringBuilder FETCH_PREVIOUS_RESULTS = new StringBuilder(
			"select s_no, input_numbers, sorted_numbers from number_tbl order by s_no asc");
}
