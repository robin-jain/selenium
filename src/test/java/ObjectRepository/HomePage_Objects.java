package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Libraries.BasicFunctions;

public class HomePage_Objects {

	WebDriver driver;
	BasicFunctions bs; 
	public  HomePage_Objects(WebDriver driver) {
		this.driver=driver;
		bs=new BasicFunctions(driver);
	}

	By ele_Welcome=By.id("welcome");
	By ele_logout=By.linkText("Logout");
	
	public void fn_verifyloginWelcome() throws IOException {
		bs.elementExist(ele_Welcome, "User logged in");
	}

	public void fn_logout() throws IOException {
		bs.fn_click(ele_Welcome, "Click on user icon button");
		bs.fn_click(ele_logout, "Click on log out button");

	}

}
