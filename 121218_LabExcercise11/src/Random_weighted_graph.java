import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Random_weighted_graph {

	private Random randomnumber = new Random();
	private int vertices;
	private int edges;
	private String[] verticesNames;
	private int[] weights;

	Random_weighted_graph(int vertices, int edges) {

		this.vertices = vertices;
		this.edges = edges;
		randomVerticesNames(vertices);
		randomWeight(edges);

	}

	private String[] randomVerticesNames(int numberOf) {

		String[] verticesNames = new String[numberOf];
		for (int i = 0; i < numberOf; i++) {

			String uuid = UUID.randomUUID().toString();

			verticesNames[i] = uuid;

		}
		this.verticesNames = verticesNames;
		return verticesNames;
	}

	private int[] randomWeight(int edges) {
		int[] weights = new int[edges];
		for (int i = 0; i < weights.length; i++) {
			int oneWeigth = randomnumber.nextInt(2000);
			weights[i] = oneWeigth;

		}
		this.weights = weights;
		return weights;

	}

	public String[] getVerticesNames() {
		return verticesNames;
	}

	public void setVerticesNames(String[] verticesNames) {
		this.verticesNames = verticesNames;
	}

	public int[] getWeights() {
		return weights;
	}

	public void setWeights(int[] weights) {
		this.weights = weights;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public int getEdges() {
		return edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

}
