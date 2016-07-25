package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC006_MergeLead extends OpentapsWrappers{
	
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord,String FirstName, String SecondName)
	 {
		

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickMergeLeads()
		.clickFromLeadIcon()
		.enterFirstName(FirstName)
		.clickFindLeadbutton()
		.clickFirstLeadLink()
		.clickToLeadIcon()
		.enterFirstName(SecondName)
		.clickFindLeadbutton()
		.clickFirstLeadLink()
		.clickMergeButton()
		.acceptMergeAlert()
		.clickFindLeadsOnView()
		.enterFirstName(SecondName)
		.clickFindLeadbutton()
		.verifyNoData();
		
				
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC006-MergeLead";
		browserName="chrome";
		testCaseName="Login to OpenTaps";
		testDescription="Merge Lead using POM framework";
	}

	
	
	
	
	
	
}
