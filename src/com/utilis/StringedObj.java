package com.utilis;

/**
 * This interface is used for saving and loading classes into Strings.  Classes that implement this interface should be able to load themselves from the Strings generated by the saveString() method.
 * @author Cin316
 *
 */
public interface StringedObj {
	
	/**
	 * Converts self to a String that can later be used by the createFromString(String) method to create itself again.
	 * @return String created from self.
	 */
	public String convertToString();
	/**
	 * Takes a String and uses it to create a new StringedObj.
	 * @param s String to create new StringedObj from.
	 * @return StringedObj created from the original String.
	 */
	public StringedObj createFromString(String s) throws InvalidStringedObjStringException;
	
	/**
	 * Exception to be thrown if StringedObj.createFromSring(String) receives and invalid String.
	 * @author Cin316
	 *
	 */
	public class InvalidStringedObjStringException extends Exception{
		
		/**
		 * Class constructor to throw exception.
		 */
		public InvalidStringedObjStringException(){
			super();
		}
		
		/**
		 * Returns custom exception message that includes the name of the class that implemented StringedObj.
		 * @return Custom message.
		 */
		public String getMessage(){
			String className = super.getStackTrace()[0].getClassName();
			return "Invalid StringedObj String given to class " + className + ".";
		}
		
	}
	
}
