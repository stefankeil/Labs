public class Hashing {
	
	/*
	 * This method generates a hash value from a string
	 */
	public static int createHashcode(String string) throws Exception{
		
		int stringvalue = convertString(string);
		int result = (stringvalue%1427); 
	
		return result;
	}
	
	/*
	 * reads a String
	 * returns the int value for this string from asci table 
	 */
	public static int convertString(String string){
		String thisString = string.toLowerCase();
		int sum = 0;
		for (int i=0; i < thisString.length(); i++)
			sum += 601 * thisString.charAt(i);
		return sum;
	}
}


