package pageobjects;

import org.openqa.selenium.By;


import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Button;
import auto.framework.web.Element;
import auto.framework.web.Link;
import auto.framework.web.Page;
import auto.framework.web.TextBox;
import auto.framework.web.WebControl;
import common.TestDataHandler;

public class MyStoreMyAccountPage extends PageBase {

	public static Page page = new Page("My Store - My Account Page", "http://automationpractice.com/index.php?controller=my-account");
	
	public static class HeaderSection {
		private static Link _linkAccountName = new Link("Contact Us", By.xpath("//a[@class='account']/span"));
		
		public static void verifyLoginUser(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Verify Login user");
			_linkAccountName.verifyText(testDataHandler.fullName);
		}
	}
	

}
