/**
 * 
 */
package com.tcs.numbersorting.dao;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.numbersorting.constants.QueryConstants;
import com.tcs.numbersorting.dao.mapper.NumberDTORowMapper;
import com.tcs.numbersorting.dto.NumberDTO;
import com.tcs.numbersorting.exception.CustomException;

/**
 * @author 669517
 *
 */
@Repository
public class NumberSortingDAOImpl implements NumberSortingDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void storeSortedResult(String inputNumbers, int[] sortedNumbers)
			throws CustomException {
		try {
			jdbcTemplate.update(QueryConstants.STORE_SORTED_NUMBERS.toString(),
					new Object[] { inputNumbers, Arrays.toString(sortedNumbers) });
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
	}

	@Override
	public List<NumberDTO> fetchPreviousResults() throws CustomException {
		List<NumberDTO> numberList = null;
		try {
			numberList = jdbcTemplate.query(
					QueryConstants.FETCH_PREVIOUS_RESULTS.toString(),
					new NumberDTORowMapper());
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return numberList;
	}

}
