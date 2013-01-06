import java.util.Random;

public class Matrix {

	String[] vertices;
	int size;
	int[][] matrixArray;
	int position;

	public Matrix(int size) {
		this.size = size;
		this.vertices = new String[size];
		this.matrixArray = new int[size][size];
	}

	public void addVertex(String vertex) throws Exception {
		if (position < size) {
			vertices[this.position] = vertex;
			this.position++;
		} else {
			throw new Exception("Matrix to small");
		}
		
	}

	public void addWeight(String vertexA, String vertexB, int weight) throws Exception {
		
		int indexVertexA = vertexIndex(vertexA);
		int indexVertexB = vertexIndex(vertexB);
		
		matrixArray[indexVertexA][indexVertexB] = weight;
	
		
		
		//		Random randomnumber = new Random();
//		int rndRow = 0;
//		int rndCol = 0;
//
//		for (int z = 0; z < weightOfEdges.length; z++) {
//			rndRow = randomnumber.nextInt(row);
//			rndCol = randomnumber.nextInt(row);
//			if (matrixArray[rndRow][rndCol] == 0) {
//				matrixArray[rndRow][rndCol] = weightOfEdges[z];
//			} else {
//				z--;
//			}
//
//		}
	}
	
	private int vertexIndex(String vertex) throws Exception {
		for (int i = 0; i < this.vertices.length; i++) {
			if (vertices[i].equals(vertex)) {
				return i;
			}
		} 
		throw new Exception("Unknown vertex " + vertex);
	}
	
	public String[] getVertices() {
		return vertices;
	}
}
