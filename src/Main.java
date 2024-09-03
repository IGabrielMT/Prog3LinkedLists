import co.edu.uptc.models.SimpleList;
import co.edu.uptc.models.SumNums;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test();
    }
    private static void test(){
        Main main = new Main();
        List<Integer> nodeList = main.createNodeList();
        List<Integer> arrayList = main.createArrayListNums();
        long nodeListTime = main.measureSumTime(nodeList);
        long arrayListTime = main.measureSumTime(arrayList);

        System.out.println("Time taken to sum SimpleList: " + nodeListTime + " nano seconds");
        System.out.println("Time taken to sum ArrayList: " + arrayListTime + " nano seconds");
    }
    private List<Integer> createArrayListNums(){
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            arrayList.add((int) (Math.random()*10000));
        }
        return arrayList;
    }
    private List<Integer> createNodeList(){
        List<Integer> nodeList = new SimpleList<>();
        for (int i = 0; i < 500; i++) {
            nodeList.add((int) (Math.random()*10000));
        }
        return nodeList;
    }
    private long measureSumTime(List<Integer> list) {
        SumNums sumNums = new SumNums();
        System.out.println("Sum: " + sumNums.sumLists(list));
        long startTime = System.nanoTime();
        sumNums.sumLists(list);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


}