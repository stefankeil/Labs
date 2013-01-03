import java.util.Random;

public class Matrix {

	String[] nameVertices;
	int numberOfEdges;
	int row;
	int col;
	int[] weightOfEdges;
	int[][] matrixArray;
	int i;

	public Matrix(int row, int edges, String[] nameVertices, int[] weight) {

		this.numberOfEdges = edges;
		this.nameVertices = nameVertices;
		this.weightOfEdges = weight;
		this.row = row;
		this.col = row;
		matrixArray = new int[row][row];

	}

	public void addVertices(String vertices) {
		nameVertices[i] = vertices;
		this.row = nameVertices.length;
		this.col = nameVertices.length;
		i++;
	}

	public void addWeight() {
		Random randomnumber = new Random();
		int rndRow = 0;
		int rndCol = 0;

		for (int z = 0; z < weightOfEdges.length; z++) {
			rndRow = randomnumber.nextInt(row);
			rndCol = randomnumber.nextInt(row);
			if (matrixArray[rndRow][rndCol] == 0) {
				matrixArray[rndRow][rndCol] = weightOfEdges[z];
			} else {
				z--;
			}

		}
	}
}
