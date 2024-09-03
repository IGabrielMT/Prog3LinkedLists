import co.edu.uptc.models.CarComparator;
import co.edu.uptc.models.SimpleList;
import co.edu.uptc.pojos.Car;

public class Main {
    public static void main(String[] args) {
        SimpleList<Car> cars = new SimpleList<>();
        cars.add(new Car("Chevrolet", 2020, "Red"));
        cars.add(new Car("Mazda", 2021, "Blue"));
        cars.add(new Car("Renault", 2019, "Black"));
        cars.add(new Car("Toyota", 2022, "White"));
        cars.add(new Car("Ford", 2018, "Yellow"));
        System.out.println("Sin ordenar por marca \n");
        for (Car car : cars) {
            System.out.println(car.brand());
        }
        cars.sort(CarComparator.getBrandComparator());
        System.out.println("Ordenados por marca \n");
        for (Car car : cars) {
            System.out.println(car.brand());
        }

    }


}