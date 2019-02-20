import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Functions {

	Scanner scanner = new Scanner(System.in);
	
	//	TODO CHANGE TO HASHMAP 
    public ArrayList<Node> createLargeGraph()
    {
        //	Creates a node for each train station
        Node hki = new Node("Helsinki", 60.1640504, 24.7600896);    
        Node tpe = new Node("Tampere", 61.6277369, 23.5501169);     
        Node tku = new Node("Turku", 60.4327477, 22.0853171);
        Node kpo = new Node("Kuopio", 62.9950487, 26.556762);
        Node jyv = new Node("Jyv�skyl�", 62.1373432, 25.0954598);      
        Node oul = new Node("Oulu", 65.0121, 25.4651);
        Node vsa = new Node("Vaasa", 63.0951, 21.6165);
        Node krj = new Node("Karjaa", 60.0714, 23.6619);
        Node sjk = new Node("Seinajoki", 62.7877, 22.8504);
        Node kaj = new Node("Kajaani", 64.2222, 27.7278);
        Node joe = new Node("Joensuu", 62.6010, 29.7636);
        Node prk = new Node("Parikkala", 61.5502, 29.5024);
        Node yli = new Node("Ylivieska", 61.5502, 29.5024);
        Node por = new Node("Pori", 61.4851, 21.7974);
        Node nrm = new Node("Nurmes", 63.5419, 29.1396);
        Node kvl = new Node("Kouvola", 60.8679, 26.7042);
        

             
        //	HELSINKI
        hki.addNeighbour(kvl); //Kouvola
        hki.addNeighbour(jyv); //Jyv�skyl�
        hki.addNeighbour(tpe); //Tampere
        hki.addNeighbour(krj); //Karjaa
        
       
        //	TAMPERE
        tpe.addNeighbour(hki); //Helsinki
        tpe.addNeighbour(tku); //Turku
        tpe.addNeighbour(jyv); //Jyv�skyl�
        tpe.addNeighbour(por); //Pori
        tpe.addNeighbour(sjk); //Seinajoki
        
        //	TURKU
        tku.addNeighbour(krj); //Karjaa
        tku.addNeighbour(tpe); //Tampere
        tku.addNeighbour(por); //Pori
         
        //	KUOPIO
        kpo.addNeighbour(jyv); //Jyv�skyl�
        kpo.addNeighbour(joe); //Joensuu
        kpo.addNeighbour(kaj); //Kajaani
        kpo.addNeighbour(yli); //Ylivieska
        
        //	JYV�SKYL�
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
        sjk.addNeighbour(jyv); //Jyv�skyl�
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
        prk.addNeighbour(jyv); //Jyv�skyl�
        prk.addNeighbour(kvl); //Kouvola
        
        // YLIVIESKA
        yli.addNeighbour(oul); //Oulu
        yli.addNeighbour(kaj); //Kajaani
        yli.addNeighbour(kpo); //Kuopio
        yli.addNeighbour(jyv); //Jyv�skyl�
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
        kvl.addNeighbour(jyv); //Jyv�skyl�
        kvl.addNeighbour(hki); //Helsinki
        
        //	Creates a list for the graph and adds all the nodes
        ArrayList<Node> graph = new ArrayList<Node>();
        graph.add(hki);
        graph.add(tpe);
        graph.add(tku);
        graph.add(kpo);
        graph.add(jyv);
        graph.add(oul);
        graph.add(vsa);
        graph.add(krj);
        graph.add(sjk);
        graph.add(kaj);
        graph.add(joe);
        graph.add(prk);
        graph.add(yli);
        graph.add(por);
        graph.add(nrm);
        graph.add(kvl);
        
        return graph;
    }

	//	Creates the initial linked list
    
    public HashMap<String, Node> createGraph()
    {
        //	Creates a node for each train station
        Node hki = new Node("Helsinki", 60.1640504, 24.7600896);    
        Node tpe = new Node("Tampere", 61.6277369, 23.5501169);     
        Node tku = new Node("Turku", 60.4327477, 22.0853171);            
        Node jyv = new Node("Jyv�skyl�", 62.1373432, 25.0954598);      
        Node kpo = new Node("Kuopio", 62.9950487, 26.556762);          
        Node lhi = new Node("Lahtis", 60.9948736, 25.5747703);         
             
        //	Train routes from Helsinki
        hki.addNeighbour(tpe); //Tampere
        hki.addNeighbour(tku); //Turku
        hki.addNeighbour(lhi); //Lahtis
       
        //	Train routes from Tampere
        tpe.addNeighbour(hki); //Helsinki
        tpe.addNeighbour(tku); //Turku
        tpe.addNeighbour(jyv); //Jyv�skyl�
        tpe.addNeighbour(lhi); //Lahtis
        
        //	Train routes from Turku
        tku.addNeighbour(hki); //Helsinki
        tku.addNeighbour(tpe); //Tampere
         
        //	Train routes from Jyv�skyl�
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
    
    //	Shows the name of the node an all the train routes
    public void showNodesAndLinks(HashMap<String, Node> graph) {
    	
    	for(Node node: graph.values()){
    		System.out.println(node.getName());
    		ArrayList<Node> tempArray = node.getNeighbours();
    		
    		for(Node neighbour: tempArray){
    			System.out.println("    " + neighbour.getName());
    		}
    		System.out.println();
		 }
    	
    }
	
    //	Calculates the distance from two coordinates and returns a value in km
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

    //	Checks if the input is valid and returns a String of the input
    public String getStringInput(HashMap<String, Node> graph) {
    	
    	boolean loopIsActive = true;
    	String input;
    	
    	do {
    		input = scanner.nextLine();
	    	if(graph.containsKey(input)) {
	    		loopIsActive = false;
	    	}else {
	    		System.out.println("\n" + "Please enter a valid city name. Ex. Helsinki, Jyv�skyl�");
	    	}
    	}while(loopIsActive);
    	return input;
    }
}
