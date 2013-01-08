import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Reader {

	public static HashMap readMapFromFile(String fileName) {
		HashMap map = new HashMap();
		try {
			// Open the file that is the first
			FileInputStream fstream = new FileInputStream(fileName);
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// uses the hashcode of the word as index in the hashmap
				int hashcode = Hashing.createHashcode(strLine);
				map.setWordInMap(hashcode, strLine);
			}
			
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any}
			e.printStackTrace();
		}
		return map;
	}
}
