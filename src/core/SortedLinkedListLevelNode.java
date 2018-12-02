package core;

import java.util.Iterator;
import java.util.logging.Level;

public class SortedLinkedListLevelNode<T extends Comparable<T>> extends SortedLinkedList<T> {

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void insert(T value) {

        logger.log(Level.INFO, "Inserting: {0} Thread: {1}", new Object[]{value.toString(),
                Thread.currentThread().getName()});

        Node<T> newNode = new Node<>(value);
        Node<T> currentNode = this.head;

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        if (this.head.getValue().compareTo(newNode.getValue()) > 0) {
            synchronized (newNode) {
                synchronized (this.head) {
                    newNode.setNext(this.head);
                    this.head = newNode;
                }
            }
            return;
        }

        while (currentNode.getNext() != null) {
            boolean added = false;
            synchronized (currentNode) {
                synchronized (currentNode.getNext()) {
                    if (currentNode.getNext().getValue().compareTo(newNode.getValue()) > 0) {
                        newNode.setNext(currentNode.getNext());
                        currentNode.setNext(newNode);
                        added = true;
                    }
                }
            }
            if (added)
                return;
            currentNode = currentNode.getNext();
        }

        synchronized (currentNode) {
            currentNode.setNext(newNode);
        }
    }

    @Override
    public void delete(T value) {

        if (this.head == null) {
            return;
        }

        if (this.head.getValue().compareTo(value) == 0){
            synchronized (this.head) {
                this.head = this.head.getNext();
            }
        }

        Node<T> current = this.head;

        while (current.getNext() != null) {
            synchronized (current) {
                synchronized (current.getNext()) {
                    if (current.getNext().getValue().compareTo(value) == 0) {
                        current.setNext(current.getNext().getNext());
                    }
                    if (current.getNext() != null)
                        current = current.getNext();
                }
            }
        }
    }

    @Override
    public void print() {
        Node<T> current = this.head;
        Integer pos = 0;
        String msg = "";
        while (current != null) {
            msg += current.getValue() + " ";
            System.out.println("pos:" + (++pos).toString() + " val: " + current.getValue() + " ");
            current = current.getNext();
        }
    }
}

