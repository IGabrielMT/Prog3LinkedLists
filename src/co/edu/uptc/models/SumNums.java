package co.edu.uptc.models;

import java.util.List;

public class SumNums {
    public int sumLists(List<Integer> list){
        int sum = 0;
        for(int nums : list){
            sum += nums;
        }
        return sum;
    }
}
