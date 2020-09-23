package AndroidConcepts;

import java.net.MalformedURLException;

import Capabilities.Desiredcaps;

public class AndroidAppStringsTest {

	public static void main(String[] args) throws MalformedURLException {
		Desiredcaps.Appcap("General-Store.apk", "Test");
		getAppStrings();
		getGetAppStringsUsingLang();

	}

	
	public static void getAppStrings() {
		int appstrings= Desiredcaps.driver.getAppStringMap().size();
		
		System.out.println("appstrings: "+ appstrings);
		System.out.println("appstrings Entry Set: "+ Desiredcaps.driver.getAppStringMap().entrySet());
        
    }

    public static void getGetAppStringsUsingLang() {
    	int appstrings= Desiredcaps.driver.getAppStringMap("en").size();
		System.out.println("Language appstrings: "+ appstrings);
    }
}
