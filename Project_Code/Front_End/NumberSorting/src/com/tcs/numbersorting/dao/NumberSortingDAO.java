/**
 * 
 */
package com.tcs.numbersorting.dao;

import java.util.List;

import com.tcs.numbersorting.dto.NumberDTO;
import com.tcs.numbersorting.exception.CustomException;

/**
 * @author 669517 This file plays the role of DAO Layer in the project and is
 *         responsible for interacting with the database.
 */
public interface NumberSortingDAO {

	void storeSortedResult(String inputNumbers, int[] sortedNumbers)
			throws CustomException;

	List<NumberDTO> fetchPreviousResults() throws CustomException;

}
