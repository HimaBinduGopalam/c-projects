package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class EditLeadPage extends OpentapsWrappers{

	public EditLeadPage() {
		if(!verifyTitle(" opentaps CRM"))
			Reporter.reportStep("This is not Opentaps CRM Page", "FAIL");
	}
	
	public EditLeadPage enterCompanyName(String Companyname) {
		enterById(prop.getProperty("EditLead.Companyname.Id"), Companyname);
		return this;
	}
	
	public EditLeadPage enterFirstName(String FirstName) {
		enterById(prop.getProperty("EditLead.Firstname.Id"), FirstName);
		return this;
	}
	
	public EditLeadPage enterLastName(String Lastname) {
		enterById(prop.getProperty("EditLead.Lastname.Id"), Lastname);
		return this;
	}
	
	public EditLeadPage SelectNewSourceByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("EditLead.NewSource.Id"), visibletext);
		return this;
	}
	
	public EditLeadPage SelectNewSourceByIndex(int index) {
		selectByIndex(prop.getProperty("EditLead.NewSource.Id"), index);
		return this;
	}
	
	public EditLeadPage SelectNewSourceByValue(String value) {
		selectByValue(prop.getProperty("EditLead.NewSource.Id"), value);
		return this;
	}
	
	public EditLeadPage SelectNewMarketingCampaignByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("EditLead.NewMarketingCampaign.Id"), visibletext);
		return this;
	}
	
	public EditLeadPage SelectNewMarketingCampaignByIndex(int index) {
		selectByIndex(prop.getProperty("EditLead.NewMarketingCampaign.Id"), index);
		return this;
	}
	
	public EditLeadPage SelectNewMarketingCampaignByValue(String value) {
		selectByValue(prop.getProperty("EditLead.NewMarketingCampaign.Id"), value);
		return this;
	}

	public ViewLeadPage ClickUpdateButton() {
		clickByClassName(prop.getProperty("EditLead.Update.Class"));
		return new ViewLeadPage();
	}
	
	
	
	
	
}
