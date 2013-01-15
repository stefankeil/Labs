import java.util.Random;

public class Main {

	static Hashing hash = new Hashing();
	static ScrabbleCheater cheater;
	static final String AB = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws Exception {
		cheater = new ScrabbleCheater(
				"/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130115_LabExcercise13/TWL06.txt");

		String word = generateRandomString(7);
		String words[] = cheater.getWords(word);

		cheater.permute("", word);
	}

	private static String generateRandomString(int len) {

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();

	}
}
