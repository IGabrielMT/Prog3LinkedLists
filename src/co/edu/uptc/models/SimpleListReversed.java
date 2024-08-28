package co.edu.uptc.models;

public class SimpleListReversed {
    Node header;

    public void add(String value) {
        Node newNode = new Node();
        newNode.setInfo(value);
        newNode.setNext(header); // New node points to the current header
        header = newNode; // Update header to the new node
    }

    public void showList() {
        Node aux = header;
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getNext();
        }
    }
}
