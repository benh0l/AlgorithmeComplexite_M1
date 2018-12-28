import java.util.ArrayList;
import java.util.Random;

public class Wilson {

    public Graph graphe;

    public Wilson(Graph g){
        this.graphe = wilson(g);
    }

    public Graph wilson(Graph g){
        Graph graph = new Graph(g.vertices());
        Random random = new Random();
        ArrayList<Integer> visite = new ArrayList<Integer>();
        ArrayList<Integer> nonVisite = new ArrayList<Integer>();
        int sommet = random.nextInt(g.vertices());
        //On place nos sommets dans les liste visité et nonVisité
        for(int i = 0; i < g.vertices(); i++){
            if(i == sommet)
                visite.add(sommet);
            else
                nonVisite.add(i);
        }

        //Début algo
        int sommetDepart = nonVisite.get( random.nextInt( nonVisite.size() ) );
        while(!nonVisite.isEmpty()){
            ArrayList<Integer> parcours = new ArrayList<>();
            //marche aléatoire
            while(!contientSommetVisite(parcours, visite)){
                ArrayList<Edge> voisin = g.adj(sommet);
                int alea = random.nextInt(voisin.size());
                int sommetAlea = voisin.get(alea).other(sommet);
                parcours.add(sommetAlea);
                sommet = sommetAlea;
            }

            supprimerCycle(parcours);
            for(int i = 0;i < parcours.size();i++){
                if(i>0){
                    if(parcours.get(i) < parcours.get(i-1))
                        graph.addEdge(new Edge(parcours.get(i),parcours.get(i-1)));
                    else
                        graph.addEdge(new Edge(parcours.get(i-1),parcours.get(i)));
                }
                visite.add(parcours.get(i));
                nonVisite.remove(parcours.get(i));
            }

        }

        return graph;
    }

    public boolean contientSommetVisite(ArrayList<Integer> liste, ArrayList<Integer> visite){

        for(int j = 0; j < visite.size(); j++){
            if(liste.contains(visite.get(j)))
                return true;
        }

        return false;
    }

    public ArrayList<Integer> supprimerCycle(ArrayList<Integer> liste){
        for(int i = 0;i < liste.size(); i++){
            for(int j = 0; j< liste.size(); j++){
                if(liste.get(i) == liste.get(j) && i != j){
                    while(i!=j){
                        liste.remove(liste.get(i));
                        j--;
                    }
                }
            }
        }
        return liste;
    }

}
