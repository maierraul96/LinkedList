package core;


public class SortedLinkedList<T extends Comparable<T>> implements Iterable {

    Node<T> head;

    public SortedLinkedList() {
        this.head = null;
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

    public void insert(T value) {
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

    public void delete(T value) {
        Iterator<T> iterator = this.iterator();

        if (!specialDelete(value)) {
            while (iterator.hasNext()){
                if (iterator.current().getNext().getValue().compareTo(value) == 0){
                    iterator.current().setNext(iterator.current().getNext().getNext());
                }
                if (iterator.hasNext())
                    iterator.next();
            }
        }
    }

    public void print() {
        Iterator<T> iterator = this.iterator();
        while (iterator.isValid())
            System.out.print(iterator.next().getValue() + " ");
    }
}
