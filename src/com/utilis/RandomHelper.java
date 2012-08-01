package com.utilis;

import java.util.Random;

public class RandomHelper {
	
	public static int randomInt(){
		Random ran = new Random();
		return ran.nextInt();
	}
	public static int randomInt(int max){
		Random ran = new Random();
		max++; //Fixes randomInt(0,2) only returning 0 and 1.
		return ran.nextInt(max);
	}
	public static int randomInt(int min,int max){
		Random ran = new Random();
		max++; //Fixes randomInt(0,2) only returning 0 and 1.
		return ran.nextInt(max-min)+min;
	}
	
	public static double randomDouble(){
		Random ran = new Random();
		return ran.nextDouble();
	}
	public static double randomDouble(double max){
		Random ran = new Random();
		return (max * ran.nextDouble());
	}
	public static double randomDouble(double max, double min){
		Random ran = new Random();
		return (min + (max-min) * ran.nextDouble());
	}
	
	public static char randomCapChar(){
		Random ran = new Random();
		char ch = (char)(ran.nextInt('Z'-'A'+1)+'A');
		return ch;
	}
	//TODO Add methods for other data types.
	
}
