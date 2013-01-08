
public class Main {

	static Hashing hash = new Hashing ();
	static Reader reader = new Reader();
	static ScrabbleCheater cheater = new ScrabbleCheater();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//int test= hash.createHashcode("susi");
		//System.out.println(test);
		reader.readFromAFile();
		String words[] = cheater.getWords("JAVA");
		for (int i=0; i < words.length; i++){
			System.out.println(words[i]);
		}
		
	}

}
