package AndroidConcepts;

import java.net.MalformedURLException;

import Capabilities.Desiredcaps;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;


public class AndroidConnectionTest {

	public static void main(String[] args) throws MalformedURLException {
		Desiredcaps.Appcap("ApiDemos-debug.apk", "Test");
		//withWiFiEnabled();
		//withAirplaneModeDisabled();
		withAirplaneModeDisabledwithWiFiEnabledwithDataEnabled();
	}

	public static void withWiFiEnabled() {
        ConnectionState state = Desiredcaps.driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        System.out.println("Wifi Status: "+ state.isWiFiEnabled());
        
    }
//	
//	boolean turnOnOffAirplaneMode(boolean isTurnOn) {
//		boolean isEnabled = Settings.System.getInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, 0) == 1;
//
//        Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, isEnabled ? 0 : 1);
//
//        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        intent.putExtra("state", !isEnabled);
//        sendBroadcast(intent);
//	}
	
    public static void withAirplaneModeDisabled() {
    	
    	
        ConnectionState state = Desiredcaps.driver.setConnection(new ConnectionStateBuilder().withAirplaneModeDisabled().build());
       // Desiredcaps.driver.toggleAirplaneMode();
        
        System.out.println("AirplaneMode Status after Disable: "+ state.isAirplaneModeEnabled());
        System.out.println("Wifi Status: "+ state.isWiFiEnabled());
        System.out.println("Data Status: "+ state.isDataEnabled());
        state = Desiredcaps.driver.setConnection(new ConnectionStateBuilder(state).withAirplaneModeEnabled().build());
        System.out.println("Data Status: "+ state.isDataEnabled());
        System.out.println("AirplaneMode Status after Enable: "+ state.isAirplaneModeEnabled());
    }


    public static void withAirplaneModeDisabledwithWiFiEnabledwithDataEnabled() {
        ConnectionState state = Desiredcaps.driver.setConnection(new ConnectionStateBuilder(Desiredcaps.driver.getConnection()).withAirplaneModeDisabled().withWiFiEnabled()
                        .withDataEnabled()
                        .build());
        System.out.println("AirplaneMode Status after Disable: "+ state.isAirplaneModeEnabled());
        System.out.println("Wifi Status: "+ state.isWiFiEnabled());
        System.out.println("Data Status: "+ state.isDataEnabled());
    }
}
