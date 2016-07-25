package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ViewLeadPage extends OpentapsWrappers{

	public ViewLeadPage() {
		if(!verifyTitle("View Lead | opentaps CRM"))
			Reporter.reportStep("This is not View Lead CRM page", "FAIL");
	}	

	public MyLeadsPage ClickDeleteButton() {
		clickByClassName(prop.getProperty("ViewLead.Delete.Class"));
		return new MyLeadsPage();
	}
	
	public EditLeadPage ClickEditButton() {
		clickByXpath(prop.getProperty("ViewLead.Edit.xpath"));
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new EditLeadPage();
	}

	
//	public ViewLead ClickDuplicateLeadButton() {
//		clickByClassName(prop.getProperty("ViewLead.DuplicateLead.Link"));
//		return ;
//	}
//
//	public ViewLead ClickQualifyLeadButton() {
//		clickByClassName(prop.getProperty("ViewLead.QualifyLead.Link"));
//		return ;
//	}
	
	public FindLeadPage clickFindLeadsOnView(){
		clickByLinkText(prop.getProperty("ViewLead.FindLead.Link"));
		return new FindLeadPage();
	}
	












}
