package com.utilis;

import java.util.Random;

public class RandomHelper {
	
	public static int randomInt(){
		Random ran = new Random();
		return ran.nextInt();
	}
	public static int randomInt(int max){
		Random ran = new Random();
		return ran.nextInt(max);
	}
	public static int randomInt(int min,int max){
		Random ran = new Random();
		return ran.nextInt(max-min)+min;
	}
	//Add methods for other data types.
	
}
