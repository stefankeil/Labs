
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hashing hash = new Hashing ();
		int test= hash.createHashcode("susi");
		System.out.println(test);
		Reader reader = new Reader();
		reader.readFromAFile();
		
	}

}
