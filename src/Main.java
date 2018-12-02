import core.SortedLinkedList;
import core.threads.ThreadDelete;
import core.threads.ThreadInsert;
import core.threads.ThreadIterate;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SortedLinkedList<Double> list = new SortedLinkedList<>();
        ThreadInsert threadInsert1 = new ThreadInsert(list, 10);
        ThreadInsert threadInsert2 = new ThreadInsert(list, 10);
        ThreadDelete threadDelete = new ThreadDelete(list, 5);
        ThreadIterate threadIterate = new ThreadIterate(list, 1);

        threadInsert1.start();
        threadInsert2.start();
        threadDelete.start();
        threadIterate.setDaemon(true);
        threadIterate.start();
        try {
            threadInsert1.join();
            threadInsert2.join();
            threadDelete.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");
        list.print();
    }
}
