import java.util.ArrayList;

public class Pathfinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Functions functions = new Functions();
		 
		 ArrayList<Node> graph = functions.createGraph();
		 
		 functions.showNodesAndLinks(graph);
		 
		 System.out.println(functions.getDistance(graph.get(0).getLongitude(), graph.get(0).getLatitude(),graph.get(3).getLongitude(), graph.get(3).getLatitude()));
			 
		 System.out.println(graph.get(0).calculateH(graph.get(3)));
	}

}
