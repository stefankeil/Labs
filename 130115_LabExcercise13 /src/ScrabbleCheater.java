public class ScrabbleCheater {

	HashMap hashMap;

	public ScrabbleCheater(String fileName) throws Exception {
		hashMap = Reader.readMapFromFile(fileName);
		hashMap.figures();
	}

	public String[] getWords(String string) throws Exception {
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

	public boolean isPermutation(String a, String b) {
		String sortedA = sortByAlphabet(a);
		String sortedB = sortByAlphabet(b);
		return (sortedA.compareTo(sortedB) == 0);
	}

	public static void permute(String beginningString, String endingString) {
		//Base Case
		if (endingString.length() <= 1) {
			System.out.println(beginningString + endingString);
		} else {
			for (int i = 0; i < endingString.length(); i++) {
				try {
					//newString will be the new endingString
					//Substring make a substring from 0 to i and from i + 1
					String newString = endingString.substring(0, i) + endingString.substring(i + 1);
					permute(beginningString + endingString.charAt(i), newString);
					
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

}
