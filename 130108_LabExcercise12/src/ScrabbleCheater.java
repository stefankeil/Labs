public class ScrabbleCheater {
	
	HashMap hashMap;

	public ScrabbleCheater(String fileName) {
		hashMap = Reader.readMapFromFile("/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130108_LabExcercise12/TWL06.txt");
	}
	
	public String[] getWords(String string) throws Exception{
		int hashInteger = Hashing.createHashcode(string);
		return hashMap.getWordListOnPosition(hashInteger);
	}

}
