package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {

	public  WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentHtmlReporter htmlReport;
	//String method;

	
	//@BeforeMethod
	public  void startBrowser() throws IOException {
		String browser=ConfigFileReader.fn_returnBrowser();

		if(browser.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			func_printlogPass("Successfully Started Execution in "+browser+" browser");
		}else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 func_printlogPass("Successfully Launched browser as "+browser);
		}else {
			System.out.println("Brower is not provided hence launching Chrome");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			func_printlogPass("Brower is not provided hence launching Chrome");
			
			}
		}
	
	@BeforeTest
	public void startReprt() {
		String strDateTime = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		//htmlReport=new ExtentHtmlReporter("Reports/Automation_Report_"+strDateTime+".html");
		htmlReport=new ExtentHtmlReporter("Reports/Automation_Report.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		htmlReport.config().setReportName("Test Execution Report");
	}
	
	@BeforeMethod
	public void method(Method method) {
		parentTest=extent.createTest(method.getName());
		
		
	}

	public static void func_printlogPass(String str) {
		childTest=parentTest.createNode(str);
		childTest.log(Status.PASS, MarkupHelper.createLabel(str, ExtentColor.BLUE));
		
	}
	public static void func_printlogFail(String str) throws IOException {
		childTest=parentTest.createNode(str);
		childTest.log(Status.FAIL, MarkupHelper.createLabel(str, ExtentColor.BLUE));
		//SetUp.childTest.fail(str,
		//MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
	}
	



	
	public void fn_tearDown() {
		driver.close();
		
	}
	@AfterSuite
	public void fn_Suit() {
	extent.flush();
	}
	
	@BeforeMethod
	public void f1() {
	System.out.println();	
	}

}
