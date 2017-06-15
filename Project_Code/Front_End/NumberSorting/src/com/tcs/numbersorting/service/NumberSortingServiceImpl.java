/**
 * 
 */
package com.tcs.numbersorting.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tcs.numbersorting.dao.NumberSortingDAO;
import com.tcs.numbersorting.dto.NumberDTO;
import com.tcs.numbersorting.exception.CustomException;

/**
 * @author 669517
 *
 */
@Service
public class NumberSortingServiceImpl implements NumberSortingService {

	@Autowired
	private NumberSortingDAO numberSortingDAO;

	@Override
	public NumberDTO performSorting(NumberDTO numberDTO) throws CustomException {

		int swapCount = 0;
		Map<String, Object> sortedMap = new HashMap<>();
		sortedMap.put("sortedNumbers", null);
		String stringUserInput = numberDTO.getInputValues();

		int[] numberArray = Arrays
				.stream(stringUserInput.substring(0,
						stringUserInput.length()).split(","))
				.mapToInt(Integer::valueOf).toArray();

		int inputLength = numberArray.length;
		int nextCount;
		for (int outerCount = inputLength; outerCount >= 0; outerCount--) {
			for (int innerCount = 0; innerCount < inputLength - 1; innerCount++) {
				nextCount = innerCount + 1;
				if (numberArray[innerCount] > numberArray[nextCount]) {
					swapCount = swapTwoNumbers(innerCount, nextCount,
							numberArray, swapCount);
				}
			}
		}
		numberDTO.setSortedNumbers(Arrays.toString(numberArray));
		numberDTO.setSwapCount(swapCount);
		try {
			numberSortingDAO.storeSortedResult(stringUserInput, numberArray);
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return numberDTO;
	}

	private static int swapTwoNumbers(int innerCount, int nextCount,
			int[] numberArray, int swapCount) {

		int temp;
		temp = numberArray[innerCount];
		numberArray[innerCount] = numberArray[nextCount];
		numberArray[nextCount] = temp;
		swapCount = swapCount + 1;

		return swapCount;
	}

	@Override
	public List<NumberDTO> fetchPreviousResults() throws CustomException {
		List<NumberDTO> numberDTOList = null;
		try {
			numberDTOList = numberSortingDAO.fetchPreviousResults();
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return numberDTOList;
	}

}
