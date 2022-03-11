package TestCases;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;
import Data.DataIn;
import Libraries.BasicFunctions;
import Libraries.SetUp;
import ObjectRepository.Login_Objects;

public class TS_01_OrangeHRM_Login_Random_Credential extends SetUp {
	@Test(dataProvider ="getData",dataProviderClass=DataIn.class)
	public void TS_01_OrangeHRM_Login_Invalid_Credential(Map <Object, Object>map) throws IOException {
		startBrowser();
		BasicFunctions bs=new BasicFunctions(driver);
		Login_Objects lO=new Login_Objects(driver);
		bs.fn_OpenBrowser();
		lO.fn_login((String) map.get("userid"),(String) map.get("password"));
		lO.VerifyError((String) map.get("ErrorMessage"));
		bs.closebrower();

	}
}
