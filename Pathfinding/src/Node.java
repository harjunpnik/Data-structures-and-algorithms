import java.util.ArrayList;

public class Node {

	Functions functions = new Functions();
	
	private String name;
	private double latitude;
	private double longitude;
	private ArrayList<Node> neighbours;
	private Node previousNode;
	private double gCost;
	private double hCost;
	private double fCost;

	
	//	CONSTRUCTOR
	public Node(String name, double longitude, double latitude) {
		setName(name);
		setLatitude(latitude);
		setLongitude(longitude);
		neighbours = new ArrayList<Node>(); 
	}
	
	
	//	GET METHODS
		//	Name
	public String getName() {
		return name;
	}
		//	Latitude
	public double getLatitude() {
		return latitude;
	}
		//	Longitude
	public double getLongitude() {
		return longitude;
	}
		// Previous Node
	public Node getPreviousNode() {
		return previousNode;
	}
		// F Cost
	public double getFCost() {
		return fCost;
	}
		//	G Cost
	public double getGCost() {
		return gCost;
	}
		// 	H Cost
	public double getHCost() {
		return hCost;
	}
	
	
	//	SET	METHODS
		//	Name
	private void setName(String name){
		this.name = name;
	}
		//	Latitude
	private void setLatitude(double latitude){
		this.latitude = latitude;
	}
		// Longitude
	private void setLongitude(double longitude){
		this.longitude = longitude;
	}
		// Previous Node
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
		//	F Cost
	public void setFCost(double fCost) {
		this.fCost = fCost;
	}
		//	G Cost
	public void setGCost(double gCost) {
		this.gCost = gCost;
	}
		// 	H Cost
	public void setHCost(double hCost) {
		this.hCost = hCost;
	}

	
	//	NEIGHBOUR METHODS
		//	Add Neighbour
	public void addNeighbour(Node neighbour) {
		neighbours.add(neighbour);
	}
		// Get Neighoubr ArrayList
	public ArrayList<Node> getNeighbours() {
		return neighbours;
	}
	
	
	//	A STAR ALGORITHM VALUE CALCULATION METHODS
		//	Calculates and returns the F Cost, which is the g + h ( Path cost to start node + heuristic estimate)
	public double calculateF() {
		double f = gCost + hCost;
		setFCost(f);
		return f;
	}
		//	Calculates and returns the H Cost, the heuristic cost to the Destination Node
	public double calculateH(Node destination) {
		//	Calculates the heuristic distance to the destination node from the (this) node
		double hValue = functions.getDistance(longitude, latitude, destination.getLongitude(), destination.getLatitude());
		return hValue;
	}
		//	Calculates and returns the G Cost, The cost to the previous 
	public double calculateG(Node previous) {
		Node current = this;
		//	Calculates the Distance to the previous node from the (this) Node
		double g = functions.getDistance(current.getLongitude(), current.getLatitude(), previous.getLongitude(), previous.getLatitude());
			
		return g;
	}
	
	
}
