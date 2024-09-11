# Note de TP

## (*) Profondeur d'un arbre
### Arbre Binaire
La profondeur d'un arbre est sa plus longue branche
On parcours l'arbre et : 
- On verifie que les branches de chaques coté existent, si la branche existe on rappel la fonction à partir de la profondeur + 1 (puisqu'on vient de descendre dans l'arborescence). Si elle n'existe pas, on ne modifie pas la valeur de profondeur. 
- On retourne la plus grande valeur.
(On commence à -1 pour que la fonction renvoie 0 quand il n'y a pas d'arrête) 
Solution : 
```Java
        public int profondeur(){
        int profondeurD = -1;
        int profondeurG = -1;
        if(this.left() != null){
            profondeurG = this.left().profondeur();
        }
        if (this.right() != null){
            profondeurD = this.right().profondeur();
        }
        if (profondeurD > profondeurG){
            return profondeurD+1;
        }else{
            return profondeurG+1;
        }
    }
```

### Fonction généralisée 

Pour généraliser la fonction, j'utilise un tableau qui va contenir la profondeur de chaque enfant (avec autant de cases de qu'enfants). 
Ensuite je parcours touts les enfants un par un (for), je vérifie qu'il ne soit pas nul et je rappel la methode profondeur. Pour finir on renvoie la plus grande valeur contenu dans le tableau.

Solution : 
````java
public int profondeur(){
        int[] profondeurs = new int[this.nbChildren()];

        for (int i = 0; i < this.nbChildren(); i++){
            if (this.child(i) != null){
                profondeurs[i] = this.child(i).profondeur();
            }else{
                profondeurs[i] = -1;
            }
        }

        int profMax = -1;
        for (int val : profondeurs) {
            if (profMax < val){
                profMax = val;
            }
        }
        return profMax+1;
    }
````

## (*) Nombre de sommets

### Pour un arbre binaire
```java
    public int nbSommet(){
        int nbfils = 0;
        if (this.left() != null){
            nbfils += this.left().nbSommet();
        } 
        if (this.right() != null){
            nbfils += this.right().nbSommet();
        } 
        return nbfils+1;
    }
````
### Fonction généralisée

```java
    public int nbSommet(){
        int nbfils = 0;
        for (int i = 0; i < this.nbChildren(); i++){
            if(this.child(i) != null){
                nbfils += this.child(i).nbSommet();
            }
        }
        return nbfils +1;
    }
````