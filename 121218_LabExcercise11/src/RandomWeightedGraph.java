import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class RandomWeightedGraph {

	private Random randomnumber = new Random();
	private int vertexAmount;
	private int edgeAmount;
	private Matrix matrix;

	RandomWeightedGraph(int vertexAmount, int edgeAmount) {
		this.matrix = new Matrix(vertexAmount);
		this.vertexAmount = vertexAmount;
		this.edgeAmount = edgeAmount;
		addRandomVertices();
		addRandomWeight();
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
		
		int randomNumberA = randomNumberInRange(vertexAmount);
		int randomNumberB = 0;
		
		do {
			randomNumberB = randomNumberInRange(vertexAmount);
		} while (randomNumberA == randomNumberB);
		
		for (int i = 0; i < edgeAmount; i++) {
			int oneWeigth = randomnumber.nextInt(2000);
		}
	}
	
	private int randomNumberInRange(int maximum){
		return (int) (Math.random() * maximum);
	}

}
