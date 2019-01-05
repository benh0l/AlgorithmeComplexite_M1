package Partie2;

public class Mastermind {


    public static int calculCombinaison(int k, int n, int b, int m){
        int nbCombinaison = 1;

        if(n == 0 || b == n){
            return 0;
        }else{
            if(n > b+m){
                nbCombinaison += (k-b-m)*calculCombinaison(k-b-m,n-1,b-1,m);
                nbCombinaison += (k-b-m)*calculCombinaison(k-b-m,n-1,b,m-1);
            }else{
                nbCombinaison += k*calculCombinaison(n-1,n-1,b-1,m);
                nbCombinaison += k*calculCombinaison(n-1,n-1,b,m-1);
            }

        }

        return nbCombinaison;
    }


    public static void main(String args[]){
        int res = Mastermind.calculCombinaison(4,4,2,2);
        System.out.println(res);
    }
}
