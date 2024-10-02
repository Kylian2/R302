/**
 * Ex1
 */
public class Ex1 {

    public static int nbElement(BTree<String> btree, String element){
        int count = 0;

        if(btree.data().compareTo(element) == 0){
            count++;
        }

        if(btree.left() !=  null){
            count += nbElement(btree.left(), element);
        }

        if(btree.right() !=  null){
            count += nbElement(btree.right(), element);
        }

        return count;
    }

    public static int nbDescendant(BTree<String> btree, String e1, String e2){
        int count = 0;
        if (btree.left() != null){
            if(btree.data().compareTo(e1) == 0 && btree.left().data().compareTo(e2) == 0){
                count ++;
            }
            count += nbDescendant(btree.left(), e1, e2);
        }
        if (btree.right() != null){
            if(btree.data().compareTo(e1) == 0 && btree.right().data().compareTo(e2) == 0){
                count ++;
            }
            count += nbDescendant(btree.right(), e1, e2);
        }

        return count;
    }

    public static void main(String... args){
        BTree<String> DOM = new BTree<>("html", new BTree<>("head"),
                                            new BTree<>("body", new BTree<>("div", new BTree<>("div")), new BTree<>("div")));

        BTree<String> DOM2 = new BTree<>("html", 
        new BTree<>("head", null, null), 
        new BTree<>("body",
            new BTree<>("div", null, null),
            new BTree<>("div", null, null)
        ) 
        );

        DOM2.display();
        String element = "div";
        System.out.println("Il y a " + nbElement(DOM2, element) + " " + element);

        String e1 = "body";
        String e2 = "div";
        System.out.println("Il y a " + nbDescendant(DOM2, e1, e2) + " " + e1+">"+e2);
    }
}