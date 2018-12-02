package core.threads;

import core.SortedLinkedList;

import java.util.Random;

public class ThreadIterate extends Thread {
    private SortedLinkedList<Double> sortedLinkedList;
    private int count;
    private int delay;

    public ThreadIterate(SortedLinkedList<Double> sortedLinkedList, int delay) {
        this.sortedLinkedList = sortedLinkedList;
        this.count = 0;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Afisare " + count++);
            sortedLinkedList.print();
            System.out.println("-----------------");
            System.out.println();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
