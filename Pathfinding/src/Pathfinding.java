import java.util.HashMap;

public class Pathfinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Functions functions = new Functions();
		 
		 HashMap<String, Node> graph = functions.createGraph();
		 
		 functions.showNodesAndLinks(graph);
		 
		 System.out.print("Please enter a Start point: ");
		 String startNode = functions.getStringInput(graph);
		 System.out.print("Please enter a End point: ");
		 String endNode = functions.getStringInput(graph);
		 
		 System.out.println(startNode + " " + endNode);
		 
		 //System.out.println(functions.getDistance(graph.get(0).getLongitude(), graph.get(0).getLatitude(),graph.get(3).getLongitude(), graph.get(3).getLatitude()));
			 
		 //System.out.println(graph.get(0).calculateH(graph.get(1)));

		 
		 graph.get("Tampere").setPreviousNode(graph.get("Helsinki"));	//Sets previous manually for testing
		 graph.get("Jyväskylä").setPreviousNode(graph.get("Tampere"));	//Sets previous manually for testing
		 
		 
		 System.out.println(graph.get("Jyväskylä").calculateG(graph.get("Helsinki")));
	}

}
