package ObjectRepository;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Libraries.BasicFunctions;

public class Login_Objects {

	WebDriver driver;
	BasicFunctions bs; 
	public  Login_Objects(WebDriver driver) {
		this.driver=driver;
		bs=new BasicFunctions(driver);
	}
	
	By type=By.name("q");
	By ele_username=By.name("txtUsername");
	By ele_passwrd=By.name("txtPassword");
	By gbutton=By.linkText("norsk");
	By ele_lgnbutton=By.id("btnLogin");
	By btn=By.xpath("//*[@id=\"L2AGLb\"]/div");
	By ele_idPass=By.xpath("//*[@id=\"content\"]/div[2]/span");
	By ele_invalidCred=By.id("spanMessage");
	
	public void fn_SearchonGooglePage(String str) throws IOException {
		bs.fn_click(btn, "Click on Next button");
		bs.fn_sendKeys(type, str);
		//driver.findElement(type).sendKeys(str);	
		bs.fn_click(gbutton, "Click on Google Search button ");
	}

	public void fn_login(String usr,String pass) throws IOException {
		
		bs.fn_sendKeys(ele_username, usr);
		bs.fn_sendKeys(ele_passwrd, pass);	
		bs.fn_click(ele_lgnbutton, "Click on login  button ");
	}

	public void VerifyError(String strmessage) throws IOException {		
		bs.fn_verfiyErrorMessage(ele_invalidCred, strmessage);	
	}
	
	


		
	public void Getuserid_passandLogin() throws IOException {		
		String str=driver.findElement(ele_idPass).getText();
	
		String [] arr=bs.getuserPass(str);
		String username=arr[0].trim();
		String passwrd=arr[1].trim();
		System.out.println(username +passwrd);
		bs.fn_sendKeys(ele_username, username);
		bs.fn_sendKeys(ele_passwrd, passwrd);	
		bs.fn_click(ele_lgnbutton, "Click on login  button ");
		
	}
}
