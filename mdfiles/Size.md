# Taille d'un arbre

## Arbre binaire
On lance sur les fils et on ajoute 1 au compteur pour compter le sommet courant
```Java
public int size(){
    int nbfils = 0;
    if (this.left() != null){
        nbfils += this.left().size();
    } 
    if (this.right() != null){
        nbfils += this.right().size();
    } 
    return nbfils+1;
}
```

## Arbre générale
On lance sur les fils et on ajoute 1 au compteur pour compter le sommet courant
```Java
public int size(){
    int nbfils = 0;
    for (int i = 0; i < this.nbChildren(); i++){
        if(this.child(i) != null){
            nbfils += this.child(i).size();
        }
    }
    return nbfils +1;
}
```