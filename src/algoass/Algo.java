package algoass;

import java.util.Random;

public interface Algo {

	//generate integer
	public static int autoGenInt(int min, int max) {
		Random ran = new Random();
		return ran.nextInt(max + 1) + min ;
	}
	
	//generate double for safety reason i round it to 2 decimal place
	public static double autoGenDouble(int min, int max) {
		Random ran = new Random();
		Double num = ran.nextDouble() * (max-min+1)+min ;
		return shittyRound(num,2);
	}
		
	//generate float for safety reason i round it to 2 decimal place
	public static float autoGenFloat(int min, int max) {
		Random ran = new Random();
		float num = ran.nextFloat() * (max-min+1)+min ;
		return shittyRound(num,2);
	}
	
	//generate long I don't know if anyone will use it but i put it here just for the sake of it
	public static long autoGenLong(int min, int max) {
		Random ran = new Random();
		return Math.abs(ran.nextLong() * (max-min+1)+min) ;
	}
	
	
	public static double shittyRound(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	
	//unsafe convention don't do this
	public static float shittyRound(float value, int places) {
	    double scale = Math.pow(10, places);
	    return (float) (Math.round(value * scale) / scale);
	}
	
	public static int nextFit(ItemSet itemset) {
		
		
		
		
		return 0;
		
	}
	
	
}
