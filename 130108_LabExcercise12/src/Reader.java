import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reader {
	private static String  file_name = "/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130108_LabExcercise12/TWL06.txt";;
	private static Hashing hasher = new Hashing();
	private static HashMap map = new HashMap();
	public static void readFromAFile()
	  {
	  try{
	  // Open the file that is the first 
	  FileInputStream fstream = new FileInputStream(file_name);
	  // Get the object of DataInputStream
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  //Read File Line By Line
	  while ((strLine = br.readLine()) != null)   {
	  // uses the hashcode of the word as index in the hashmap
		  int hashcode = hasher.createHashcode(strLine);
		  map.setWordInMap(hashcode,strLine);
		  
	  }
	  //Close the input stream
	  in.close();
	    }catch (Exception e){//Catch exception if any}
	    	System.out.println("test");
	    }
	  }
	}

