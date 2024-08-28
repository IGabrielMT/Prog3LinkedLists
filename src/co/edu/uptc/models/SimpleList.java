package co.edu.uptc.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList implements List {
    Node header;
    Node tail;

    @Override
    public int size() {
        int i = 0;
        Node aux = header;
        while(aux != null){
            i++;
            aux = aux.getNext();
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node aux = header;
        int i = 0;
        while(aux != null){
            array[i++] = aux.getInfo();
            aux = aux.getNext();
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        Node newNode = new Node();
        newNode.setInfo(o);
        if (header == null) {
            header = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public int sum(){
        int sum = 0;
        Node aux = header;
        while(aux != null){
            sum += (int) aux.getInfo();
            aux = aux.getNext();
        }
        return sum;
    }
}
