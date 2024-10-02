public class Sort {

    //implémenté comme méthode de la classe List
    public static boolean isSorted(List<Double> list) throws Exception{

        boolean isSorted = true;
        //Si la valeur suivante n'est pas nulle et que la valeur suivante est plus grande, on relance 
        if (list.tail() != null && (double) list.tail().data() >= (double) list.data()){
            isSorted = list.tail().isSorted();
        }else{
            return false;
        }
        return isSorted;
    }

    public static List<Double> addInOrder(List<Double> list, Double in){
        List<Double> x = new List<> (in);
        if (list.data() > in){
            x.setTail(list);
            return x;
        }else{
            list.setTail(addInOrder(list.tail(), in));
            return list;
        }
    }

    public static void main(String... args){
        List<Double> l = new List<>(0.0,20.3, -6.3);
        l.display();
        try {
            System.out.printf("La réponse est false, votre programme répond %b\n", l.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        List<Double> l2 = new List<>(-6.3,20.0,20.3);
        l2.display();
        try {
            System.out.printf("La réponse est true, votre programme répond %b\n", l2.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Double> l3 = new List<>(1.0,2.0,3.0,4.0,5.0,6.0);
        l3.display();
        try {
            System.out.printf("La réponse est true, votre programme répond %b\n", l3.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Double> l4 = new List<>(1.0,2.0,35.0,4.0,5.0,6.0);
        l4.display();
        try {
            System.out.printf("La réponse est false, votre programme répond %b\n", l4.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Double> l5 = new List<>(25.0,2.0,3.0,4.0,5.0,6.0);
        l5.display();
        try {
            System.out.printf("La réponse est false, votre programme répond %b\n", l5.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Double> l6 = new List<>(1.0,2.0,3.0,4.0,5.0,-9.0);
        l6.display();
        try {
            System.out.printf("La réponse est false, votre programme répond %b\n", l6.isSorted3());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Ajout de 5.5 à la list l3");
        l3.display();
        l3 = addInOrder(l3, 5.5);
        l3.display();

    }
}
