package genericUtilityOrLibrary;

import java.io.FileInputStream;
import java.util.Properties;

import GenericLibraryOrUtility.IconstantUtility;

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
