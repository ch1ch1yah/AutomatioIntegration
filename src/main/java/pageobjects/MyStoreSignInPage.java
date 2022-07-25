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

public class MyStoreSignInPage extends PageBase {

	public static Page page = new Page("My Store - Sign In Page","http://automationpractice.com/index.php?controller=authentication&back=my-account");

	public static class AlreadyRegisteredSection {
		private static Button _buttonSignIn = new Button("Sign In", By.xpath("//button[@id='SubmitLogin']"));
		private static Link _linkForgotYourPassword = new Link("Forgot your password",	By.xpath("//a[@title='Recover your forgotten password']"));
		private static TextBox _textBoxEmailAddress = new TextBox("Email Address", By.xpath("//input[@id='email']"));
		private static TextBox _textBoxPassword = new TextBox("Password", By.xpath("//input[@id='passwd']"));

		public static void clickForgotYourPasswordLink() {
			_linkForgotYourPassword.click();
		}
		public static void signIn(TestDataHandler testDataHandler)  {
			ReportLog.setTestStep("Sign in to MyStore Application");
			_textBoxEmailAddress.type(testDataHandler.email);
			_textBoxPassword.type(testDataHandler.password);
			_buttonSignIn.click();
			WebControl.waitForPageToLoad(60);
		}
	}

	public static class CreateAnAccountSection {
		private static Button _buttonCreateAnAccount = new Button("Create an account",	By.xpath("//button[@id='SubmitCreate']"));
		private static TextBox _textBoxEmailAddress = new TextBox("Email Address",	By.xpath("//input[@id='email_create']"));

		public static void createAnAccount(TestDataHandler testDataHandler) {
			ReportLog.setTestStep("Click create and Account button");
			_textBoxEmailAddress.type(testDataHandler.email);
			_buttonCreateAnAccount.click();
		}
	}

	public static class ErrorMessageSection {
		private static Element _elementFailedAuthenticationMessage = new Element("Authentication failed message",By.xpath("//li[text()='Authentication failed.']"));
		
		public static void verifyFailedAuthentication() {
			ReportLog.setTestStep("Verify failed authentication");
			_elementFailedAuthenticationMessage.verifyDisplayed();
		}

	}

}
