package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC005_DeleteLead extends OpentapsWrappers {

	@Test(dataProvider = "fetchData")
	public void DeleteLead(String Username, String passWord, String FirstName) {

		new LoginPage()
		.enterUserName(Username)
		.enterPassword(passWord)	
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickFindLeads()
		.enterFirstName(FirstName)
		.clickFindLeadbutton()
		.clickFirstAppearedLeadlink()
		.ClickDeleteButton()
		.clickFindLeads()
		.enterFirstName(FirstName)
		.verifyNoData();
				
	}
	
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC005_DeleteLead";
		browserName="firefox";
		testCaseName="DeleteLeadPage";
		testDescription="Deleting a Lead using POM framework";
	}


}


