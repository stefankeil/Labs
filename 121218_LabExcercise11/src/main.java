
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeightedGraphMatrixRandomHelper randomMatrixHelper = new WeightedGraphMatrixRandomHelper(20, 30);
		WeightedGraphMatrix matrix = randomMatrixHelper.genereateMatrix();
		System.out.println(matrix);
	}

}
