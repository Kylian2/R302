/* Comme cette fonction est générique (elle ne dépend pas du fait que les sommets contiennent des entiers), 
* on pourrait à la place la coder comme une méthode de la classe BTree<T>.
 * Dans ce cas, elle ne prendrait pas d'argument mais serait appelée par tree.depth().
 */

public class Depth{

    //implémenté comme méthodes de la classe BTree et Tree

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

        root.display();
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", root.depht(), 7);
        c.display();
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", c.depth(), 5);
    }
}