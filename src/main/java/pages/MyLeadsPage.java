package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MyLeadsPage extends OpentapsWrappers {


	public MyLeadsPage() {
		if(!verifyTitle("My Leads | opentaps CRM"))
			Reporter.reportStep("This is not Create Lead Page", "FAIL");
	}	

	public CreateLeadPage clickCreateLeads(){
		clickByLinkText(prop.getProperty("MyLeadsHome.Createlead.Link"));
		return new CreateLeadPage();
	}

	public FindLeadPage clickFindLeads(){
		clickByLinkText(prop.getProperty("MyLeadsHome.Findlead.Link"));
		return new FindLeadPage();
	}
	
	public MergeLeadPage clickMergeLeads(){
		clickByLinkText(prop.getProperty("MyLeadsHome.Mergelead.Link"));
		return new MergeLeadPage();
	}

//	public MyLeadsPage threadSleep() throws InterruptedException{
//		
//			Thread.sleep(3000);
//			return this;
//		
//			}
	
}
