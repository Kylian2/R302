import java.util.Arrays;

public class List<T> extends BTree<T> implements ListI<T> {
    
    private T data;
    private List<T> tail;
    private List<T> parent;

    @SafeVarargs
    public List(T head, T... data) {
        this.data = head;
        if (data.length == 0){
            this.tail = null;
        }
        else{
            this.tail = new List<T>(data[0], Arrays.copyOfRange(data, 1, data.length));
            this.parent = null;
            this.tail.parent = this;
        }
    }

    public T data(){
        return this.data;
    }

    public List<T> tail(){
        return this.tail;
    }

    public int length(){
        if (this.tail() == null){return 1;}
        return 1+ this.tail().length();
    }

    public List<T> parent(){
        return this.parent;
    }

    public void setTail(List<T> l){
        this.tail = l;
    }

    public String toString(){
        if (this.tail == null){
            return this.data().toString();
        }
        else{
            return this.data().toString() + ";" + this.tail().toString();
        }
    }

    public void display(){
        System.out.println(this.toString());
    }
    /* Pour la compatibilité avec BTree<T> */

    public List<T> left(){
        return this.tail();
    }

    public List<T> right(){
        return null;
    }

    public void setLeft(List<T> child){
        setTail(child);
    }

    public List<T> child(int i){
        if (i == 0) return this.tail();
        else return null;
    }

    public int nbChildren(){
        if (this.tail() == null) return 0;
        else return 1;
    }

    @SafeVarargs
    public final void addChildren(List<T>... childs){
        if (childs.length == 0) System.out.print("bla");
        this.setTail(childs[0]);
    }

    public void setChild(int i, List<T> child){
        if (i==0) setTail(child);
        else throw new IndexOutOfBoundsException();
    }

    public boolean isSorted() throws Exception{

        boolean isSorted = true;
        if (this.tail() != null){
            isSorted = this.tail().isSorted();
        }
        if(isSorted){
            if (this.parent() != null){
                isSorted = (double) this.parent().data() < (double) this.data();
                //To see the comparison : System.out.println(this.parent().data() + " < " + this.data() + " = " + isSorted);
            }
            return isSorted;
        }else{
            return isSorted;
        }
    }

    public boolean isSorted3() throws Exception{

        boolean isSorted = true;
        if (this.tail() != null && (double) this.tail().data() > (double) this.data()){
            isSorted = this.tail().isSorted();
        }else{
            return false;
        }
        return isSorted;
    }

    public void insertAt(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.length()) {
            throw new IndexOutOfBoundsException("Index hors limites.");
        }

        if (index == 0) {
            // Insérer à la tête
            List<T> newTail = new List<>(this.data, this.tail() != null ? this.tail().data() : null);
            this.data = element;
            this.tail = newTail;
        } else if (index == 1 && this.tail == null) {
            // Insérer à la fin de la liste
            this.tail = new List<>(element);
        } else {
            // Insertion au milieu
            this.tail.insertAt(index - 1, element);
        }
    }

    public boolean isSorted2(){
        boolean isSorted = true;
        if(tail != null){
            if((double) data > (double) tail().data()) isSorted = false;
            else tail.isSorted2();
        }
        return isSorted;
    }

}