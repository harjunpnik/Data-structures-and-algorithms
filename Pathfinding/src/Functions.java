import java.util.ArrayList;

public class Functions {

	//	Creates the initial linked list
    public ArrayList<Node> createGraph()
    {
        //	Creates a node for each train station
        Node hki = new Node("Helsingfors", 60.1640504, 24.7600896);    
        Node tpe = new Node("Tammerfors", 61.6277369, 23.5501169);     
        Node tku = new Node("Abo", 60.4327477, 22.0853171);            
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
        ArrayList<Node> graph = new ArrayList<Node>();
        graph.add(hki);
        graph.add(tpe);
        graph.add(tku);
        graph.add(jyv);
        graph.add(kpo);
        graph.add(lhi);
        
        return graph;
    }
    
    //	Shows the name of the node an all the train routes
    public void showNodesAndLinks( ArrayList<Node> graph) {
    	
    	for(Node node: graph){
    		System.out.println(node.getName());
    		ArrayList<Node> tempArray = node.getNeighbours();
    		
    		for(Node neighbour: tempArray){
    			System.out.println("    " + neighbour.getName());
    		}
    		System.out.println();
		 }
    	
    }
	
}
