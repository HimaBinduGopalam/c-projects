package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC004_EditLead extends OpentapsWrappers {

	@Test(dataProvider = "fetchData")
	public void EditLead(String Username, String passWord, String Firstname, String value1, String value2 ) {

		new LoginPage()
		.enterUserName(Username)
		.enterPassword(passWord)	
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickFindLeads()
		.enterFirstName(Firstname)
		.clickFindLeadbutton()
		.clickFirstAppearedLeadlink()
		.ClickEditButton()
		.SelectNewSourceByValue(value1)
		.SelectNewMarketingCampaignByValue(value2)
		.ClickUpdateButton();
		
	}
	
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC004_EditLead";
		browserName="chrome";
		testCaseName="EditLead";
		testDescription="Editing a Lead using POM framework";
	}

}
