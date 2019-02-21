import java.util.HashMap;

public class Pathfinding {

	public static void main(String[] args) {
		
		 Functions functions = new Functions();
		 
		 HashMap<String, Node> graph = functions.createGraph();
		 
		 functions.showNodesAndLinks(graph);
		 
		 //System.out.println(graph.get("Lahtis").calculateH(graph.get("Kuopio")));	 
		 
		 System.out.print("Please enter a Start point: ");
		 String startNode = functions.getStringInput(graph);
		 System.out.print("Please enter a Destination point: ");
		 String destinationNode = functions.getStringInput(graph);
		 
		 //System.out.println(startNode + " " + destinationNode);
		 
		 //System.out.println(functions.getDistance(graph.get(0).getLongitude(), graph.get(0).getLatitude(),graph.get(3).getLongitude(), graph.get(3).getLatitude()));
			 
		 //System.out.println(graph.get(0).calculateH(graph.get(1)));

		 //graph.get("Tampere").setPreviousNode(graph.get("Helsinki"));	//Sets previous manually for testing
		 //graph.get("Jyväskylä").setPreviousNode(graph.get("Tampere"));	//Sets previous manually for testing
		 
		 //System.out.println(graph.get("Jyväskylä").calculateG(graph.get("Helsinki")));
		 
		 System.out.println();
		 
		 functions.aStar(graph.get(startNode),graph.get(destinationNode));
		
	}

}
