import java.util.ArrayList;
import java.util.Random;

public class AldousBroder {

    public Graph graphe;

    public AldousBroder(Graph g){
        this.graphe = aldousBroder(g);
    }

    public Graph aldousBroder(Graph g){
        Graph graph = new Graph(g.vertices());
        Random random = new Random();
        boolean visite[] = new boolean[g.vertices()];
        ArrayList<Edge> voisin = new ArrayList<Edge>();
        Edge e;

        int sommet = random.nextInt(g.vertices());
        visite[sommet] = true;
        while(!tousVisite(visite)){
            voisin = g.adj(sommet);
            int alea = random.nextInt(voisin.size());
            int sommet2 = voisin.get(alea).other(sommet);
            if(visite[sommet2] == false){
                if(sommet < sommet2) {
                    e = new Edge(sommet, sommet2);
                    e.used = true;
                    graph.addEdge(e);
                }else {
                    e = new Edge(sommet2, sommet);
                    e.used = true;
                    graph.addEdge(e);
                }
                visite[sommet2] = true;
            }
            sommet = sommet2;
        }

        return graph;
    }

    public boolean tousVisite(boolean[] tab){
        for(int i = 0; i < tab.length; i++){
            if(tab[i] == false){
                return false;
            }
        }
        return true;
    }
}
