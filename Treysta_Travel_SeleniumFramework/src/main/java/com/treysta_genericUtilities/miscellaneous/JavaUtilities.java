package com.treysta_genericUtilities.miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of java specific methods
 * @author Zero Touch
 *
 */
public class JavaUtilities {
	
	SimpleDateFormat sdf;
	Calendar cal;
	/**
	 * This method will generate random number for every execution
	 * @param boundaryValue
	 * @return
	 */
	public int getRandomNumber(int boundaryValue)
	{
		return new Random().nextInt(boundaryValue);
	}
	
	/**
	 * this method will generate the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}

	/**
	 * This method will generate the current system in specific format
	 * @return
	 */
	public String getSystemDateInFormate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormate = date+" "+month+" "+year+" "+time;
		return dateInFormate;
	}
	/**
	 * This method is used to fetch the current date.
	 * @return
	 */
	public String getCurrentDate()
	{
		sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return sdf.format(new Date());
	}
	
	/**
	 * This generic method will return current date
	 * @return
	 */
	public String getCurrentStringDate()
	{
		sdf = new SimpleDateFormat();
		cal = Calendar.getInstance();
		String date = sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * This generic method will return the date in particular pattern
	 * @param d
	 * @param pattern
	 * @return
	 */
	public String getStringDate(String d, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String date = sdf.format(cal.getTime());
		return date;	
	}
	
	/**
	 * 
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s ,  String strategy) {
		return s.split(strategy);
	}
	/**
	 * This method is use to change the encrypted data into actual data 
	 * @param s
	 * @return
	 */
	
	public String decode(String s) {
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}
	/**
	 * 
	 * This method is used to change the value in encrypted one's
	 * @param s
	 * @return
	 */
	   public String encode(String s) {
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}
	   
	   
	  
	   
	   
	  /**
		 * this method will generate the current system date
		 * @return
		 */
		public String getCurrentDateTime()
		{
			sdf=new SimpleDateFormat("MM_dd_yyyy_HH_mm_sss");
			return sdf.format(new Date());
		}

		/**
		 * This method will generate the current system in specific format
		 * @return
		 */
		public String getCurrentDateTime(String pattern) {
			sdf=new SimpleDateFormat(pattern);
			return sdf.format(new Date());
		}

		
		/**
		 * This generic method will add or subtract specific no of days to current date
		 * @param noOfDays
		 * @return
		 */
		public String addOrSubtractToCurrentDate(int noOfDays)
		{
			sdf = new SimpleDateFormat("dd_MM_yyyy");
			cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, noOfDays);
			return sdf.format(cal.getTime());
			
		}

		/**
		 * This generic method will add or subtract specific no of days to specified date 
		 * @param noOfDays
		 * @param pattern
		 * @return
		 */
		public String addOrSubtractToSpecificDate(int noOfDays, String date)
		{
			sdf = new SimpleDateFormat("dd_MM_yyyy");
			cal = Calendar.getInstance();
			try {
				cal.setTime(sdf.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DAY_OF_MONTH, noOfDays);
			return sdf.format(cal.getTime());
			
		}
	   
}
