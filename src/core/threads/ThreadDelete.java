package core.threads;

import core.SortedLinkedList;

import java.util.Random;

public class ThreadDelete extends Thread{
    private SortedLinkedList<Double> sortedLinkedList;
    private int count;
    private Random random;

    public ThreadDelete(SortedLinkedList<Double> sortedLinkedList, int count) {
        this.sortedLinkedList = sortedLinkedList;
        this.count = count;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            sortedLinkedList.delete((i+1)*1.0);
        }
    }
}
