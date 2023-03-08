package com.treysta_genericUtilities.external_resources;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.treysta_genericUtilities.enums.PropertyKey;
/**
 * In this all the method of property class present .
 * @author Dell
 *
 */

public class PropertyUtilities {
	FileInputStream fisProperty;
	//FileOutPutStream fosProperty;
	private Properties prop;
	/**
	 * This is the constructor of property utilities.
	 */
	
	public PropertyUtilities(){
		
	}
	/**
	 * This is use for the initialization of property utilities.
	 * @param filePath
	 */
	public PropertyUtilities(String filePath){
		initiallizePropertyFile(filePath);
		
	}
	/**
	 * This method is deprecated instead of that use {}
	 * @param filePath
	 */
	@Deprecated
	public void initiallizePropertyFile(String filePath)  {
		
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getPropertyData(PropertyKey key) {
		String keyString = key.name().toLowerCase();
		String value =prop.getProperty(keyString," please give proper key '" + keyString + "'").trim();
		return value;
	}
	
	

}
