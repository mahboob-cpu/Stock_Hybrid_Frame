package Utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Common_Function_Library.FunctionLibrary;
@Test

public class driver_script
{
	Workbook wb;
	static WebDriver driver;
	@Test
public static void drive() throws Exception

   {
	xlutils xi=new xlutils();

	for(int i =1; i<=xi.rowcount("MasterTestCases");i++) {
		
		String ModuleStatus="";
		if(xi.gatdata("MasterTestCases", i,2 ).equalsIgnoreCase("Y"))
		   {
			
			String TCModule=xi.gatdata("MasterTestCases", i, 1);
		   
		
		for (int j = 1; j <=xi.rowcount(TCModule); j++) 
		{
			String Description=xi.gatdata(TCModule, j, 0);
			String Object_type=xi.gatdata(TCModule, j, 1);
			String Locator_Type=xi.gatdata(TCModule, j, 2);
			String Locator_Value=xi.gatdata(TCModule, j ,3);
       
			String Test_Data=xi.gatdata(TCModule, j, 4);	
			
			
			try{
			if(Object_type.equalsIgnoreCase("startBrowser"))
			{
				driver=FunctionLibrary.startBrowser();
				
			}else if(Object_type.equalsIgnoreCase("openApplication"))
			{
				FunctionLibrary.openApplication(driver);
			}
			else if(Object_type.equalsIgnoreCase("waitForElement"))
			{
				FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value,Test_Data);

			}else if(Object_type.equalsIgnoreCase("typeAction"))
			{
				FunctionLibrary.typeAction(driver,Locator_Type, Locator_Value,Test_Data);
			}else if(Object_type.equalsIgnoreCase("clickAction"))
			     {
				FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
			     }else if(Object_type.equalsIgnoreCase("closeBrowser"))
			     {
			    	 FunctionLibrary.closeBrowser(driver);
			
			     }
			xi.setdata(TCModule, j, 5, "Pass");
			ModuleStatus="True";
			
			}catch(Exception e)
			{
				 	System.out.println("Exception handled");
			}
			
		}
	} 
}
	

	
	
	 
	
   }
	
	
	
	
}
