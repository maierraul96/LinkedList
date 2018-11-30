package core;

public class Iterator<T> implements java.util.Iterator {

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

    @Override
    public Node<T> next() {
        return node.getNext();
    }
}
