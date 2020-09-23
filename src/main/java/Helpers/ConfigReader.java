package Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties loadPropertyFile(String filePath) {
		// Read from properties file
		File file = new File(filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			System.out.println(e);
		}
		return prop;

	}

	public static String getValue(String key) {

		Properties prop = loadPropertyFile("src\\main\\java\\Utilities\\Config.properties");
		String keyc =prop.getProperty(key);
		LoggerHelper.log("Value of key fetched from Config file: "+keyc);
		return keyc;
	}

}
