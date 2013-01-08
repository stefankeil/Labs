import java.security.MessageDigest;




public class Hashing {
	
	/*
	 * This method generates a hash value from a string
	 */
	public int createHashcode(String string) throws Exception{
		
		int stringvalue = convertString(string);
		int result = stringvalue%1213; 
	
		return result;
	}
	/*
	 * reads a String
	 * returns the int value for this string from asci table 
	 */
	public int convertString(String string){
		String thisString = string.toLowerCase();
		char[] stringArray = new char[thisString.length()];
		int sum = 0;
		for (int i=0; i < thisString.length();i++)
			sum += thisString.charAt(i);
		return sum;
	}
}


