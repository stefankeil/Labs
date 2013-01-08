
public class Main {

	static Hashing hash = new Hashing ();
	static ScrabbleCheater cheater;
	static HashMap map;
	
	public static void main(String[] args) throws Exception {
		cheater = new ScrabbleCheater("/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130108_LabExcercise12/TWL06.txt");
				
		String words[] = cheater.getWords("JAVA");
		for (int i = 0; i < words.length; i++){
			System.out.println(words[i]);
		}		
	}

}
