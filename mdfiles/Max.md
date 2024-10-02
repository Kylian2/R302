# Max d'un arbre

## Max d'un arbre binaire 

```Java
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
```

## Max d'un arbre général 

```Java
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
```