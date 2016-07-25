package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;

public class TC007_ViewLead extends OpentapsWrappers {

	@Test(dataProvider = "fetchData")
	public void ViewLead(String Username, String passWord) {

		new LoginPage()
		.enterUserName(Username)
		.enterPassword(passWord)
		.clickLogin()
		.clickCRM()
		.clickByLink(name)
		.clickByLink()
		
		

	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC005";
		browserName="firefox";
		testCaseName="ViewLead";
		testDescription="Viewing a Lead";
	}

}
