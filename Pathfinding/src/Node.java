import java.util.ArrayList;

public class Node {

	private String name;
	private double latitude;
	private double longitude;
	private ArrayList<Node> neighbours;
	
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
	
	
	
}
