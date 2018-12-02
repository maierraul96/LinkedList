import core.SortedLinkedListLevelList;
import core.SortedLinkedListLevelNode;
import core.threads.ThreadDelete;
import core.threads.ThreadInsert;
import core.threads.ThreadIterate;

public class Main {

    public static void main(String[] args) {
        SortedLinkedListLevelList<Double> list = new SortedLinkedListLevelList<>();
        SortedLinkedListLevelNode<Double> listNode = new SortedLinkedListLevelNode<>();

        ThreadInsert threadInsert1 = new ThreadInsert(listNode, 10);
        ThreadInsert threadInsert2 = new ThreadInsert(listNode, 0);
        ThreadDelete threadDelete = new ThreadDelete(listNode, 5);
        ThreadIterate threadIterate = new ThreadIterate(listNode, 1);

        threadInsert1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadInsert2.start();
        threadDelete.start();
        threadIterate.setDaemon(true);
//        threadIterate.start();
        try {
            threadInsert1.join();
            threadInsert2.join();
            threadDelete.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");
        listNode.print();
    }
}
