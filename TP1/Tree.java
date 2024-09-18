import java.util.ArrayList;

public class Tree<T> implements TreeI<T>{

    private T data;
    private ArrayList<Tree<T>> children;
    private Tree<T> parent;

    public Tree(){}

    @SafeVarargs
    public Tree(T data, Tree<T>... childs) {
        this.data = data;
        this.children = new ArrayList<Tree<T>>();
        for (Tree<T> child : childs){
            this.children.add(child);
        }
        this.parent = null;
    }

    public T data(){
        return this.data;
    }

    public Tree<T> child(int n) {
        try{
            return this.children().get(n);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    private ArrayList<Tree<T>> children(){
        return this.children;
    }

    public int nbChildren(){
        return this.children().size();
    }

    public Tree<T> parent(){
        return this.parent;
    }

    @SafeVarargs
    public final void addChildren(Tree<T>... childs) {
        for (Tree<T> child : childs){
            child.parent = this;
            this.children.add(child);
        }
    }

    /* Attention : la méthode suivante ne peut que modifier un enfant existant */
    public void setChild(int i, Tree<T> child) {
        this.children.set(i, child);
    }



     /* Adapted from VasiliNovikov@StackOverflow */

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.data());
        buffer.append('\n');
        for (int i = 0; i < nbChildren(); i++) {
            Tree<T> next = this.child(i);
            if (i < nbChildren() -1) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    public void display() {
        System.out.println(this.toString());
    }

    //(*) Profondeur d'un arbre
    public int depth(){
        int[] depths = new int[this.nbChildren()];

        for (int i = 0; i < this.nbChildren(); i++){
            if (this.child(i) != null){
                depths[i] = this.child(i).depth();
            }else{
                depths[i] = 0;
            }
        }

        int profMax = 0;
        for (int val : depths) {
            if (profMax < val){
                profMax = val;
            }
        }
        return profMax+1;
    }

    public int size(){
        int nbfils = 0;
        for (int i = 0; i < this.nbChildren(); i++){
            if(this.child(i) != null){
                nbfils += this.child(i).size();
            }
        }
        return nbfils +1;
    }

    public static void main(String[] args){

        Tree<Integer> a = new Tree<>(2, 
                                 new Tree<>(7,
                                     new Tree<>(2),
                                     new Tree<>(6,
                                        new Tree<>(5),
                                        new Tree<>(11)
                                        )
                                     ),
                                 new Tree<>(5,
                                    new Tree<>(9,
                                        new Tree<>(4)
                                    )
                                 )
                           );

        Tree<Integer> b = new Tree<>(3,
                           new Tree<>(8,
                               new Tree<>(1),
                               new Tree<>(9,
                                  new Tree<>(7),
                                  new Tree<>(12)
                               )
                           ),
                           new Tree<>(6,
                              new Tree<>(4,
                                  new Tree<>(2)
                              ),
                              new Tree<>(10)
                           )
                         );
        
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

        System.out.println(a.toString());
        System.out.println(a.size());
        System.out.println(a.size());
    }
}