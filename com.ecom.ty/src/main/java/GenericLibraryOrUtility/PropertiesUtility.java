package GenericLibraryOrUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this is the utility class to deal with properties file 
 * @author vivek singh 
 * version 5.1.1
 */

public class PropertiesUtility {
	/**
	 * this is the generic method t read data from properties 
	 * @param data 
	 * @return
	 * @throws Exception 
	 */
	public String getDataFromProperties(String data) throws Exception{
		FileInputStream fis = new FileInputStream(IconstantUtility.propertiesPath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String propertiesData = pobj.getProperty(data);
		return propertiesData;
	}
}
