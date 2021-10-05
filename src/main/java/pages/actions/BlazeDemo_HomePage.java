package pages.actions;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.SeleniumDriver;

/**
 * @author karthik kaduburi
 *
 */
public class BlazeDemo_HomePage {

	private static By depCityDDown = By.xpath("//select[@name='fromPort']");
	private static By desCityDDown = By.xpath("//select[@name='toPort']");
	private static By findFlights = By.xpath("//input[@value='Find Flights']");
	private static By name = By.xpath("//input[@id='inputName']");
	private static By address = By.xpath("//input[@id='address']");
	private static By city = By.xpath("//input[@id='city']");
	private static By state = By.xpath("//input[@id='state']");
	private static By zipCode = By.xpath("//input[@id='zipCode']");
	private static By cardTypeDDown = By.xpath("//select[@id='cardType']");
	private static By visa = By.xpath("//option[@value='visa']");
	private static By americanExp = By.xpath("//option[@value='amex']");
	private static By dinersClub = By.xpath("//option[@value='dinersclub']");
	private static By credCardNo = By.xpath("//input[@id='creditCardNumber']");
	private static By month = By.xpath("//input[@id='creditCardMonth']");
	private static By year = By.xpath("//input[@id='creditCardYear']");
	private static By nameOnCard = By.xpath("//input[@id='nameOnCard']");
	private static By purchaseFlight = By.xpath("//input[@value='Purchase Flight']");
	private static By id = By.xpath("//td[text()='Id']/following::td[1]");
	private static By status = By.xpath("//td[text()='Status']/following::td[1]");

	String actual = null;
	String expected = null;
	String key, value;

	/**
	 * @param link 
	 * Clicks On Button/link
	 */
	public void clickOnElement(String link) {
		if (link.equalsIgnoreCase("findFlights")) {
			SeleniumDriver.getDriver().findElement(findFlights).click();
		} else if (link.equalsIgnoreCase("purchaseFlight")) {
			SeleniumDriver.getDriver().findElement(purchaseFlight).click();
		}
	}

	/**
	 * @param map 
	 * Enter the Info Details
	 */
	public void enterDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("depCity")) {
			SeleniumDriver.getDriver().findElement(depCityDDown).click();
			SeleniumDriver.getDriver()
					.findElement(By.xpath("//select[@name='fromPort']/option[@value='" + map.get("depCity") + "']"))
					.click();
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("desCity")) {
			SeleniumDriver.getDriver().findElement(desCityDDown).click();
			SeleniumDriver.getDriver()
					.findElement(By.xpath("//select[@name='toPort']/option[@value='" + map.get("desCity") + "']"))
					.click();
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("airlineName")) {
			SeleniumDriver.getDriver()
					.findElement(By.xpath("//td[text()='" + map.get("airlineName") + "']/preceding::td[text()='"
							+ map.get("flightId") + "']/preceding::input[@value='Choose This Flight'][1]"))
					.click();
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("name")) {
			SeleniumDriver.getDriver().findElement(name).sendKeys(map.get("name"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("address")) {
			SeleniumDriver.getDriver().findElement(address).sendKeys(map.get("address"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("city")) {
			SeleniumDriver.getDriver().findElement(city).sendKeys(map.get("city"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("state")) {
			SeleniumDriver.getDriver().findElement(state).sendKeys(map.get("state"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("zipCode")) {
			SeleniumDriver.getDriver().findElement(zipCode).sendKeys(map.get("zipCode"));
			SeleniumDriver.waitForSeconds(1);
		}

		if (map.containsKey("cardType")) {
			SeleniumDriver.getDriver().findElement(cardTypeDDown).click();
			selectCardType(map.get("cardType"));
			SeleniumDriver.waitForSeconds(1);
		}

		if (map.containsKey("credCardNo")) {
			SeleniumDriver.getDriver().findElement(credCardNo).sendKeys(map.get("credCardNo"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("month")) {
			SeleniumDriver.getDriver().findElement(month).sendKeys(map.get("month"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("year")) {
			SeleniumDriver.getDriver().findElement(year).sendKeys(map.get("year"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("nameOnCard")) {
			SeleniumDriver.getDriver().findElement(nameOnCard).sendKeys(map.get("nameOnCard"));
			SeleniumDriver.waitForSeconds(1);
		}
	}

	/**
	 * @param 
	 * cardType
	 */
	public static void selectCardType(String cardType) {
		if (cardType.equals("Visa")) {
			SeleniumDriver.getDriver().findElement(visa).click();
		} else if (cardType.equals("American Express")) {
			SeleniumDriver.getDriver().findElement(americanExp).click();
		} else if (cardType.equals("Diner's Club")) {
			SeleniumDriver.getDriver().findElement(dinersClub).click();
		}
	}

	/**
	 * @param map 
	 * Validate details on a page
	 */
	public void validateDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("id")) {

			try {
				expected = SeleniumDriver.getDriver().findElement(id).getText();
				Assert.assertNotNull(expected, "Confirmation Id is not displayed");
				System.out.println("Confirmation Id is displayed "+expected);
			} catch (NoSuchElementException e) {
				Assert.fail("\nConfirmation Id is not displayed");
			}
		} else if (map.containsKey("status")) {
			expected = map.get("status");
			try {
				actual = SeleniumDriver.getDriver().findElement(status).getText();
				Assert.assertEquals(expected, actual);

			} catch (AssertionError e) {
				Assert.fail("\nSTATUS MESSAGE DISPLAYED IS NOT VALID \n" + "Expected Message : " + expected
						+ "\nActual Message : " + actual + "\n");
			}
		}

	}

}
