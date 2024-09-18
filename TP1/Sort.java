public class Sort {
    public static boolean isSorted(List<Double> list){
        return true;
    }

    public static List<Double> addInOrder(List<Double> list, Double in){
        return list;
    }

    public static void main(String... args){
        List<Double> l = new List<>(0.0,20.3, -6.3);
        l.display();
        System.out.printf("La réponse est false, votre programme répond %b\n", isSorted(l));

        
        List<Double> l2 = new List<>(-6.3,0.0,20.3);
        l2.display();
        System.out.printf("La réponse est true, votre programme répond %b\n", isSorted(l2));
    }
}
