public class SquareSum {
    
    /* Le programme suivant doit renvoyer le nombre de carrés.
     * Vous pourrez ensuite l'améliorer pour afficher la liste des carrés choisis.
     */

    public static int nbCarresGlouton (int soldats){
        int nbCarres = 0;
        
        double n = Math.sqrt(soldats);
        double carre = Math.floor(n);
        if (carre > 0){ nbCarres++;}
        else {return nbCarres;}
        nbCarres += nbCarresGlouton((int) (soldats-Math.pow(carre, 2)));
        return nbCarres;
    }

    public static int nbCarresBruteForce (int soldats){

        int count = soldats;
        for (int i = 1; i*i <= soldats ; i++ ){
            int n = nbCarresBruteForce(soldats - i*i);
            if( n+1 < count){
                count = n+1;
            }
        }
        return count;
    }

    public static void main(String... args){

        System.out.println("TEST FONCTION GLOUTON -------- ");
        int input[] = {21, 27, 33, 18, 0, 1, 5};
        int expect[] = {3, 3, 3, 3, 0, 1, 2};
        boolean allGood = true;
        for (int i = 0; i < input.length ; i++){
            int answer = nbCarresGlouton(input[i]);
            if(answer == expect[i]){
                System.out.printf("Test passed for input %d \n", input[i]);
            }else{
                System.out.printf("Test failed for input %d, %d was expected but it return %d\n", i, expect[i], answer);
                allGood = false;
            }
        }    
        if (allGood){
            System.out.printf("All test passed for Glouton ! \n");
        }

        System.out.println("TEST FONCTION BRUTE FORCE -------- ");

        int input_2[] = {4, 3, 18, 27, 29};
        int expect_2[] = {1, 3, 2, 3, 2};
        for (int i = 0; i < input_2.length ; i++){
            int answer = nbCarresBruteForce(input_2[i]);
            if(answer == expect_2[i]){
                System.out.printf("Test passed for input %d \n", input_2[i]);
            }else{
                System.out.printf("Test failed for input %d, %d was expected but it return %d\n", input_2[i], expect_2[i], answer);
                allGood = false;
            }
        }    
        if (allGood){
            System.out.printf("All test passed for Brute Force ! \n");
        }
    }

}
