import co.edu.uptc.models.SimpleList;


public class Main {
    public static void main(String[] args) {
        SimpleList sl = new SimpleList();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        System.out.println(sl.size());
        for (Object o : sl.toArray()) {
            System.out.println(o);
        }
        System.out.println(sl.sum());
    }
}