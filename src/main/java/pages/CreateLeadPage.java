package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CreateLeadPage extends OpentapsWrappers{
	//creating a lead page
	public CreateLeadPage() {
		if(!verifyTitle("Create Lead | opentaps CRM"))
			Reporter.reportStep("This is not CRM Home Page", "FAIL");
	}	

	public CreateLeadPage enterCompanyName(String Companyname) {
		enterById(prop.getProperty("CreateLead.Companyname.Id"), Companyname);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String FirstName) {
		enterById(prop.getProperty("CreateLead.Firstname.Id"), FirstName);
		return this;
	}
	
	public CreateLeadPage enterLastName(String Lastname) {
		enterById(prop.getProperty("CreateLead.Lastname.Id"), Lastname);
		return this;
	}
	
	public CreateLeadPage enterEmail(String Email) {
		enterById(prop.getProperty("CreateLead.EmailAddress.Id"), Email);
		return this;
	}
	
	public CreateLeadPage enterPhonenumber(String Phonenumber) {
		enterById(prop.getProperty("CreateLead.PhoneNumber.Id"), Phonenumber);
		return this;
	}
	
	public CreateLeadPage SelectSourceByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("CreateLead.Source.Id"), visibletext);
		return this;
	}
	
	public CreateLeadPage SelectSourceByIndex(int index) {
		selectByIndex(prop.getProperty("CreateLead.Source.Id"), index);
		return this;
	}
	
	public CreateLeadPage SelectSourceByValue(String value) {
		selectByValue(prop.getProperty("CreateLead.Source.Id"), value);
		return this;
	}
	
	public CreateLeadPage SelectMarketingCampaignByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("CreateLead.MarketingCampaign.Id"), visibletext);
		return this;
	}
	
	public CreateLeadPage SelectMarketingCampaignByIndex(int index) {
		selectByIndex(prop.getProperty("CreateLead.MarketingCampaign.Id"), index);
		return this;
	}
	
	public CreateLeadPage SelectMarketingCampaignByValue(String value) {
		selectByValue(prop.getProperty("CreateLead.MarketingCampaign.Id"), value);
		return this;
	}

	public ViewLeadPage ClickCreateLeadButton() {
		clickByClassName(prop.getProperty("CreateLead.Createlead.Class"));
		return new ViewLeadPage();
	}


}
