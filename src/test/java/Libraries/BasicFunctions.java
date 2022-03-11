package Libraries;


import java.io.IOException;
import java.util.Arrays;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;


public class BasicFunctions {

	public WebDriver driver;
	
	
	public BasicFunctions(WebDriver driver) {
		this.driver=driver;
	}
	
	String URL=ConfigFileReader.fn_returnURL();
//	public   Properties fn_loadpro() throws IOException {
//		  File f=new File("C:\\Users\\HP PC\\orange\\src\\test\\resources\\config\\globalConfig.properties");
//		  FileInputStream FileInput =new FileInputStream(f);
//		  Properties prop=new Properties();
//		  prop.load(FileInput);
//		  String URL=prop.getProperty("URL");
//		  return prop;
//	  }

	/**
	 * Used to Navigate to URL
	 * @param URL=Application URL
	 * @throws IOException 
	 */

			
	public void fn_OpenBrowser() throws IOException {
		
		try{
			
			//Properties configProp =fn_loadpro();
			//String URL=configProp.getProperty("URL");
			driver.get(URL);
			SetUp.func_printlogPass("Successfully Navigated to the URL"+ URL);
			
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Navigate to the URL"+ URL);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}



	/**
	 * Used to Click WebElement
	 * @param Locator=Application and Element name 
	 * @throws IOException 
	 */
	public void fn_click(By Locator, String elem) throws IOException {
		
		try{
			driver.findElement(Locator).click();
			SetUp.func_printlogPass("Successfully clicked on "+elem );;
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Click to Elemenent"+ elem);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}
	
	public void fn_sendKeys(By Locator, String strInput) throws IOException {
		
		try{
			driver.findElement(Locator).sendKeys(strInput);
			SetUp.func_printlogPass("Successfully Entered on Locator:"+Locator+" as "+strInput );;
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Enter "+ strInput);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}

	public String Screenshot() {
		return ((TakesScreenshot )driver).getScreenshotAs(OutputType.BASE64);
	}

	public void fn_verfiyErrorMessage(By Locator, String strInput) throws IOException {
		
		try{
			String str=driver.findElement(Locator).getText();
			if(str.equalsIgnoreCase(strInput)) {
				SetUp.func_printlogPass("Successfully Verified the Error Message  "+strInput );;
			}else {
				SetUp.func_printlogFail("Not able to verify the  Error Message "+ strInput);
				SetUp.childTest.fail("Not able to click to Element",
						MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
			}
			
			
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Enter "+ strInput);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}

	public void fn_getuserid_Password(By Locator, String strInput) throws IOException {
		
		try{
			
			
			SetUp.func_printlogPass("Successfully Entered  "+strInput );
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Enter "+ strInput);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}

	public void closebrower() throws IOException {
		
		try{
			
			driver.close();
			SetUp.func_printlogPass("Successfully Closed the browser  " );
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Close the browser ");
			SetUp.childTest.fail("Not able to Close the browser",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}

	public String [] getuserPass(String m) throws IOException {
		int iCount=0;
		String[] strAr3= new String[2];
		try{
			
			String[] t =m.split(" ");
			for (int i=0;i<t.length;i++) {
			if (t[i].equalsIgnoreCase(":")) {
				if(iCount==0) {
					strAr3[0]=t[i+1];
					iCount=iCount+1;
				}else {
					strAr3[1]=t[i+1]; 
			 	}
			}

	 	}
			SetUp.func_printlogPass("Successfully retried user and pass from login page "+Arrays.toString(strAr3) );
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able get the user id and password");
			SetUp.childTest.fail("Not able get the user id and password",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		return strAr3;
		
	}
	
	public void elementExist(By Locator, String strInput) throws IOException {
		
		try{
			
			boolean sts=driver.findElement(Locator).isDisplayed();
			if (sts==true) {
				SetUp.func_printlogPass("Successfully Verified:  "+strInput );
			}else {
				SetUp.func_printlogFail("Not able to Verify : "+Locator);
			}
			
		
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Close the browser ");
			SetUp.childTest.fail("Not able to Close the browser",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}
	
}	
