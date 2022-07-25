package scenarios;


import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestBase2;
import common.TestDataHandler;
import pageobjects.MyStoreMainPage;
import pageobjects.MyStoreSignInPage;

public class MyStore_SignInWithUnRegisteredUserTest extends TestBase2 {

	@Test
	public void testScenario() throws Exception {
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("MyStore", "RowSelection='MyStore_SignInWithUnRegisteredUserTest'");
		
		ReportLog.setTestName("My Store - SignInFunctionality");
		ReportLog.setTestCase("SignIn to My Store with Unregistered user account");

		
		ReportLog.setTestStep("Navigate to My Store app");
		WebControl.open(testDataHandler.url);
		WebControl.waitForPageToLoad(60);
		
		MyStoreMainPage.page.verifyURL();
		MyStoreMainPage.HeaderSection.clickSignInLink();
		
		MyStoreSignInPage.page.verifyURL();
		MyStoreSignInPage.AlreadyRegisteredSection.signIn(testDataHandler);
		MyStoreSignInPage.ErrorMessageSection.verifyFailedAuthentication();
		
	}
	
}




