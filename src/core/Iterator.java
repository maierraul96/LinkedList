package core;

public class Iterator<T extends Comparable<T>> implements java.util.Iterator {

    Node<T> node;

    public Iterator(Node<T> node) {
        this.node = node;
    }

    public boolean isValid() {
        return node != null;
    }

    @Override
    public boolean hasNext() {
        return node.getNext() != null;
    }

    public Node<T> current() {
        return this.node;
    }

    @Override
    public Node<T> next() {
        Node<T> current = this.node;
        this.node = this.node.getNext();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return current;
    }
}
