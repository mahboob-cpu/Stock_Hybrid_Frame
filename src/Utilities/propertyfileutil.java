package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyfileutil {
	
		
		public static String getValueFoStringr(String key) throws Exception
		{
		Properties pr=new Properties();
		FileInputStream fi=new FileInputStream("D:\\mahboobmirza11.30\\Stock_acounting\\propertiesfiels\\respository.proprrties");
		pr.load(fi);
		fi.close();
		return(String) pr.get(key);
		}
	

	public static String getValueForKey(String key) throws Exception {
		Properties p=new Properties();
		FileInputStream fi=new FileInputStream("D:\\mahboobmirza11.30\\Stock_acounting\\propertiesfiels\\respository.proprrties");
		p.load(fi);
		fi.close();
		return(String) p.get(key);
		}
		
	
	
}
