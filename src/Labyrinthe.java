public class Labyrinthe {

    public Graph graphe;

    public Labyrinthe(String algo, int taille){
        this.graphe = genererLabyrinthe(algo,taille);
    }

    public Graph genererLabyrinthe(String algo, int taille){
        Graph g = Graph.Grid(taille);
        Graph res = null;
        switch(algo){
            case "Aldous-Broder":
                AldousBroder ab = new AldousBroder(g);
                res = ab.graphe;
                break;
            default:
                Kruskal k = new Kruskal(g);
                res = k.graphe;
                break;
        }
        return res;
    }

}
