import java.util.Random;

public class Main {

	static Hashing hash = new Hashing();
	static ScrabbleCheater cheater;
	static final String AB = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) throws Exception {
		cheater = new ScrabbleCheater(
				"/Users/stefankeil/Documents/Workspace/Labs/130115_LabExcercise13/TWL06.txt");

		String word = generateRandomString(7);
		String words[] = cheater.getWords(word);

		for (int i = 0; i < words.length; i++) {
			if (isPermutation(word, words[i])) {
				System.out.println(words[i]);
			} 
		}
	}

	private static String sortByAlphabet(String s) {
		// sort them by alphabet
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		String sorted = new String(content);
		return sorted;
	}

	private static boolean isPermutation(String a, String b) {
		String sortedA = sortByAlphabet(a);
//		System.out.println(a);
		String sortedB = sortByAlphabet(b);
//		System.out.println(b);
		return (sortedA.compareTo(sortedB) == 0);
	}
	
	
	private static String generateRandomString(int len){
	
	Random rnd = new Random();

	StringBuilder sb = new StringBuilder( len );
	for( int i = 0; i < len; i++ ) 
		sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	return sb.toString();
	}

}
