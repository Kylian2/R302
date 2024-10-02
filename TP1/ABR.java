public class ABR {
    public static boolean search(int key, BTree<Integer> ABR){
        if(ABR.data() == key){
            return true;
        }
        if (ABR.left() != null && key <= ABR.left().data()){
            return search(key, ABR.left());
        }else if(ABR.right() != null && key <= ABR.right().data()){
            return search(key, ABR.right());
        }
        return false;
    }

    public static void insert(int key, BTree<Integer> ABR){
        if(ABR.data() == null){
            ABR = new BTree<>(key);
        }

        //On compare la valeur à inserer avec la donnée du noeud actuel, si elles sont vides alors on peut inserer
        if(key <= ABR.data() && ABR.left() == null){
            ABR.setLeft(new BTree<>(key));
            return;
        }else if(key >= ABR.data() && ABR.right() == null){
            ABR.setRight(new BTree<>(key));
            return;
        }

        //Si les branches ne sont pas vide, alors on relance la fonction sur le sous-arbres
        if (ABR.left() != null && key <= ABR.data()){
            insert(key, ABR.left());
           return;
        }else if(ABR.right() != null && key >= ABR.data()){
            insert(key, ABR.right());
           return ;
        }
        return;
    }

    
    public static void insert2(int key, BTree<Integer> ABR){

        //Ne fonctionne pas, conditions ne fonctionnent pas dans le cas 1

        //Cette fonction fait exactement la même chose que celle du dessus mais avec un embriquement des conditions rendant plus lisible et compréhensible le code
        //On compare avec le noeud actuel, puis on verifie la disponibilité de la branche
        //Si la branche est vide, alors on la crée avec key
        //Sinon on relance sur le sous arbre

        if(ABR.data() == null){
            ABR = new BTree<>(key);
        }

        if(key <= ABR.data()){
            if(ABR.left() == null){
                ABR.setLeft(new BTree<>(key));
            }else{
                insert2(key, ABR.left());
            }
            return;
        }

        if(ABR.data() <= key){
            if(ABR.right() == null){
                ABR.setRight(new BTree<>(key));
            }else{
                insert2(key, ABR.right());
            }
            return;
        }
    }

    public static boolean isBST(BTree<Integer> btree){
        boolean isBST = true;

        if(btree == null){
            return false;
        }

        if(btree.left() != null){
            if(btree.data() >= btree.left().data()){
                isBST = isBST(btree.left());
            }else{
                return false;
            }
        }

        if(isBST && btree.right() != null){
            if(btree.data() <= btree.right().data()){
                isBST = isBST(btree.right());
            }else{
                return false;
            }
        }
        return isBST;
    }


    public static void main (String... args){
        BTree<Integer> ABR = new BTree<>(5,
                                    new BTree<>(3,
                                        new BTree<>(1),
                                        new BTree<>(4, new BTree<>(2))),
                                    new BTree<>(7,
                                        new BTree<>(6,
                                             null,
                                             new BTree<>(7)
                                                )
                                            )

                                    );

        int[] input = {0,2,5,8};
        boolean[] expects = {false, true, true, false};
        boolean allGood_Q1 = true;
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Q1 : Écrire une fonction search qui prend en entrée une clé (entier) et un ABR, " +
                "et qui teste si la clé apparait dans l'arbre.\n");

        for (int i=0; i<input.length; i++){

            if (search(input[i], ABR) == expects[i]){
                System.out.printf("PASS: on input %d, search returns %s \n", input[i], search(input[i], ABR));
            }
            
           else{
                System.out.printf("FAIL: on input %d, search returns %s instead of %s \n", input[i], search(input[i], ABR), expects[i]);
                allGood_Q1 = false;
            }
        }
        if (allGood_Q1){System.out.println("Q1 : All tests passed. Congratulations!");}


        boolean allGood_Q2 = true;
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Q2 : Adaptez votre code pour insérer une nouvelle clé dans l'ABR en respectant la règle.\n");

        String[] tree_expected = {new BTree<>(5,new BTree<>(3,new BTree<>(1),new BTree<>(4, new BTree<>(2), new BTree<>(4))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)))).toString(),
                new BTree<>(5,new BTree<>(3,new BTree<>(1),new BTree<>(4, new BTree<>(2), new BTree<>(4))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)), new BTree<>(9))).toString(),
                new BTree<>(5,new BTree<>(3,new BTree<>(1),new BTree<>(4, new BTree<>(2), new BTree<>(4))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)), new BTree<>(9, new BTree<>(8)))).toString(),
                new BTree<>(5,new BTree<>(3,new BTree<>(1),new BTree<>(4, new BTree<>(2), new BTree<>(4))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)), new BTree<>(9, new BTree<>(8, new BTree<>(8))))).toString()
        };

        int[] input_insert = {4,9,8,8};
        for (int i=0; i<input_insert.length; i++) {
            insert(input_insert[i], ABR);
            if (ABR.toString().equals(tree_expected[i])) {
                System.out.printf("PASS : on input %d, insert returns correct tree \n", input_insert[i]);
            }else{
                System.out.printf("FAIL: on input %d, not inserted correctly \n", input_insert[i]);
                allGood_Q2 = false;
            }

        }
        if (allGood_Q2){System.out.println("Q2 : All tests passed. Congratulations!");}

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Q3 : Ecrire une fonction isBST qui prend en entrée un arbre et vérifie s'il s'agit bien d'un ABR.\n");

        boolean allGood_Q3 = true;
        BTree[] input_isBST = {new BTree<>(5,new BTree<>(5),new BTree<>(7)),
                new BTree<>(5,new BTree<>(3,new BTree<>(1),new BTree<>(4, new BTree<>(2))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)))),
                new BTree<>(5,new BTree<>(8,new BTree<>(1),new BTree<>(4, new BTree<>(2))),new BTree<>(7,new BTree<>(6,null,new BTree<>(7)))), ABR};

        boolean[] expects_isBST = {true,true,false, true};
        for (int i=0; i<input_isBST.length; i++) {
            if(isBST(input_isBST[i]) == expects_isBST[i]){
                System.out.printf("PASS : on input %d \n",i);
            }else{
                System.out.printf("FAIL: on input %d , expected %s instead of %s\n",i,expects_isBST[i], isBST(input_isBST[i]));
                allGood_Q3 = false;
            }
        }
        if (allGood_Q3){System.out.println("Q3 : All tests passed. Congratulations! \n");}

        System.out.println("--------------------------------------------------------------------------------------");
        if(allGood_Q1 && allGood_Q2 && allGood_Q3){ System.out.println("Arbres binaires de recherche : All tests passed. Congratulations");}
        else{
            System.out.println("Arbres binaires de recherche : Not all tests passed, try again.");
        }

    } 
}


