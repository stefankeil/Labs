import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Read {

	static String file_name = "/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/121023_LabExercise3/test.txt";
	static String new_file = "/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/121023_LabExercise3/frequency.txt";
	static int[] chars = new int[128];

	public static void main(String[] args) throws IOException {
		Read.readFromAFile();
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
		while ((r = reader.read()) != -1) {
			if (chars[r - 1] == 0) {
				chars[r - 1] = 1;
			} else {
				chars[r - 1]++;
			}
		}
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0) {
				 if (i != 9){
				Read.writetoFile(i);
				 }
			}
		}
	}

	private static void writetoFile(int i) throws IOException {
		try {
			FileWriter fw = new FileWriter(new_file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\n");
			bw.write("'" + (char) (i + 1) + "'" + ": ");
			for (int stern = 0; stern < chars[i]; stern++) {
				bw.write("*");
				if (stern == chars[i]) {
				}
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
