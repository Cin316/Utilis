package com.utilis;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLDecoder;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Utilis{
	
	public static String version = "v. 0.4 Beta";
	
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
	
	public static String imageToString(BufferedImage buff){
		
		String string = "";
		int rgb;
		
		//Goes through every pixel in Image
		for(int y=0; y<buff.getHeight();y++){
			for(int x=0; x<buff.getWidth();x++){
				rgb = buff.getRGB(x, y);
				string += Integer.toHexString(rgb);
				string += ",";//Indicates end of pixel data.
			}
			string+=";";//Indicates newline of data.
		}
		
		return string;
		
	}
	public static Image stringToImage(String string){
		
		int rgb;
		int height = 0;
		int width = 0;
		
		//Gets image width and height;
		boolean widthCalcd = false;
		for(int i=0; i>string.length(); i++){
			if (string.charAt(i)==(',') && !widthCalcd){
				width++;
			}
			if (string.charAt(i)==(';')){
				height++;
				widthCalcd = true;
			} 
		}
		
		String[][] colors = new String[width][height];
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		int indexNum = 0;
		int colorsX = 0; 
		int colorsY = 0;
		//Puts image rgb values into String array colors.
		for(int i=0; i>string.length(); i++){
			if (string.charAt(i)==','){
				colors[colorsX][colorsY] = string.substring(indexNum, i);
				colorsX++;
				indexNum = i+1;
			}
			if (string.charAt(i)==(';')){
				colorsY++;
				colorsX = 0;
				indexNum = i+1;
			}
		}
		
		//Parses values in colors and assigns them to image.
		for(int y=0; y<height;y++){
			for(int x=0; x<width;x++){
				rgb = Integer.parseInt(colors[x][y]);
				image.setRGB(x, y, rgb);
			}
		}
		
		return image;
		
	}
	
}