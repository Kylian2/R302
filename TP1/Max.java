import java.rmi.server.ExportException;

public class Max{

    public int max(Tree<Integer> tree) throws Exception{
        if(!(tree.data() instanceof Integer)){
            throw new Exception("Invalid type of data, data must be an integer");
        }
        //On initialise le max à la valeur du sommet courant
        int max = tree.data();

        //On relance max sur les enfants
        for (int i = 0; i < tree.nbChildren(); i++){
            int v = tree.child(i).max();
            //Si un enfant à un max supérieur on le garde
            if(v> max){
                max = v;
            }
        }
        
        return max;
    }

    public int max(BTree<Integer> btree) throws Exception{
        if(!(btree.data() instanceof Integer)){
            throw new Exception("Invalid type of data, data must be an integer");
        }
        //On initialise max sur le sommet courant
        int max = btree.data();

        //On relance sur les enfants et on garde si leur max est supérieur
        if(btree.left() != null){
            int l = btree.left().max();
            if(l > max){
                max = l;
            }
        }
        if(btree.right() != null){
            int r = btree.right().max();
            if(r > max){
                max = r;
            }
        }
        
        return max;
    }

    public static void main(String[] args){


        BTree<Integer> root = new BTree<>(0, new BTree<>(1,
                                                        new BTree<>(2, new BTree<>(3, new BTree<>(4))),
                                                        new BTree<>(2)),
                                                new BTree<>(1, new BTree<>(2,
                                                                        new BTree<>(3,
                                                                                new BTree<>(4,
                                                                                        new BTree<>(5 ,new BTree<>(6))),
                                                                                new BTree<>(4)),
                                                                        new BTree<>(3))));


        root.display();
		try{
			System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", root.max(), 6);
		}catch(Exception error){
			System.out.println(error);
		}

        BTree<Integer> treeneg = new BTree<>(-2, new BTree<>(-1,
                                                        new BTree<>(-1, new BTree<>(-3, new BTree<>(-12))),
                                                        new BTree<>(-2)),
                                                new BTree<>(-4, new BTree<>(-9,
                                                                        new BTree<>(-54,
                                                                                new BTree<>(-3,
                                                                                        new BTree<>(-5)),
                                                                                new BTree<>(-4))
                                                                        )
                                                )
        );


        treeneg.display();
		try{
			System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", treeneg.max(), -1);
		}catch(Exception error){
			System.out.println(error);
		}

		Tree<Integer> c = new Tree<>(10,
                            new Tree<>(15,
                                new Tree<>(6,
                                    new Tree<>(3,
                                        new Tree<>(1),
                                        new Tree<>(4)
                                    ),
                                    new Tree<>(8)
                                ),
                                new Tree<>(12,
                                    new Tree<>(7),
                                    new Tree<>(9,
                                        new Tree<>(5),
                                        new Tree<>(11)
                                    )
                                )
                            ),
                            new Tree<>(20,
                                new Tree<>(17,
                                    new Tree<>(14),
                                    new Tree<>(19)
                                ),
                                new Tree<>(25,
                                    new Tree<>(22),
                                    new Tree<>(30,
                                        new Tree<>(27),
                                        new Tree<>(35)
                                    )
                                )
                            )
        );
		c.display();
		try{
			System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", c.max(), 35);
		}catch(Exception error){
			System.out.println(error);
		}
    }
}