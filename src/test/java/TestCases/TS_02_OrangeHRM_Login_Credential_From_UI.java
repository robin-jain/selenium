package TestCases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import Data.DataIn;
import Libraries.BasicFunctions;
import Libraries.SetUp;
import ObjectRepository.HomePage_Objects;
import ObjectRepository.Login_Objects;

public class TS_02_OrangeHRM_Login_Credential_From_UI extends SetUp {
	@Test(dataProvider ="getData",dataProviderClass=DataIn.class)
	public void TS_02_OrangeHRM_Login_FromTestScreen(Map <Object, Object>map) throws IOException {
		startBrowser();
		BasicFunctions bs=new BasicFunctions(driver);
		Login_Objects lO=new Login_Objects(driver);
		bs.fn_OpenBrowser();
		lO.fn_login((String) map.get("userid"),(String) map.get("password"));
		lO.VerifyError((String) map.get("ErrorMessage"));
		//lO.VerifyError("Invalid credentials");
		lO.Getuserid_passandLogin();
		HomePage_Objects Hm=new HomePage_Objects(driver);
		Hm.fn_verifyloginWelcome();
		Hm.fn_logout();
		bs.closebrower();
		

	}
}
	