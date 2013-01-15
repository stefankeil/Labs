public class ScrabbleCheater {

	HashMap hashMap;

	public ScrabbleCheater(String fileName) throws Exception {
		hashMap = Reader
				.readMapFromFile("/Users/stefankeil/Documents/Workspace/Labs/130115_LabExcercise13/TWL06.txt");
		hashMap.figures();
		String words[] = hashMap.getWordListOnPosition(16);
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
		}
	}

	public String[] getWords(String string) throws Exception {
		int hashInteger = Hashing.createHashcode(string);
		return hashMap.getWordListOnPosition(hashInteger);
	}

}
