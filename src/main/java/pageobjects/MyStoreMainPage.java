package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.ReportLog;
import auto.framework.web.Link;
import auto.framework.web.Page;
import auto.framework.web.WebControl;


public class MyStoreMainPage extends PageBase {

	public static Page page = new Page("My Store - Main Page", "http://automationpractice.com/index.php");
	
	public static class HeaderSection {
		private static Link _linkContactNo = new Link("Contact Us", By.xpath("//a[@title='Contact Us']"));
		private static Link _linkSignIn = new Link("Sign in", By.xpath("//a[@class='login']"));
		
		public static void clickContactUsLink() {
			_linkContactNo.click();
		}
		public static void clickSignInLink() {
			ReportLog.setTestStep("Click on SignIn link");
			_linkSignIn.waitForExist(true, 15);
			_linkSignIn.click();
			WebControl.waitForPageToLoad(60);
			
		}
	}
}