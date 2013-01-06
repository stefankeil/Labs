public class WeightedGraphMatrix {

	int size;
	String[] vertices;
	int[][] matrixArray;
	int currentPosition;

	public WeightedGraphMatrix(int size) {
		this.size = size;
		vertices = new String[size];
		matrixArray = new int[size][size];
	}

	public void addVertex(String vertex) throws Exception {
		if (currentPosition < size) {
			vertices[currentPosition] = vertex;
			currentPosition++;
		} else {
			throw new Exception("Matrix to small");
		}
		
	}

	public void setWeight(String vertexA, String vertexB, int weight) throws Exception {
		int indexVertexA = vertexIndex(vertexA);
		int indexVertexB = vertexIndex(vertexB);
		
		matrixArray[indexVertexA][indexVertexB] = weight;
	}
	
	public int getWeight(String vertexA, String vertexB) throws Exception {
		int indexVertexA = vertexIndex(vertexA);
		int indexVertexB = vertexIndex(vertexB);
		
		return matrixArray[indexVertexA][indexVertexB];		
	}
	
	private int vertexIndex(String vertex) throws Exception {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].equals(vertex)) {
				return i;
			}
		} 
		throw new Exception("Unknown vertex " + vertex);
	}
	
	public String[] getVertices() {
		return vertices;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int edges = 0;
		for (int i = 0; i < size; i++) {
			sb.append(vertices[i]).append(": ");
			for (int j = 0; j < size; j++) {
				int weight = matrixArray[i][j];
				sb.append(weight).append(" ");
				if (weight > 0) {
					edges++;
				}
			}
			sb.append("\n");
		}
		sb.insert(0, "Matrix with " + size + " vertices and " + edges + " edges.\n");
		return sb.toString();
	}
}
