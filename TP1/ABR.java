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

    public static void insertVersionPlusJolie(int key, BTree<Integer> ABR){

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
                insert(key, ABR.left());
            }
        }

        if(ABR.data() <= key){
            if(ABR.right() == null){
                ABR.setRight(new BTree<>(key));
            }else{
                insert(key, ABR.right());
            }
        }

        return;
    }


    public static void main (String... args){
        BTree<Integer> ABR = new BTree<>(5,
                                    new BTree<>(3,
                                        new BTree<>(1),
                                        new BTree<>(3, new BTree<>(2), null)  // Ajout d'un `null` ici pour spécifier le fils droit manquant
                                    ),
                                    new BTree<>(7, 
                                        new BTree<>(6,
                                            null, 
                                            new BTree<>(7)
                                        )
                                    )
                                );


        int[] input = {0,2,5,8};
        boolean[] expects = {false, true, true, false};
        boolean allGood = true;
        ABR.display();
        for (int i=0; i<input.length; i++){
            if (search(input[i], ABR) == expects[i]){
                System.out.printf("PASS: on input %d, search returns %s \n", i, search(input[i], ABR));
            }
            else{
                System.out.printf("FAIL: on input %d, search returns %s instead of %s \n", i, search(input[i], ABR), expects[i]);
                allGood = false;
            }
        }
        if (allGood){System.out.println("All tests passed. Congratulations!");}

        BTree<Integer> ABR2 = new BTree<>(5,
                                    new BTree<>(3,
                                        new BTree<>(1),
                                        new BTree<>(3, new BTree<>(4), null)  // Ajout d'un `null` ici pour spécifier le fils droit manquant
                                    ),
                                    new BTree<>(7, 
                                        new BTree<>(6,
                                            null, 
                                            new BTree<>(7)
                                        )
                                    )
                                );

        ABR2.display();
        insertVersionPlusJolie(2, ABR2);
        ABR2.display();

        insertVersionPlusJolie(12, ABR2);
        ABR2.display();

        insertVersionPlusJolie(0, ABR2);
        ABR2.display();

        insertVersionPlusJolie(4, ABR2);
        ABR2.display();

        insertVersionPlusJolie(6, ABR2);
        ABR2.display();

        insertVersionPlusJolie(9, ABR2);
        ABR2.display();
    } 
}


