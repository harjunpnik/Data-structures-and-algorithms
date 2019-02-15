import java.util.ArrayList;

public class Functions {

    public ArrayList<Node> createGraph()
    {
        //Skapar en nod f�r varje t�gstation
        Node hki = new Node("Helsingfors", 60.1640504, 24.7600896);    
        Node tpe = new Node("Tammerfors", 61.6277369, 23.5501169);     
        Node tku = new Node("Abo", 60.4327477, 22.0853171);            
        Node jyv = new Node("Jyv�skyl�", 62.1373432, 25.0954598);      
        Node kpo = new Node("Kuopio", 62.9950487, 26.556762);          
        Node lhi = new Node("Lahtis", 60.9948736, 25.5747703);         
             
        //F�rbindelser fr�n Helsingfors t�gstation
        hki.addNeighbour(tpe); //Tammerfors
        hki.addNeighbour(tku); //�bo
        hki.addNeighbour(lhi); //Lahtis
       
        //F�rbindelser fr�n Tammerfors t�gstation
        tpe.addNeighbour(hki); //Helsingfors
        tpe.addNeighbour(tku); //�bo
        tpe.addNeighbour(jyv); //Jyv�skyl�
        tpe.addNeighbour(lhi); //Lahtis
        
        //F�rbindelser fr�n �bo t�gstation
        tku.addNeighbour(hki); //Helsingfors
        tku.addNeighbour(tpe); //Tammerfors
         
        //F�rbindelser fr�n Jyv�skyl� t�gstation
        jyv.addNeighbour(tpe); //Tammerfors
        
        //F�rbindelser fr�n Kuopio t�gstation
        kpo.addNeighbour(lhi); //Lahtis
        
        //F�rbindelser fr�n Lahtis t�gstation
        lhi.addNeighbour(hki); //Helsingors
        lhi.addNeighbour(tpe); //Tammerfors
        lhi.addNeighbour(kpo); //Kuopio
                
        //Skapar en lista f�r grafen och s�tter in alla noder
        ArrayList<Node> graph = new ArrayList();
        graph.add(hki);
        graph.add(tpe);
        graph.add(tku);
        graph.add(jyv);
        graph.add(kpo);
        graph.add(lhi);
        
        return graph;
    }
	
}
