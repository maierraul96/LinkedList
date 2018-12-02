import core.SortedLinkedList;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SortedLinkedList<Double> list = new SortedLinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++)
            list.insert(rand.nextDouble());

        System.out.println("Hello World!");
        list.print();
    }
}
