public class HashMap {

	String[][] scrabbleValues = new String[3000][5000];

	public void setWordInMap(int key, String word) {
		int position = 0;
		
		if (scrabbleValues[key][position] != null){
			String oldWord = scrabbleValues[key][position];
			char[] lettersOldWord = oldWord.toCharArray();
			char[] lettersWord = word.toCharArray();
			
			for (int i = 0; i < lettersOldWord.length; i++){
				int mark = -1;
				for (int j = 0; j < lettersWord.length; j++) {
					if (lettersOldWord[i] == lettersWord[j]){
						break;
					} else {
						mark++;
					}
				} if (mark == lettersWord.length){
					key++;
					setWordInMap(key, word);
					break;
				}
			}
		}
		
		while (scrabbleValues[key][position] != null) {
			position++;
		}
		scrabbleValues[key][position] = word;
	}

	public String[] getWordListOnPosition(int hashCode) throws Exception {
		int position = 0;
		
		while (scrabbleValues[hashCode][position] != null) {
			position++;
		}
		
		String[] wordArray = new String[position];
		
		for (int i = 0; i < position; i++){
			wordArray[i] = scrabbleValues[hashCode][i];
		}
		
		return wordArray;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < scrabbleValues.length; i ++) {
			for (int j = 0; j < scrabbleValues[i].length; j++) {
				sb.append(scrabbleValues[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
