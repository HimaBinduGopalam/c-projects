package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MergeLeadPage extends OpentapsWrappers {

	public MergeLeadPage() {
		if (parentwindow != null) {
			parentwindow = driver.getWindowHandle();
		}

		if (!verifyTitle("Merge Leads | opentaps CRM"))
			Reporter.reportStep("This is not CRM Home Page", "FAIL");
	}

	public FindMergeLeadPage clickFromLeadIcon() {
		clickByXpath(prop.getProperty("MergeLead.FromLeadIcon.Xpath"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToChildWindow();
		
		return new FindMergeLeadPage();
	}

	public FindMergeLeadPage clickToLeadIcon() {
		clickByXpath(prop.getProperty("MergeLead.ToLeadIcon.Xpath"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToChildWindow();
		return new FindMergeLeadPage();
	}

	public MergeLeadPage clickMergeButton() {
		clickByClassName(prop.getProperty("MergeLead.MergeButton.Class"));
		return this;
	}
	public ViewLeadPage acceptMergeAlert(){
		acceptAlerts();
		return new ViewLeadPage();
		
	}

}
