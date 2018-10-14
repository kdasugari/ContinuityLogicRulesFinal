package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtility {
	public static String getProperty(String key) throws IOException{
		String val = null;
		Properties prop = new Properties();
		try{
			FileInputStream fs = new FileInputStream(".\\src\\main\\java\\properties\\config.properties");
			prop.load(fs);
			val = prop.getProperty(key);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	return val;
	}	
	
	
	
}

