
public class ScrabbleCheater {
	Hashing hash = new Hashing ();
	HashMap hashMap = new HashMap();

	
	public String[] getWords(String string) throws Exception{
		int hashInteger = hash.createHashcode(string);
		String wordArray[] = hashMap.getWordListOnPosition(hashInteger);
		return wordArray;
	}
	

}
