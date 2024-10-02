# Travail sur les listes

## Est-ce qu'une liste est triée ? 

```Java
public static boolean isSorted(List<Double> list){

    boolean isSorted = true;
    //Si la valeur suivante n'est pas nulle et que la valeur suivante est plus grande, on relance 
    if (list.tail() != null && (double) list.tail().data() >= (double) list.data()){
        isSorted = list.tail().isSorted();
    }else{
        return false;
    }
    return isSorted;
}
```

## Inserer un élément dans la liste triée

```Java
public static List<Double> addInOrder(List<Double> list, Double in){
    List<Double> x = new List<> (in);
    //Si la prochaine valeur est supérieur alors on insère au début de la liste
    if (list.data() > in){
        x.setTail(list);
        return x;
    }else{ //Sinon on relance à partir de la prochaine valeur et on remplace la suite avec le morceau trié
        list.setTail(addInOrder(list.tail(), in));
        return list;
    }
}
```