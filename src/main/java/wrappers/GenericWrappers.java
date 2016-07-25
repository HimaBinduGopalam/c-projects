package wrappers;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;
import utils.ReporterWithOutScreenShot;

public class GenericWrappers {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Charan - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			/*if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else
				driver = new FirefoxDriver();
			*/
			driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Charan - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterById(String idValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByXpath(String Xpath, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(Xpath)).clear();
			driver.findElement(By.xpath(Xpath)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+Xpath, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+Xpath, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByClass(String Class, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(Class)).clear();
			driver.findElement(By.id(Class)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+Class, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+Class, "FAIL");
		}
		return bReturn;
	}
	
	public boolean enterByName(String Name, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.name(Name)).clear();
			driver.findElement(By.name(Name)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+Name, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+Name, "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Charan - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Charan - TestLeaf
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
	
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Charan - TestLeaf
	 */
	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


		return bReturn;
	}

	/**
	 * This method will close all the browsers
	 * @author Charan - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}
	
	/**
	 * This method will close the current browser
	 * @author Charan - TestLeaf
	 */
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			Reporter.reportStep("The element with id: "+id+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			Reporter.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
			//ReporterWithOutScreenShot.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.name(name)).click();
			Reporter.reportStep("The element with name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickByLinkText(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(name)).click();
			Reporter.reportStep("The element with link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using Partial link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickByPartialLinkText(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.partialLinkText(name)).click();
			
			Reporter.reportStep("The element with partial link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with partial link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Charan - TestLeaf
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Charan - TestLeaf
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Charan - TestLeaf
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Charan - TestLeaf
	 */
	public boolean mouseOverByClassName(String className) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.className(className))).build().perform();
			Reporter.reportStep("The mouse over by link : "+className+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+className+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Charan - TestLeaf
	 */
	public boolean mouseOverById(String Id) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.id(Id))).build().perform();
			Reporter.reportStep("The mouse over by link : "+Id+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+Id+" could not be performed.", "FAIL");
		}
		return bReturn;
	}


	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	public String getTextByname(String name){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(name)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+name+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	public String getTextByLinkText(String LinkText){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(LinkText)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+LinkText+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	public String getTextById(String Id){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(Id)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+Id+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	public String getTextByClass(String Class){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(Class)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+Class+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 * @author Charan - TestLeaf
	 */
	public boolean selectByIndex(String id, int index) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(index);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+index, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+index+" could not be selected.", "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (value) from the dropdown 
	 * @author Charan - TestLeaf
	 */
	
	public boolean selectByValue(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByValue(value);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Charan - TestLeaf
	 */
	public boolean selectByVisibleText(String id, String visibletext) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(visibletext);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+visibletext, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+visibletext+" could not be selected.", "FAIL");
		}
		return bReturn;
	}
	
	public boolean dismissAlerts() {
		boolean bReturn = false;
		try {
			driver.switchTo().alert().dismiss();
			Reporter.reportStep("The Alert was Dismissed", "PASS");
			bReturn = true;

		} catch (NoAlertPresentException e ) {
			Reporter.reportStep("There was no Alert", "FAIL");
		}catch (UnhandledAlertException e ) {
			Reporter.reportStep("Alert was not handled", "FAIL");
		}
		return bReturn;
	}
	
	public boolean acceptAlerts() {
		boolean bReturn = false;
		try {
			driver.switchTo().alert().accept();
			Reporter.reportStep("The Alert was Accepted", "PASS");
			bReturn = true;

		} catch (NoAlertPresentException e ) {
			Reporter.reportStep("There was no Alert", "FAIL");
		}catch (UnhandledAlertException e ) {
			Reporter.reportStep("Alert was not handled", "FAIL");
		}
		return bReturn;
	}
	
	public boolean threadsleep(int seconds){
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getAlertText() {
		String bReturn = "";
		try {
			return driver.switchTo().alert().getText();
	
		} catch (NoAlertPresentException e ) {
			Reporter.reportStep("There was no Alert", "FAIL");
		}catch (UnhandledAlertException e ) {
			Reporter.reportStep("Alert was not handled", "FAIL");
		}
		return bReturn;
	}

	public boolean switchToFrameByIndex(int index) {
		boolean bReturn = false;
		try{
			driver.switchTo().frame(index);
			Reporter.reportStep("Switched to Frame selected with value :"+index, "PASS");

			bReturn = true;

		} catch (NoSuchFrameException e) {
			Reporter.reportStep("The Frame with value: "+index+" doesn't exist.", "FAIL");
		}
		return bReturn;
	}
	
	public boolean switchToFrameByName(String name) {
		boolean bReturn = false;
		try{
			driver.switchTo().frame(name);
			Reporter.reportStep("Switched to Frame selected with value :"+name, "PASS");

			bReturn = true;

		} catch (NoSuchFrameException e) {
			Reporter.reportStep("The Frame with value: "+name+" doesn't exist.", "FAIL");
		}
		return bReturn;
	}
	
	public boolean switchedToFrameByWebElement(WebElement frameElement) {
		boolean bReturn = false;
		try{
			driver.switchTo().frame(frameElement);
			Reporter.reportStep("Switched to Frame elected with value :"+frameElement, "PASS");

			bReturn = true;

		} catch (NoSuchFrameException e) {
			Reporter.reportStep("The Frame with value: "+frameElement+" doesn't exist.", "FAIL");
		}
		return bReturn;
	}
	
	public boolean switchToDefaultContent()  {
		boolean bReturn = false;
		try{

			driver.switchTo().defaultContent();
			Reporter.reportStep("Navigated Back to Webpage from frame", "PASS");

			bReturn = true;

		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Unable to navigate back to the web page from frame", "FAIL");
		}
		return bReturn;
	}
	
	public String getParentWindowHandle(){
		String bReturn = "";
		try{
			return driver.getWindowHandle();
		} catch (NoSuchWindowException e) {
			Reporter.reportStep("No Window exists to take the window handle", "FAIL");
		}
		return bReturn; 
	}
	
	public Set<String> getchildWindowHandle(String name){
		Set<String> bReturn = null;
		try{
			return driver.getWindowHandles();
		} catch (NoSuchWindowException e) {
			Reporter.reportStep("No Window exists to take the window handle", "FAIL");
		}
		return bReturn; 
	}
	
	public String switchToParentWindow(){
		String bReturn = "";
		try{
			driver.switchTo().window(primaryWindowHandle);
		} catch (NoSuchWindowException e) {
			Reporter.reportStep("No Window exists to take the window handle", "FAIL");
		}
		return bReturn; 
	}
	
	public WebDriver switchToChildWindow(){
		WebDriver bReturn = null;
		try{
			 Set<String> Allwindowhandles =  driver.getWindowHandles();
			for (String eachWindow : Allwindowhandles) {
				 driver.switchTo().window(eachWindow);
			}
		} catch (NoSuchWindowException e) {
			Reporter.reportStep("No Window exists to take the window handle", "FAIL");
		}
		return bReturn; 
	}
		
	public void explicitWaitForVisibilityOfElement(WebElement Element, int Seconds) {
//		boolean bReturn = false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, Seconds);
			wait.until(ExpectedConditions.visibilityOf(Element));
			Reporter.reportStep("The element with Visibility: "+Element+" is selected with value :", "PASS");

//			bReturn = true;

		} catch (TimeoutException e) {
			Reporter.reportStep("The element with Visibility : "+Element+" could not be selected.", "FAIL");
		}
		
	}
	
//	public void threadSleep(){
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));
	
	}


}

