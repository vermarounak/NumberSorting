/**
 * 
 */
package com.tcs.numbersorting.dto;

/**
 * @author 669517
 *
 */
public class NumberDTO {

	private String inputValues;

	private String sortedNumbers;

	private int swapCount;

	private long processingTime;

	private int serialNo;

	public String getInputValues() {
		return inputValues;
	}

	public void setInputValues(String inputValues) {
		this.inputValues = inputValues;
	}

	public String getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}

	public long getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(long processingTime) {
		this.processingTime = processingTime;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

}
