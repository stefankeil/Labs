
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random_weighted_graph graph= new Random_weighted_graph(5,10);
		Matrix matrix = new Matrix(graph.getVertices(),graph.getEdges(),graph.getVerticesNames(),graph.getWeights());
		matrix.addWeight();
	}

}
