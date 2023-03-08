package com.treysta_genericUtilities.enums;
/**
 * In this class we created the enum of the excel sheet.
 * @author Dell
 *
 */
public enum MicrosoftExcel {

	ADMIN("Admin"), USER("User");
	String key;
	
	/**
	 * This constructor is use to set the data.
	 * @param key
	 */
	private MicrosoftExcel(String key) {
		this.key = key;
	}
	/**
	 * This constructor is used to get the data.
	 * @return
	 */
	public String getSheetName() {
		return key;
	}
}
