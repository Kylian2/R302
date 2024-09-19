public class SpeedTest {

    public static void main(String[] args) {
        int n = 1000; // Nombre d'éléments dans la liste pour le test de performance
        
        // Création dynamique de la liste avec une boucle (éléments triés)
        List<Double> l6 = new List<>(1.0); // Initialisation de la liste avec un premier élément
        for (int i = 2; i <= n; i++) {
            l6.insertAt(l6.length(), (double) i); // Insertion des éléments à la fin de la liste
        }
        
        // Ajouter un élément non trié à la fin pour tester le cas non trié
        l6.insertAt(l6.length(), -20.0);  // Ajoute l'élément -20.0 à la fin de la liste
        
        // Affichage de la liste si nécessaire (peut être désactivé pour de grandes listes)
        // l6.display();

        try {
            // Test de vitesse : mesure du temps d'exécution de la fonction isSorted()
            long startTime; // Début du chronométrage
            boolean isSorted;   // Appel de la fonction isSorted()
            long endTime;    // Fin du chronométrage
            long executionTime;

            startTime = System.nanoTime();  // Début du chronométrage
            isSorted = l6.isSorted2();    // Appel de la fonction isSorted()
            endTime = System.nanoTime();

            // Calcul du temps d'exécution
            executionTime = endTime - startTime;

            // Résultats du test
            System.out.printf("La réponse attendue est true, votre programme répond %b\n", isSorted);
            System.out.printf("Temps d'exécution de la fonction isSorted3() avec %d éléments: %d nanosecondes\n", n, executionTime);

            startTime = System.nanoTime();  // Début du chronométrage
            isSorted = l6.isSorted();    // Appel de la fonction isSorted()
            endTime = System.nanoTime();    // Fin du chronométrage

            // Calcul du temps d'exécution
            executionTime = endTime - startTime;

            // Résultats du test
            System.out.printf("La réponse attendue est true, votre programme répond %b\n", isSorted);
            System.out.printf("Temps d'exécution de la fonction isSorted2() avec %d éléments: %d nanosecondes\n", n, executionTime);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
