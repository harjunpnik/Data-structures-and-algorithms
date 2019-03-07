import java.util.ArrayList;
import java.util.HashMap;

public class Pathfinding {

	public static void main(String[] args) {
		
		 Functions functions = new Functions();
		 
		 HashMap<String, Node> graph = functions.createLargeGraph();
		 
		 functions.showNodesAndLinks(graph);

		 //	Asks user for input and validates the input
		 System.out.print("Please enter a Start point: ");
		 String startNode = functions.getStringInput(graph);
		 System.out.print("Please enter a Destination point: ");
		 String destinationNode = functions.getStringInput(graph);
		 
		 System.out.println();
		 
		 //	A Star algorithm search
		 ArrayList<Node> shortestPath = functions.aStar(graph.get(startNode),graph.get(destinationNode));
		 
		 //	Prints out the shortest Path
		 System.out.println("SHORTEST PATH");
		 System.out.println("-------------");
		 int i = 1;
		 for(Node node: shortestPath ) {
			 System.out.println(i + ": " + node.getName());
			 i++;
		 }
	}
}
