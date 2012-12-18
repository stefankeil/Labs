
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
	
	public void fillMatrix(int [] weightOfEdges){
		int count = 0;
		for (int i = 0; i < this.row; i++){
			for (int j = 0; j < this.collum; j++){
				this.matrixArray[i][j]=weightOfEdges[count];
				count++;
			}
		}
	}
}
