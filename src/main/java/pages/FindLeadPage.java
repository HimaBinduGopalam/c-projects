package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class FindLeadPage extends OpentapsWrappers {
	
	public FindLeadPage() {
		if(!verifyTitle("Find Leads | opentaps CRM"))
			Reporter.reportStep("This is not Find Leads Page", "FAIL");
	}
	
	public FindLeadPage enterFirstName(String Firstname) {
		enterByXpath(prop.getProperty("FindLead.FirstName.Xpath"), Firstname);
		return this;
	}
	
	public FindLeadPage enterLeadId(String id) {
		enterByXpath(prop.getProperty("FindLead.LeadId.Xpath"), id);
		return this;
	}
	
	public FindLeadPage enterPhoneNumber(String PhoneNumber) {
		enterByName(prop.getProperty("FindLead.Phonenumber.name"), PhoneNumber);
		return this;
	}
	
	public FindLeadPage enterEmailAddress(String Email) {
		enterByName(prop.getProperty("FindLead.EmailAddress.name"), Email);
		return this;
	}
	
	public FindLeadPage clickFindLeadbutton() {
		clickByXpath(prop.getProperty("FindLead.Findlead.Xpath"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public ViewLeadPage clickFirstAppearedLeadlink() {
		clickByXpath(prop.getProperty("FindLead.Firstlead.Xpath"));
		return new ViewLeadPage();
	}
	
	public FindLeadPage clickPhoneTab() {
		clickByXpath(prop.getProperty("FindLead.PhoneTab.Xpath"));
		return this;
	}
	
	public FindLeadPage clickNameAndIdTab() {
		clickByXpath(prop.getProperty("FindLead.NameAndIdTab.Xpath"));
		return this;
	}
	
	public FindLeadPage clickEmailTab() {
		clickByXpath(prop.getProperty("FindLead.EmailTab.Xpath"));
		return this;
	}
	
	public FindLeadPage verifyNoData() {
		verifyTextByXpath(prop.getProperty("FindLead.NoData.Xpath"),"No records to display");
		return this;
	}
}
