import java.util.HashSet;
import java.util.Set;

public class ScrabbleCheater {

	static HashMap hashMap;
	public static Set<String> permutationen = new HashSet<String>();

	public ScrabbleCheater(String fileName) throws Exception {
		hashMap = Reader.readMapFromFile(fileName);
		hashMap.figures();
	}

	public static String[] getWords(String string) throws Exception {
		int hashInteger = Hashing.createHashcode(string);
		return hashMap.getWordListOnPosition(hashInteger);
	}

	public static String sortByAlphabet(String s) {
		// sort them by alphabet
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		String sorted = new String(content);
		return sorted;
	}

	public static boolean isPermutation(String a, String b) {
		String sortedA = sortByAlphabet(a).toLowerCase();
		String sortedB = sortByAlphabet(b).toLowerCase();
		return (sortedA.compareTo(sortedB) == 0);
	}

	public static void permute(String beginningString, String endingString)
			throws Exception {

		// Base Case
		if (endingString.length() <= 1) {
			
			permutationen.add(beginningString + endingString);
			
			if (beginningString.length() > 1) {
				permute("", beginningString);
			}
		} else {
			for (int i = 0; i < endingString.length(); i++) {
				try {
					// newString will be the new endingString
					// Substring make a substring from 0 to i and from i + 1
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);
					permute(beginningString + endingString.charAt(i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
