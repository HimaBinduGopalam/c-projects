package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC003_CreateLead extends OpentapsWrappers {

	@Test(dataProvider = "fetchData")
	public void CreateLead(String Username, String passWord, String CompanyName, String FirstName, String LastName, String Email, 
			String Phonenumber, String visibletext, String value ) {

		new LoginPage()
		.enterUserName(Username)
		.enterPassword(passWord)	
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickCreateLeads()
		.enterCompanyName(CompanyName)
		.enterFirstName(FirstName)
		.enterLastName(LastName)
		.enterEmail(Email)
		.enterPhonenumber(Phonenumber)
		.SelectSourceByVisibleText(visibletext)
		.SelectMarketingCampaignByValue(value)
		.ClickCreateLeadButton();
		
	}
	
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC003_CreateLead";
		browserName="firefox";
		testCaseName="CreateLeadPage";
		testDescription="Creating a Lead using POM framework";
	}

}
