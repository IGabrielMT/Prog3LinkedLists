package co.edu.uptc.models;

public class Node {
    private Object info;
    private Node next;

    public Object getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
