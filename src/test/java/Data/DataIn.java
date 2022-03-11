package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataIn {
	public static String strpath="C://Users//HP PC//orange//src//test//java//Data//TestData.xlsx";
  @DataProvider
  public static Object [] []  getData(Method m) throws IOException  {
	  String str=m.getName();
	Object[][] obj;
	  boolean execution=flagStatus(str);
	    
	  if (execution==true) {
		  XSSFSheet ws=loadDataExcel(strpath,"Data");
		  
		  int maxRow=ws.getLastRowNum();
		  int maxCol=ws.getRow(0).getLastCellNum();
		  int iter=countTestCasesforIteration(str);
		 
		  obj = new Object[iter][1];
			int icnt=0;  
		  	for (int i=0;i<maxRow;i++) {
		  		 Map<Object, Object> datamap = new HashMap<>();
					  if (ws.getRow(i+1).getCell(0).toString().equalsIgnoreCase(m.getName())) {
						 // System.out.println(ws.getRow(i+1).getCell(0).toString());
						  for (int j=0;j<maxCol;j++) {
							  datamap.put(ws.getRow(0).getCell(j).toString(), ws.getRow(i+1).getCell(j).toString()); 
						  }
						 
						  obj[icnt][0] = datamap;
						  icnt=icnt+1;
						 
					  }
					  
			  }
	  }
	  else {
		  obj=new Object[0] [0] ;
	  }
	return obj;
		  
  }
  
  public static boolean flagStatus(String strTestCaseName ) throws IOException {
	boolean flag=false;
	
	XSSFSheet ws=loadDataExcel(strpath,"TestCasesFlag");
	  int maxRow=ws.getLastRowNum();
	  int maxCol=ws.getRow(0).getLastCellNum();
	  outer:  for (int i = 0; i < maxRow; i++) {
	        for (int j = 0; j < maxCol; j++) {
	        	if (ws.getRow(i+1).getCell(j).toString().equalsIgnoreCase(strTestCaseName)) {
	        		if (ws.getRow(i+1).getCell(j+1).toString().equalsIgnoreCase("True")) {
	        			System.out.println("Reached");
	        				 flag=true;
	        				 break outer;
	        				 }
	        		else {
	        			flag=false;
	        		}
	        	}
	        		
	        		}


	    }
		return flag;
  }

		
  public static XSSFSheet loadDataExcel(String strPathdata,String strSheetName) throws IOException {
			 File filePath=new File(strPathdata);
			  FileInputStream fis=new FileInputStream(filePath);
			  XSSFWorkbook  wb=new XSSFWorkbook (fis);
			  XSSFSheet ws=wb.getSheet(strSheetName);
			  return ws;
		}

		  public static int countTestCasesforIteration(String strTestCaseName) throws IOException {
			  int iCount=0;
			  XSSFSheet ws=loadDataExcel(strpath,"Data");
			  int maxRow=ws.getLastRowNum(); 
			  for (int i = 0; i < maxRow; i++) {
		  			  if (ws.getRow(i+1).getCell(0).toString().equalsIgnoreCase(strTestCaseName)) {
		  					 	iCount=iCount+1;
	        			}
			        		
			        		


			    }
			  
			  return iCount;
		  }



}
