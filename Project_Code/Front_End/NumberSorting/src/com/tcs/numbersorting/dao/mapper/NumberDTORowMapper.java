/**
 * 
 */
package com.tcs.numbersorting.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.numbersorting.dto.NumberDTO;

/**
 * @author 669517
 * This file used to map result columns with DTO attributes.
 */
public class NumberDTORowMapper implements RowMapper<NumberDTO> {

	@Override
	public NumberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NumberDTO numberDTO = new NumberDTO();
		numberDTO.setSerialNo(rs.getInt("s_no"));
		numberDTO.setInputValues(rs.getString("input_numbers"));
		numberDTO.setSortedNumbers(rs.getString("sorted_numbers"));
		return numberDTO;
	}

}
