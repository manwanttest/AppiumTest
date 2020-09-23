package Helpers;

import org.apache.log4j.Logger;


public class LoggerHelper {
	
	public static Logger log = Logger.getLogger(LoggerHelper.class.getName());

	public static void log(String s) {
		log.info(s);
		System.out.println(s);
	}


}
