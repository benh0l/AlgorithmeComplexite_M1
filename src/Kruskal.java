import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    public Graph graphe;

    public Kruskal(Graph g){
        this.graphe = kruskal(g);
    }

    public Graph kruskal(Graph g){
        Graph graphe = new Graph(g.vertices());
        ArrayList<Edge> aretes = g.edges();
        Collections.shuffle(aretes);

        for(int i = 0; i < aretes.size(); i++){
            if(verifierCycle(aretes.get(i), graphe.edges(), g.vertices()) == false){
                graphe.addEdge(aretes.get(i));
                aretes.get(i).used = true;
            }
        }

        return graphe;
    }

    public boolean verifierCycle(Edge arete, ArrayList<Edge> aretes, int nbSommet){
        int nb = 0;
        boolean sommetRelie[] = new boolean[nbSommet];
        boolean res = false;
        aretes.add(arete);

        for(Edge e : aretes){
            if(sommetRelie[e.from] == false){
                sommetRelie[e.from] = true;
                nb++;
            }
            if(sommetRelie[e.to] == false){
                sommetRelie[e.to] = true;
                nb++;
            }
        }

        if(aretes.size() >= nb){
            res = true;
        }
        return res;
    }

}
