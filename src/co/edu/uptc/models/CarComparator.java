package co.edu.uptc.models;

import co.edu.uptc.pojos.Car;

import java.util.Comparator;

public class CarComparator {

    public static Comparator<Car> getBrandComparator() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.brand().compareTo(o2.brand());
            }
        };
    }

    public static Comparator<Car> getModelComparator() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Integer.compare(o1.model(), o2.model());
            }
        };
    }

    public static Comparator<Car> getColorComparator() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.color().compareTo(o2.color());
            }
        };
    }
}