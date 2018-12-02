package core.threads;

import core.SortedLinkedList;

import java.util.Random;

public class ThreadInsert extends Thread{
    private SortedLinkedList<Double> sortedLinkedList;
    private int count;
    private Random random;

    public ThreadInsert(SortedLinkedList<Double> sortedLinkedList, int count) {
        this.sortedLinkedList = sortedLinkedList;
        this.count = count;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            sortedLinkedList.insert((i+1)*1.0);
        }
    }
}
