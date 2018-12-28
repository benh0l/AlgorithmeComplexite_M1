public class TestPersos {

    public static void main(String args[]){

        //TEST QUESTION 2
        Kruskal k = new Kruskal(Graph.example());

        System.out.println("QUESTION 2 : Les arêtes restantes sont :");
        for(int i = 0; i < k.graphe.edges().size(); i++){
            System.out.println(k.graphe.edges().get(i).from+"  "+k.graphe.edges().get(i).to);
        }

    }

}
