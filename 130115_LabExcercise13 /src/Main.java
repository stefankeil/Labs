import java.util.Iterator;
import java.util.Random;

public class Main {

	static Hashing hash = new Hashing();
	static ScrabbleCheater cheater;
	static final String AB = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws Exception {
		cheater = new ScrabbleCheater("/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130108_LabExcercise12/TWL06.txt");

		String word = generateRandomString(6);
		ScrabbleCheater.permute("", "FLOWERS");
		
		Iterator it = ScrabbleCheater.permutationen.iterator();
		
		while (it.hasNext()){
			String element = (String) it.next();
			String words[] = ScrabbleCheater.getWords(element);
//			System.out.println("Set Word: " + element);
			for (int i = 0; i < words.length; i++){
				if (element.toLowerCase().equals(words[i])){
					System.out.println(element);
				}
			}
		}
		
	}

	private static String generateRandomString(int len) {

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();

	}
}
