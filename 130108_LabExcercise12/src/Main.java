
public class Main {

	static Hashing hash = new Hashing ();
	static ScrabbleCheater cheater;
	
	public static void main(String[] args) throws Exception {
		cheater = new ScrabbleCheater("/Users/Fee/Documents/Uni/HTW/Informatik2/Lab/130108_LabExcercise12/TWL06.txt");
				
		String word = "java";
		String words[] = cheater.getWords(word);
		
		
		for (int i = 0; i < words.length; i++){
			if (isPermutation(word, words[i])){
				System.out.println(words[i]);
			}
		}	
		
//		System.out.println(map);
	}
	
	 private static String sortByAlphabet(String s) {
         //sort them by alphabet
         char[] content = s.toCharArray();
         java.util.Arrays.sort(content);
         String sorted = new String(content);
         return sorted;
 }

	 private static boolean isPermutation(String a, String b){
         String sortedA = sortByAlphabet(a);
         String sortedB = sortByAlphabet(b);
         return (sortedA.compareTo(sortedB)==0);
 }


}
