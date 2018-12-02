package core;


import java.util.logging.Level;

public class SortedLinkedListLevelList<T extends Comparable<T>> extends SortedLinkedList<T> {

    public SortedLinkedListLevelList() {
        super();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>(this.head);
    }

    private boolean specialInsert(T value) {
        Node<T> newNode = new Node<>(value);
        Iterator<T> iterator = this.iterator();

        if (!iterator.isValid()) {
            this.head = newNode;
            return true;
        }

        if (newNode.getValue().compareTo(this.head.getValue()) < 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            return true;
        }

        return false;
    }

    @Override
    public synchronized void insert(T value) {

        logger.log(Level.INFO, "Inserting: {0} Thread: {1}", new Object[]{value.toString(),
                Thread.currentThread().getName()});

        Node<T> newNode = new Node<>(value);
        Iterator<T> iterator = this.iterator();

        if (!specialInsert(value)) {
            while (iterator.hasNext()) {
                if (iterator.current().getNext().getValue().compareTo(newNode.getValue()) > 0) {
                    newNode.setNext(iterator.current().getNext());
                    iterator.current().setNext(newNode);
                    return;
                }
                iterator.next();
            }
            //in case is the largest
            iterator.current().setNext(newNode);
        }
    }

    private boolean specialDelete(T value) {
        if (this.head == null)
            return true;

        if (this.head.getValue().compareTo(value) == 0) {
            this.head = this.head.getNext();
            return true;
        }

        return false;
    }

    public synchronized void delete(T value) {
        logger.log(Level.INFO, "Deleting: {0} Thread: {1}", new Object[]{value.toString(),
                Thread.currentThread().getName()});

        Iterator<T> iterator = this.iterator();

        if (!specialDelete(value)) {
            while (iterator.hasNext()) {
                if (iterator.current().getNext().getValue().compareTo(value) == 0) {
                    iterator.current().setNext(iterator.current().getNext().getNext());
                }
                if (iterator.hasNext())
                    iterator.next();
            }
        }
    }

    public synchronized void print() {
        logger.log(Level.INFO, "Start iterating  Thread: {0}", Thread.currentThread().getName());
        Iterator<T> iterator = this.iterator();
        Integer pos = 0;
        String msg = "";
        while (iterator.isValid()) {
            msg += iterator.current().getValue() + " ";
            System.out.println("pos:" + (++pos).toString() + " val: " + iterator.next().getValue() + " ");
        }
        logger.log(Level.INFO, "Values: {0}  Thread {1}", new Object[]{msg, Thread.currentThread().getName()});
    }
}
