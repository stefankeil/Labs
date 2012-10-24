import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Read {

	static String file_name = "/Users/stefankeil/Documents/Workspace/Laps/121023_LabExercise3/test.txt";
	static int[] chars = new int[128];

	public static void main(String[] args) throws IOException {

		Read read = new Read();
		read.writetoFile();
		read.readFromAFile();
	}

	public static void readFromAFile() {
		try {
			FileReader fr = new FileReader(file_name);
			BufferedReader br = new BufferedReader(fr);
			handleCharacters(br);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void handleCharacters(Reader reader) throws IOException {
		int r;
		int i= 1;
		while ((r = reader.read()) != -1) {
			char ch = (char) r;		
			if (chars[r-1] == i){
				i ++;
				chars[r-1]=i;	
			}
			else{chars[r-1] = i;
			}
			if (ch != (char) 10) {
				System.out.println(ch);
			}
		}System.out.println((char) 101 +": "+ chars[100] +" times");
	}

	private static void writetoFile() throws IOException {
		try {
			FileWriter fw = new FileWriter(file_name, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("test");
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
