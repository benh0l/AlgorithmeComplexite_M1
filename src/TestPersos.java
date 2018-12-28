import java.util.ArrayList;
import java.util.Comparator;

public class TestPersos {

    public static void main(String args[]){

        //TEST QUESTION 2
        Kruskal k = new Kruskal(Graph.example());

        System.out.println("QUESTION 2 : Les arêtes restantes sont :");
        for(int i = 0; i < k.graphe.edges().size(); i++){
            System.out.println(k.graphe.edges().get(i).from+"  "+k.graphe.edges().get(i).to);
        }


        //TEST QUESTION 3
        int arbre[] = new int[8];
        for(int j = 0;j < arbre.length; j++){
            arbre[j] = 0;
        }
        for(int i = 0; i < 1000000; i++){
            k = new Kruskal(Graph.example());
            ArrayList<Edge> aretes = k.graphe.edges();
            //Tri afin d'organiser les aretes dans un certain ordre et simplifier le comptage des arbres ensuite
            aretes.sort(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    if(o1.from == o2.from){
                        return o1.to - o2.to;
                    }else{
                        return o1.from - o2.from;
                    }
                }
            });

            //On vérifie de quel arbre il s'agit
            if(aretes.get(0).from == 0 && aretes.get(0).to == 1 && aretes.get(1).from == 0 && aretes.get(1).to == 3 && aretes.get(2).from == 1 && aretes.get(2).to == 2){
                arbre[0]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 1 && aretes.get(1).from == 0 && aretes.get(1).to == 2 && aretes.get(2).from == 0 && aretes.get(2).to == 3){
                arbre[1]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 1 && aretes.get(1).from == 1 && aretes.get(1).to == 2 && aretes.get(2).from == 1 && aretes.get(2).to == 3){
                arbre[2]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 2 && aretes.get(1).from == 0 && aretes.get(1).to == 3 && aretes.get(2).from == 1 && aretes.get(2).to == 3){
                arbre[3]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 3 && aretes.get(1).from == 1 && aretes.get(1).to == 2 && aretes.get(2).from == 1 && aretes.get(2).to == 3) {
                arbre[4]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 2 && aretes.get(1).from == 1 && aretes.get(1).to == 2 && aretes.get(2).from == 1 && aretes.get(2).to == 3) {
                arbre[5]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 2 && aretes.get(1).from == 0 && aretes.get(1).to == 3 && aretes.get(2).from == 1 && aretes.get(2).to == 2) {
                arbre[6]++;
            }else if(aretes.get(0).from == 0 && aretes.get(0).to == 1 && aretes.get(1).from == 0 && aretes.get(1).to == 2 && aretes.get(2).from == 1 && aretes.get(2).to == 3) {
                arbre[7]++;
            }

        }
        //On écrit les résulats
        int total = 0;
        System.out.println("\n\n\nQUESTION 3 : \n Résultat :");
        for(int ii = 0; ii < arbre.length;ii++) {
            System.out.println("Arbre "+ (ii+1)+" : "+arbre[ii]+" / 1 000 000");
            total += arbre[ii];
        }
        System.out.println(total);

    }

}
