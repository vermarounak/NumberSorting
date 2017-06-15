/**
 * 
 */
package com.tcs.numbersorting.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.numbersorting.dto.NumberDTO;
import com.tcs.numbersorting.exception.CustomException;
import com.tcs.numbersorting.logging.LoggerFactory;
import com.tcs.numbersorting.logging.LoggerInterface;
import com.tcs.numbersorting.service.NumberSortingService;

/**
 * @author 669517 This file plays the role of controller in Spring framework and
 *         routes the requests.
 */
@RestController
public class NumberSortingController {

	private static final LoggerInterface ERRORLOG = LoggerFactory
			.getLogger("ERRORLOG");

	@Autowired
	private NumberSortingService numberSortingService;

	// Method used for performing sort operation and store the results in the
	// database.
	@RequestMapping(value = "/performSorting", method = RequestMethod.POST)
	public NumberDTO performSorting(@RequestBody String userInput,
			HttpServletRequest req) {
		Instant startTime = Instant.now();
		NumberDTO userinputDTO = null;
		try {
			ObjectMapper objMapper = new ObjectMapper();
			userinputDTO = objMapper.readValue(userInput, NumberDTO.class);
			userinputDTO = numberSortingService.performSorting(userinputDTO);
		} catch (CustomException | IOException e) {
			ERRORLOG.error("Exception in NumberSortingController | performSorting "
					+ e);
		}
		Instant endTime = Instant.now();
		userinputDTO.setProcessingTime(Duration.between(startTime, endTime)
				.toMillis());
		return userinputDTO;
	}

	// Method used for fetching results from the database and display to the
	// user.
	@RequestMapping(value = "/fetchPreviousResults", method = RequestMethod.POST)
	public List<NumberDTO> fetchPreviousResults(HttpServletRequest req) {
		List<NumberDTO> numberDTOList = null;
		try {
			numberDTOList = numberSortingService.fetchPreviousResults();
		} catch (CustomException e) {
			ERRORLOG.error("Exception in NumberSortingController | fetchPreviousResults "
					+ e);
		}
		return numberDTOList;
	}

}
