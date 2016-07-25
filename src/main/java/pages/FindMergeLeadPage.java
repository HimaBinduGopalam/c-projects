package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class FindMergeLeadPage extends OpentapsWrappers{
	
	
	public FindMergeLeadPage() {
		if(!verifyTitle("Find Leads"))
			Reporter.reportStep("This is not FindMerge leads Page", "FAIL");
	}
	
	public FindMergeLeadPage enterFirstName(String FirstName) {
		enterByName(prop.getProperty("FindMergeLead.FirstName.name"), FirstName);
		return this;
	}
	
	public FindMergeLeadPage enterPhoneNumber(String PhoneNumber) {
		enterByName(prop.getProperty("FindMergeLead.PhoneNumber.name"), PhoneNumber);
		return this;
	}
	
	public FindMergeLeadPage clickFindLeadbutton() {
		clickByClassName(prop.getProperty("FindMergeLead.FindLeads.Class"));
		return this;
	}
	
	public MergeLeadPage clickFirstLeadLink(){
		clickByClassName(prop.getProperty("FindMergeLead.FirstLeadLink.Class"));
		switchToParentWindow();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MergeLeadPage();
		
	}
	
	public FindMergeLeadPage clickPhoneTab() {
		clickByXpath(prop.getProperty("FindMergeLead.PhoneTab.Xpath"));
		return this;
	}
	
}
