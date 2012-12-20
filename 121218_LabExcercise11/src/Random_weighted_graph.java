
import java.util.ArrayList;
import java.util.Random;

public class Random_weighted_graph {
	
	private Random randomnumber = new Random();
	private int vertices;
	private int edges;
	
	
	
	Random_weighted_graph(int vertices, int edges){
		
		vertices = randomnumber.nextInt(26);
		edges = randomnumber.nextInt(52);
		
	}
		
	private ArrayList randomVertices(int numberOf){
		ArrayList<String> verticesList = new ArrayList<String>();
        for (int i=0; i<numberOf;i++){
        	int oneVertice = randomnumber.nextInt(200);
        	String temp= String.valueOf((char) oneVertice);
        	verticesList.add(temp);
        }
    return verticesList;

        }
	}

