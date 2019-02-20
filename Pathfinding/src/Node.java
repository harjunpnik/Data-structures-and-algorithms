import java.util.ArrayList;

public class Node {

	Functions functions = new Functions();
	private String name;
	private double latitude;
	private double longitude;
	private ArrayList<Node> neighbours;
	private Node previousNode;
	
	//	Constructor
	public Node(String name, double longitude, double latitude) {
		setName(name);
		setLatitude(latitude);
		setLongitude(longitude);
		neighbours = new ArrayList<Node>(); 
	}
	
	//	Name
	public String getName() {
		return name;
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	//	Latitude
	public double getLatitude() {
		return latitude;
	}
	
	private void setLatitude(double latitude){
		this.latitude = latitude;
	}
	
	//	Longitude
	public double getLongitude() {
		return longitude;
	}
	
	private void setLongitude(double longitude){
		this.longitude = longitude;
	}
	
	//	Neighbours
	public void addNeighbour(Node neighbour) {
		neighbours.add(neighbour);
	}
	
	
	public ArrayList<Node> getNeighbours() {
		return neighbours;
	}
	
	// Previous
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}
	
	
	public double calculateH(Node destination) {
		double hValue = functions.getDistance(longitude, latitude, destination.getLongitude(), destination.getLatitude());
		return hValue;
	}
	
	public double calculateG(Node startNode) {
		double g = 0;
		Node current = this;
		
		do{
			if(current == startNode) {
				//System.out.println("CURRENT = START");
				continue;
			}
			
			g += functions.getDistance(current.getLongitude(), current.getLatitude(), current.getPreviousNode().getLongitude(), current.getPreviousNode().getLatitude());
			//System.out.println(g);
			System.out.println("Current : " + current.getName() + " previous: " + current.getPreviousNode().getName());

			current = current.getPreviousNode();
			
		}while(current != startNode);
			
		return g;
	}
	
}
