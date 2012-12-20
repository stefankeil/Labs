
public class Matrix {
	
	String [] nameVertices;
	int numberOfEdges;
	int row = nameVertices.length;
	int collum = nameVertices.length;
	int [] weightOfEdges;
	int [] [] matrixArray;
	
	public Matrix(int row, int edges, String [] nameVertices, int [] weight) {
		this.row = row;
		this.collum = row;
		this.numberOfEdges = edges;
		this.nameVertices = nameVertices;
		this.weightOfEdges = weight;
	}
	
	public void addVertices(String vertices){
//		toDo: vertices add to nameVertices;
		this.row = nameVertices.length;
		this.collum = nameVertices.length;
	}
	
	public void addWeight(int weight){
		matrixArray[row][collum] = weight;
	}
}
