# Calcul de profondeur d'un arbre

## Arbre binaire 

```Java
public int depht(){
    int dephtD = 0;
    int dephtG = 0;
    //On calcul la profondeur de chaque coté
    if(this.left() != null){
        dephtG = this.left().depht();
    }
    if (this.right() != null){
        dephtD = this.right().depht();
    }
    //On on garde que la plus grande et on ajoute 1 (pour compte le sommet actuel)
    if (dephtD > dephtG){
        return dephtD+1;
    }else{
        return dephtG+1;
    }
}
```

## Arbre général

```Java
public int depth(){
    int max = 0;
    //On verifie la profondeur pou chaque enfant
    for (int i = 0; i < this.nbChildren(); i++){
        int v = this.child(i).depth();
        //Si la nouvelle profondeur est plus élévé on la garde
        if(v > max){
            max = v;
        }
    }
    return max+1;
}
```
