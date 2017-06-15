/**
 * 
 */
package com.tcs.numbersorting.service;

import java.util.List;

import com.tcs.numbersorting.dto.NumberDTO;
import com.tcs.numbersorting.exception.CustomException;

/**
 * @author 669517 This file plays the role of Service Layer and is responsible
 *         for performing all business logic in the application
 */
public interface NumberSortingService {

	NumberDTO performSorting(NumberDTO userInput) throws CustomException;

	List<NumberDTO> fetchPreviousResults() throws CustomException;

}
