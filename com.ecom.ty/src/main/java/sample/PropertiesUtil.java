package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtil {
public static void main(String[] args) throws Exception {
	// input 
	FileInputStream fis = new FileInputStream("C:\\selenium\\orangehrmM5.properties");
	Properties pobj = new Properties();
	//load
	pobj.load(fis);
	//read
	String URL = pobj.getProperty("url");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}
