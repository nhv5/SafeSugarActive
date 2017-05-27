package com.safesugar.app;

public class Algorithm {
	
	private static Double actualHeartRate;
	private static Double glucosePulse;
	private static Double metabolizedPerMinute;
	private static Double initialBloodSugar;
	
	public static void EMGPM(String initSugar, String heartRate, String age, String activity){

		actualHeartRate = (220 - Integer.parseInt(age)) * ((double) Integer.parseInt(heartRate)/100);
		
		if(activity.equals("active")){
			Double formula = (0.00353 * Integer.parseInt(heartRate)) - 0.1428;
			
			glucosePulse = (formula * 1.03)/10;
			
			metabolizedPerMinute = glucosePulse * actualHeartRate;
			
		}
		
		if(activity.equals("sedentary")){
			//Double formula = (0.00597 * Integer.parseInt(heartRate)) - 0.1801;
			
			Double formula = (0.00536 * Integer.parseInt(heartRate)) - 0.1708;
			
			glucosePulse = (formula * 1.03)/10;
			
			metabolizedPerMinute = glucosePulse * actualHeartRate;
		}
		
		initialBloodSugar = (double) Integer.parseInt(initSugar) + metabolizedPerMinute;
	}
	
	public static Double metabolized(){
		
		initialBloodSugar = initialBloodSugar - metabolizedPerMinute;
		
		return initialBloodSugar;
	}

}
