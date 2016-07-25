package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CRMHomePage extends OpentapsWrappers{

	public CRMHomePage() {
		if(!verifyTitle("My Home | opentaps CRM"))
			Reporter.reportStep("This is not My Home CRM Page", "FAIL");
	}	

public MyLeadsPage clickLeads(){
	clickByLinkText(prop.getProperty("CRMHome.Leads.Link"));
	return new MyLeadsPage();
}













}
