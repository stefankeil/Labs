import java.util.Map;


public class HashMap {

	int indexKey;
	String scrabbleValue[][];
	int position = 0;
	
	
	
	public HashMap() {
		indexKey = 0;
	}
	
	public void setWordInMap(int key, String word) {
		while (scrabbleValue[key][position] != null) {
			position++;
		}
		scrabbleValue[key][position] = word;
	}
	
	public String[] getWordListOnPosition(int position) throws Exception {
		int size = 0;
		String wordArray[] = null;
		
		while (scrabbleValue[position][size] != null) {
			size++;
		}
		
		for (int i = 0; i < size; i++){
			 wordArray[i] = scrabbleValue[position][i];
		}
		
		throw new Exception("There is no word on this position");
	}
}
