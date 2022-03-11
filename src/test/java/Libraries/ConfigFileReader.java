package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private final static String propertyFilePath= "C:\\Users\\HP PC\\orange\\src\\test\\resources\\config\\globalConfig.properties";

	
	public static String fn_returnURL()  {
		String URL;
		try {
			File f=new File(propertyFilePath);
		  FileInputStream FileInput =new FileInputStream(f);
		  Properties prop=new Properties();
		  prop.load(FileInput);
		   URL =prop.getProperty("URL");
		  return URL;
		} catch(Exception e) {
			 URL="Something is wrong with Prop file";
		}
		return URL;
	}
	public static String fn_returnBrowser()  {
		String browser;
		try {
			File f=new File(propertyFilePath);
		  FileInputStream FileInput =new FileInputStream(f);
		  Properties prop=new Properties();
		  prop.load(FileInput);
		   browser =prop.getProperty("browser");
		  return browser;
		} catch(Exception e) {
			browser="Something is wrong with Prop file";
		}
		return browser;
	}
}
