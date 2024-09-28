/* Comme cette fonction est générique (elle ne dépend pas du fait que les sommets contiennent des entiers), 
* on pourrait à la place la coder comme une méthode de la classe BTree<T>.
 * Dans ce cas, elle ne prendrait pas d'argument mais serait appelée par tree.size.
 */

public class Size{

    //implémenté comme méthodes de la classe BTree et Tree

    public static void main(String[] args){


        BTree<String> root = new BTree<>("a", new BTree<>("a",
                                                        new BTree<>("a", new BTree<>("c", new BTree<>("a"))),
                                                        new BTree<>("d")),
                                                new BTree<>("a", new BTree<>("a",
                                                                        new BTree<>("b",
                                                                                new BTree<>("a",
                                                                                        new BTree<>("ad" ,new BTree<>("e"))),
                                                                                new BTree<>("a")),
                                                                        new BTree<>("a"))));

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
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", root.size(), 14);

        c.display();
        System.out.printf("Votre fonction renvoie %d, résultat attendu %d\n", c.size(), 21);

    }
}