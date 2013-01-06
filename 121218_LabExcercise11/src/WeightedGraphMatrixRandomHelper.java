import java.util.Random;
import java.util.UUID;

public class WeightedGraphMatrixRandomHelper {

	private Random randomnumber = new Random();
	private int vertexAmount;
	private int edgeAmount;
	private WeightedGraphMatrix matrix;

	WeightedGraphMatrixRandomHelper(int vertexAmount, int edgeAmount) {
		this.vertexAmount = vertexAmount;
		this.edgeAmount = edgeAmount;
	}
	
	public WeightedGraphMatrix genereateMatrix() {
		matrix = new WeightedGraphMatrix(vertexAmount);
		addRandomVertices();
		addRandomWeight();
		return matrix;
	}

	private void addRandomVertices() {
		try {
			for (int i = 0; i < vertexAmount; i++) {
				String uuid = UUID.randomUUID().toString();
				matrix.addVertex(uuid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addRandomWeight() {
		String vertices[] = this.matrix.getVertices();
		try {
			for (int i = 0; i < edgeAmount; i++) {
				//////
				int randomNumberA = randomNumberInRange(0, vertexAmount - 1);
				int randomNumberB = 0;

				do {
					randomNumberB = randomNumberInRange(0, vertexAmount - 1);
				} while (randomNumberA == randomNumberB);

				String vertexA = vertices[randomNumberA];
				String vertexB = vertices[randomNumberB];
				//////
				
				int weight = randomNumberInRange(1, 100);
				if (matrix.getWeight(vertexA, vertexB) == 0) {
					matrix.setWeight(vertexA, vertexB, weight);					
				} else {
					i--;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int randomNumberInRange(int min, int max) {
		Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;
        return randomNumber;
	}

}
