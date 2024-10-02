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
        int max = 0;

        for (int i = 0; i < this.nbChildren(); i++){
            int v = this.child(i).depth();
            if(v > max){
                max = v;
            }
        }
        return max+1;
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

    public int max() throws Exception{
        if(!(this.data() instanceof Integer)){
            throw new Exception("Invalid type of data, data must be an integer");
        }
        int max = (int) this.data();

        for (int i = 0; i < this.nbChildren(); i++){
            int v = this.child(i).max();
            if(v> max){
                max = v;
            }
        }
        
        return max;
    }
}