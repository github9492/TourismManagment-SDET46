package practiceSelenium;
/**
 *
 * @author Dell
 *
 */
public class VerificationUtilities{

/**
 * 
 * @param actual
 * @param expected
 * @param strategy
 * @param pageNameOrTCname
 */

	public void exactVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.equals(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
	}

	/**
	 * This method will verify for partial data
	 * @param actual
	 * @param expected
	 */
	public void partialVerify(String actual, String expected, String strategy, String pageNameOrTCname)
	{
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else
			{
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" page Displayed");
			}
			else
			{
				System.out.println(pageNameOrTCname+" page not Displayed");
			}
		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" is showing");
			}
			else
			{
				System.out.println(pageNameOrTCname+" is not showing");
			}
		}
	}
}


