import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Functions {

	Scanner scanner = new Scanner(System.in);
	
	//	CREATES THE INITIAL LINKED LIST, LARGER VERSION
    public HashMap<String, Node> createLargeGraph()
    {
        //	Creates a node for each train station
        Node hki = new Node("Helsinki", 60.16985, 24.93837);    
        Node tpe = new Node("Tampere", 61.49775, 23.76095);     
        Node tku = new Node("Turku", 60.45181, 22.26663);
        Node kpo = new Node("Kuopio", 62.89796, 27.67817);
        Node jyv = new Node("Jyväskylä", 62.2426, 25.74725);      
        Node oul = new Node("Oulu", 65.01208, 25.46507);
        Node vsa = new Node("Vaasa", 63.09508, 21.61645);
        Node krj = new Node("Karjaa", 60.07139, 23.66191);
        Node sjk = new Node("Seinäjoki", 62.78773, 22.85043);
        Node kaj = new Node("Kajaani", 64.22217, 27.72784);
        Node joe = new Node("Joensuu", 62.60101, 29.76357);
        Node prk = new Node("Parikkala", 61.55018, 29.5024);
        Node yli = new Node("Ylivieska", 64.07234, 24.53358);
        Node por = new Node("Pori", 61.48513, 21.79741);
        Node nrm = new Node("Nurmes", 63.54188, 29.13956);
        Node kvl = new Node("Kouvola", 60.86788, 26.70416);
        
             
        //	HELSINKI
        hki.addNeighbour(kvl); //Kouvola
        hki.addNeighbour(jyv); //Jyväskylä
        hki.addNeighbour(tpe); //Tampere
        hki.addNeighbour(krj); //Karjaa
       
        //	TAMPERE
        tpe.addNeighbour(hki); //Helsinki
        tpe.addNeighbour(tku); //Turku
        tpe.addNeighbour(jyv); //Jyväskylä
        tpe.addNeighbour(por); //Pori
        tpe.addNeighbour(sjk); //Seinajoki
        
        //	TURKU
        tku.addNeighbour(krj); //Karjaa
        tku.addNeighbour(tpe); //Tampere
        tku.addNeighbour(por); //Pori
         
        //	KUOPIO
        kpo.addNeighbour(jyv); //Jyväskylä
        kpo.addNeighbour(joe); //Joensuu
        kpo.addNeighbour(kaj); //Kajaani
        kpo.addNeighbour(yli); //Ylivieska
        
        //	JYVÄSKYLÄ
        jyv.addNeighbour(yli); //Ylivieska
        jyv.addNeighbour(sjk); //Seinajoki
        jyv.addNeighbour(tpe); //Tampere
        jyv.addNeighbour(hki); //Helsinki
        jyv.addNeighbour(kvl); //Kouvola
        jyv.addNeighbour(prk); //Parikkala
        jyv.addNeighbour(kpo); //Kuopio
        
        //	OULU
        oul.addNeighbour(yli); //Ylivieska
        oul.addNeighbour(kaj); //Kajaani
        
        //	VAASA
        vsa.addNeighbour(yli); //Ylivieska
        vsa.addNeighbour(por); //Pori
        vsa.addNeighbour(sjk); //Seinajoki
        
        //	KARJAA
        krj.addNeighbour(hki); //Helsinki
        krj.addNeighbour(tku); //Turku
        
        // SEINAJOKI
        sjk.addNeighbour(vsa); //Vaasa
        sjk.addNeighbour(jyv); //Jyväskylä
        sjk.addNeighbour(tpe); //Tampere
        
        // KAJAANI
        kaj.addNeighbour(oul); //Oulu
        kaj.addNeighbour(nrm); //Nurmes
        kaj.addNeighbour(kpo); //Kuopio
        kaj.addNeighbour(yli); //Ylivieska
        
        // JOENSUU
        joe.addNeighbour(nrm); //Nurmes
        joe.addNeighbour(kpo); //Kuopio
        joe.addNeighbour(prk); //Parikkala
        
        // PARIKKALA
        prk.addNeighbour(joe); //Joensuu
        prk.addNeighbour(jyv); //Jyväskylä
        prk.addNeighbour(kvl); //Kouvola
        
        // YLIVIESKA
        yli.addNeighbour(oul); //Oulu
        yli.addNeighbour(kaj); //Kajaani
        yli.addNeighbour(kpo); //Kuopio
        yli.addNeighbour(jyv); //Jyväskylä
        yli.addNeighbour(vsa); //Vaasa
        
        // PORI
        por.addNeighbour(vsa); //Vaasa
        por.addNeighbour(tku); //Turku
        por.addNeighbour(tpe); //Tampere

        // NURMES
        nrm.addNeighbour(kaj); //Kajaani
        nrm.addNeighbour(joe); //Joensuu
        
        // KOUVOLA
        kvl.addNeighbour(prk); //Parikkala
        kvl.addNeighbour(jyv); //Jyväskylä
        kvl.addNeighbour(hki); //Helsinki
        
        //	Creates a list for the graph and adds all the nodes
        HashMap<String, Node> graph = new HashMap<String, Node>();
        graph.put(hki.getName(), hki);
        graph.put(tpe.getName(), tpe);
        graph.put(tku.getName(), tku);
        graph.put(jyv.getName(), jyv);
        graph.put(kpo.getName(), kpo);
        graph.put(oul.getName(), oul);
        graph.put(vsa.getName(), vsa);
        graph.put(krj.getName(), krj);
        graph.put(sjk.getName(), sjk);
        graph.put(kaj.getName(), kaj);
        graph.put(joe.getName(), joe);
        graph.put(prk.getName(), prk);
        graph.put(yli.getName(), yli);
        graph.put(por.getName(), por);
        graph.put(nrm.getName(), nrm);
        graph.put(kvl.getName(), kvl);
        
        return graph;
    }

    //	CREATES THE INITIAL LINKED LIST, SMALLER VERSION
    
    public HashMap<String, Node> createGraph()
    {
        //	Creates a node for each train station
        Node hki = new Node("Helsinki", 60.1640504, 24.7600896);    
        Node tpe = new Node("Tampere", 61.6277369, 23.5501169);     
        Node tku = new Node("Turku", 60.4327477, 22.0853171);            
        Node jyv = new Node("Jyväskylä", 62.1373432, 25.0954598);      
        Node kpo = new Node("Kuopio", 62.9950487, 26.556762);          
        Node lhi = new Node("Lahtis", 60.9948736, 25.5747703);         
             
        //	Train routes from Helsinki
        hki.addNeighbour(tpe); //Tampere
        hki.addNeighbour(tku); //Turku
        hki.addNeighbour(lhi); //Lahtis
       
        //	Train routes from Tampere
        tpe.addNeighbour(hki); //Helsinki
        tpe.addNeighbour(tku); //Turku
        tpe.addNeighbour(jyv); //Jyväskylä
        tpe.addNeighbour(lhi); //Lahtis
        
        //	Train routes from Turku
        tku.addNeighbour(hki); //Helsinki
        tku.addNeighbour(tpe); //Tampere
         
        //	Train routes from Jyväskylä
        jyv.addNeighbour(tpe); //Tampere
        
        //	Train routes from Kuopio
        kpo.addNeighbour(lhi); //Lahtis
        
        //	Train routes from Lahtis
        lhi.addNeighbour(hki); //Helsinki
        lhi.addNeighbour(tpe); //Tampere
        lhi.addNeighbour(kpo); //Kuopio
        
        //	Creates a list for the graph and adds all the nodes
        HashMap<String, Node> graph = new HashMap<String, Node>();
        graph.put(hki.getName(), hki);
        graph.put(tpe.getName(), tpe);
        graph.put(tku.getName(), tku);
        graph.put(jyv.getName(), jyv);
        graph.put(kpo.getName(), kpo);
        graph.put(lhi.getName(), lhi);
        
        return graph;
    }
    
    //	SHOWS THE NAME OF ALL THE NODEs AND ALL THE TRAIN ROUTES FROM THAT NODE
    public void showNodesAndLinks(HashMap<String, Node> graph) {
    	
    	System.out.println("ALL THE TRAIN STATIONS AND DIRECT ROADS TO OTHER TRAIN STATIONS" );
    	System.out.println("---------------------------------------------------------------" );
    	System.out.println();
    	
    	for(Node node: graph.values()){
    		System.out.println(node.getName());
    		ArrayList<Node> tempArray = node.getNeighbours();
    		
    		for(Node neighbour: tempArray){
    			System.out.println("    " + neighbour.getName());
    		}
    		System.out.println();
		 }
    	
    	System.out.println("---------------------------------------------------------------" );
    	System.out.println();
    }
	
    //	CALCULATES THE DISTANCE FROM TWO COORDINATES AND RETURNS A VALUE IN KM
    public double getDistance(double lon1, double lat1, double lon2, double lat2)
    {
        lon1 = lon1*Math.PI/180.0;
        lat1 = lat1*Math.PI/180.0;
        lon2 = lon2*Math.PI/180.0;
        lat2 = lat2*Math.PI/180.0;
      
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double km = 6367 * c; // Earths radius in KM times metres

        return km;
    }

    //	CHECKS IF THE INPUT IS VALID AND RETURNS A STRING OF THE INPUT
    public String getStringInput(HashMap<String, Node> graph) {
    	
    	boolean loopIsActive = true;
    	String input;
    	
    	//	Loops until user enters a String that matches a city
    	do {
    		input = scanner.nextLine();
	    	if(graph.containsKey(input)) {
	    		loopIsActive = false;
	    	}else {
	    		System.out.println("\n" + "Please enter a valid city name. Ex. Helsinki, Jyväskylä");
	    	}
    	}while(loopIsActive);
    	return input;
    }
    
	//	A STAR SEARCH ALGORITHM, RETURNS ARRAYLIST<NODE> WITH SHORTEST PATH    
	public ArrayList<Node> aStar(Node startNode, Node destinationNode) {
			
			//Creates a arraylist for the shortest path
			ArrayList<Node> shortestPath = new ArrayList<Node>();
		
			// Creates an open and closed list
			HashMap<String, Node> open = new HashMap<String, Node>();
			HashMap<String, Node> closed = new HashMap<String, Node>();
			
			// Sets current node to starting node and puts it in the open list
			Node current = startNode;
			open.put(current.getName(), current);
			
			//	Calculates the initial values for the staring node
			current.calculateH(destinationNode);
			current.calculateG(startNode); //Should be 0
			current.calculateF();
			
			//	While open nodes list is not empty we search for a path
			while(!open.isEmpty()) {
				
				//	Sets the current node to the one with the lowest score
				current = lowestScore(open);
				
				//	If the current node is the Destination we exit the loop
				if(current == destinationNode) {
					
					do {
						shortestPath.add(0,current);
						current = current.getPreviousNode();
					}while(current != null);
					
						
					break;
				}
				
				//	Removes the current node from the open list and sets it to the closed node list so that it won't be evaluated again 
				open.remove(current.getName());
				closed.put(current.getName(), current);
				
				//	Creates an array for the neighbours of the current node
				ArrayList<Node> neighbours = current.getNeighbours();
				
				//	For each neighbour we calculate its F Cost
				for(Node neighbour: neighbours) {
					
					// Ignores a node that already has been evaluated
					if(closed.containsKey(neighbour.getName())) { 
						continue;
					}
					
					//	Calculates the distance from the start to the node
					double tentativeGCost = neighbour.calculateG(current) + current.getGCost();
					
					//	If node is not in the open list, add it, else if tentative G cost is higher than previous G cost, it does not save the new data
					if(!open.containsKey(neighbour.getName())) {
						open.put(neighbour.getName(), neighbour);
					}else if(tentativeGCost >= neighbour.getGCost()) {
						continue;
					}
					
					//	Sets the previous node
					neighbour.setPreviousNode(current);
					
					//	Sets the values of the node 
					neighbour.setGCost(tentativeGCost);
					double hCost = neighbour.calculateH(destinationNode);
					neighbour.setHCost(hCost);
					neighbour.calculateF();
				}
			}
			return shortestPath;
			
		}
	
		//	CALCULATES THE NEXT NODE TO BE USED AND RETURNS IT
		public Node lowestScore(HashMap<String, Node> open) {
			// Creates comparison values
			double lowestScore = Double.POSITIVE_INFINITY;
			Node lowestNode = new Node(null, 0, 0);
			//	For each node in the open set it searches for the one with the lowest F Cost
			for (Node node : open.values()) {
				//	Compares the F Cost
				if(node.getFCost() < lowestScore) {
				   lowestNode = node;
				   lowestScore = lowestNode.getFCost();
				}
			}
			return lowestNode;
		}
}
