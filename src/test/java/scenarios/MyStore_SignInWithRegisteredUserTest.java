package scenarios;



import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestBase2;
import common.TestDataHandler;
import pageobjects.MyStoreMainPage;
import pageobjects.MyStoreMyAccountPage;
import pageobjects.MyStoreSignInPage;

public class MyStore_SignInWithRegisteredUserTest extends TestBase2 {
	
	
	@Test
	public void testScenario() throws Exception   {
		
		
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("MyStore", "RowSelection='MyStore_SignInWithRegisteredUserTest'");
		
		ReportLog.setTestName("My Store - SignInFunctionality");
		ReportLog.setTestCase("Sign In to My Store with Registered user account");
		
		ReportLog.setTestStep("Navigate to My Store app");	
		WebControl.open(testDataHandler.url);
		WebControl.waitForPageToLoad(60);
		
		MyStoreMainPage.HeaderSection.clickSignInLink();
		MyStoreSignInPage.AlreadyRegisteredSection.signIn(testDataHandler);
		MyStoreMyAccountPage.HeaderSection.verifyLoginUser(testDataHandler);
		
	}
}
