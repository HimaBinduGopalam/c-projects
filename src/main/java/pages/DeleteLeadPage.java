package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class DeleteLeadPage extends OpentapsWrappers{

	public DeleteLeadPage() {
		if(!verifyTitle(" opentaps CRM"))
			Reporter.reportStep("This is not CRM Home Page", "FAIL");
	}
	
	public DeleteLeadPage enterCompanyName(String Companyname) {
		enterById(prop.getProperty("EditLead.Companyname.Id"), Companyname);
		return this;
	}
	
	public DeleteLeadPage enterFirstName(String FirstName) {
		enterById(prop.getProperty("EditLead.Firstname.Id"), FirstName);
		return this;
	}
	
	public DeleteLeadPage enterLastName(String Lastname) {
		enterById(prop.getProperty("EditLead.Lastname.Id"), Lastname);
		return this;
	}
	
	public DeleteLeadPage SelectNewSourceByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("EditLead.NewSource.Id"), visibletext);
		return this;
	}
	
	public DeleteLeadPage SelectNewSourceByIndex(int index) {
		selectByIndex(prop.getProperty("EditLead.NewSource.Id"), index);
		return this;
	}
	
	public DeleteLeadPage SelectNewSourceByValue(String value) {
		selectByValue(prop.getProperty("EditLead.NewSource.Id"), value);
		return this;
	}
	
	public DeleteLeadPage SelectNewMarketingCampaignByVisibleText(String visibletext) {
		selectByVisibleText(prop.getProperty("EditLead.NewMarketingCampaign.Id"), visibletext);
		return this;
	}
	
	public DeleteLeadPage SelectNewMarketingCampaignByIndex(int index) {
		selectByIndex(prop.getProperty("EditLead.NewMarketingCampaign.Id"), index);
		return this;
	}
	
	public DeleteLeadPage SelectNewMarketingCampaignByValue(String value) {
		selectByValue(prop.getProperty("EditLead.NewMarketingCampaign.Id"), value);
		return this;
	}

	public ViewLeadPage ClickUpdateButton() {
		clickByClassName(prop.getProperty("EditLead.Update.Class"));
		return new ViewLeadPage();
	}
	
	
	
	
	
}
