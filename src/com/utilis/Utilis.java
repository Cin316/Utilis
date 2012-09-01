package com.utilis;

import java.awt.*;
import java.io.File;
import java.net.URLDecoder;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Utilis{
	
	public static String version = "v. 0.3.2.1";
	
	public static boolean onMac;
	public static boolean onWindows;
	public static boolean onOtherOS;
	
	public static boolean stringIsANumber(String s){
		int numOfNumChars = 0;
		for (int i=0;i<s.length();i++){
			char scanChar = s.charAt(i);
			if (scanChar=='0'||scanChar=='1'||scanChar=='2'||scanChar=='3'||scanChar=='4'||scanChar=='5'||scanChar=='6'||scanChar=='7'||scanChar=='8'||scanChar=='9'||scanChar=='.'){
				numOfNumChars++;
			}
		}
		if (numOfNumChars==s.length()){
			return true;
		}else{
			return false;
		}
	}

	public static void delay(int n) {
		long startDelay = System.currentTimeMillis(); 
		long endDelay = 0; 
		while (endDelay - startDelay < n){
			endDelay = System.currentTimeMillis();
		}
	}
	
	public static void drawThick3DRectangle(Graphics g, int x, int y, int width, int height, int howThick){
		g.draw3DRect(x, y, width, height, true);
		for (int i=0; i<howThick; i++){
			g.draw3DRect(x+i, y+i, width-(i*2), height-(i*2), true);
		}
	}
	
	public static void OSCompatibility(String appName){
		String osName = System.getProperty("os.name", "");
		String homeFolder = System.getProperty("user.home");
		if (osName.startsWith("Mac OS X")){
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("dock:name", appName);
			System.setProperty("com.apple.mrj.application.apple.menu.about.name",appName);
			// TODO Add new way to about windows on Mac.
			onMac = true;
		} else if (osName.startsWith("Window")){
			onWindows = true;
		} else {
			onOtherOS = true;
		}
	}
	
	public static Image readImageFromCodebase(String imageName){
		
		//Gets and creates image object.
		try {
			//Finds location of were the program is running and sets codeBase to it.
			String path = Utilis.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			//Creates image using decodePath.
			File img1 = new File(decodedPath+imageName);
			Image image = ImageIO.read(img1);
			//Put image in JLabel.
			return image;
		}catch (Exception e) {
			//Error message
			JOptionPane.showMessageDialog(null, "There was an error: \n"+e, "Error!", 1);
			return null;
		}
		
	}
	
}