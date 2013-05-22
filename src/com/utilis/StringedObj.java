package com.utilis;

/**
 * This interface is used for saving and loading classes into Strings.  Classes that implement this interface should be able to load themselves from the Strings generated by the saveString() method.
 * @author Cin316
 *
 */
public interface StringedObj {
	
	public String convertToString();
	public StringedObj createFromString(String s);
	
}
