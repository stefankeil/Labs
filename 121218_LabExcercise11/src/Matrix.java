
public class Matrix {
	
	String [] nameVertices;
	int numberOfEdges;
	int row = nameVertices.length;
	int collum = nameVertices.length;
	int [] weightOfEdges;
	int [] [] matrixArray;
	int i;
	
	public Matrix(int row, int edges, String [] nameVertices, int [] weight) {
		this.row = row;
		this.collum = row;
		this.numberOfEdges = edges;
		this.nameVertices = nameVertices;
		this.weightOfEdges = weight;
	}
	
	public void addVertices(String vertices){
		nameVertices [i] = vertices;
		this.row = nameVertices.length;
		this.collum = nameVertices.length;
		i++;
	}
	
	public void addWeight(int weight){
		matrixArray[row][collum] = weight;
	}
}
