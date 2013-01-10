public class HashMap {

	String[][] scrabbleValues = new String[1427][700];

	public void setWordInMap(int key, String word) {
		int position = 0;
		
//		if (scrabbleValues[key][position] != null) {
//			String oldWord = scrabbleValues[key][position];
//			char[] lettersOldWord = oldWord.toCharArray();
//			char[] lettersWord = word.toCharArray();
//			
//			for (int i = 0; i < lettersOldWord.length; i++) {
//				int mark = 0;
//				for (int j = 0; j < lettersWord.length; j++) {
//					if (lettersOldWord[i] == lettersWord[j]){
//						break;
//					} else {
//						mark++;
//					}
//				} if (mark == lettersWord.length){
//					key++;
//					setWordInMap(key, word);
//					break;
//				}
//			}
//		}
		
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
	
	public void figures() {
		int nullArray = 0;
		int bigCollision = 0;
		for(int i = 0; i < scrabbleValues.length; i ++) {
			int collision = 0;
			for (int j = 0; j < scrabbleValues[i].length; j++) {
				if(scrabbleValues[i][j] != null){
					collision++;
				} else {
					break;
				}
			}
//			System.out.println("index" + i + " Collision: " + collision);
			if (bigCollision < collision){
				bigCollision = collision;
			}
			if (collision == 0){
				nullArray++;
			}
		}
//		System.out.println("Keine Belegung: " + nullArray);
//		System.out.println("Grš§te Kollision: " + bigCollision);
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
