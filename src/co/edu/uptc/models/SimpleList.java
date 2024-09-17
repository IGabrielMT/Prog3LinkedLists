package co.edu.uptc.models;

import java.util.*;

public class SimpleList<T> implements List<T> {
    Node<T> header;
    Node<T> tail;

    @Override
    public int size() {
        int i = 0;
        Node<T> aux = header;
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
        Node<T> aux = header;
        while (aux != null) {
            if (aux.getInfo().equals(o)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<T> aux = header;
        int i = 0;
        while(aux != null){
            array[i++] = aux.getInfo();
            aux = aux.getNext();
        }
        return array;
    }

    @Override
    public boolean add(T o) {
        Node<T> newNode = new Node<>();
        newNode.setInfo(o);
        if (header == null) {
            header = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (header == null) {
            return false;
        }
        if (header.getInfo().equals(o)) {
            header = header.getNext();
            return true;
        }
        Node<T> current = header;
        while (current.getNext() != null) {
            if (current.getNext().getInfo().equals(o)) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    tail = current;
                }
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        boolean modified = false;
        Node<T> current = header;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        for (T element : c) {
            Node<T> newNode = new Node<>();
            newNode.setInfo(element);
            if (current == null) {
                header = newNode;
                tail = newNode;
            } else {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (newNode.getNext() == null) {
                    tail = newNode;
                }
            }
            current = newNode;
            modified = true;
        }
        return modified;
    }

    @Override
    public void clear() {
        header = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> aux = header;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux.getInfo();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> aux = header;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        T oldValue = aux.getInfo();
        aux.setInfo(element);
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> newNode = new Node<>();
        newNode.setInfo(element);
        if (index == 0) {
            newNode.setNext(header);
            header = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            Node<T> current = header;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                tail = newNode;
            }
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            T oldValue = header.getInfo();
            header = header.getNext();
            if (header == null) {
                tail = null;
            }
            return oldValue;
        }
        Node<T> current = header;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        T oldValue = current.getNext().getInfo();
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
            tail = current;
        }
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<T> aux = header;
        while (aux != null) {
            if (aux.getInfo().equals(o)) {
                return index;
            }
            aux = aux.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        int currentIndex = 0;
        Node<T> aux = header;
        while (aux != null) {
            if (aux.getInfo().equals(o)) {
                index = currentIndex;
            }
            aux = aux.getNext();
            currentIndex++;
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return new ListIterator<>() {
            private Node<T> current = header;
            private int currentIndex;

            {
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                currentIndex = index;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.getInfo();
                current = current.getNext();
                currentIndex++;
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                Node<T> aux = header;
                for (int i = 0; i < currentIndex - 1; i++) {
                    aux = aux.getNext();
                }
                current = aux;
                currentIndex--;
                return current.getInfo();
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size());
        }
        List<T> subList = new ArrayList<>();
        Node<T> aux = header;
        for (int i = 0; i < fromIndex; i++) {
            aux = aux.getNext();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(aux.getInfo());
            aux = aux.getNext();
        }
        return subList;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = header;
        Node<T> prev = null;
        while (current != null) {
            if (!c.contains(current.getInfo())) {
                if (prev == null) {
                    header = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    tail = prev;
                }
                modified = true;
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Node<T> current = header;
        Node<T> prev = null;
        while (current != null) {
            if (c.contains(current.getInfo())) {
                if (prev == null) {
                    header = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    tail = prev;
                }
                modified = true;
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        int size = size();
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (Node<T> x = header; x != null; x = x.getNext()) {
            result[i++] = x.getInfo();
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    private class SimpleListIterator implements Iterator<T> {
        private Node<T> current = header;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getInfo();
            current = current.getNext();
            return data;
        }
    }

    public void sort(Comparator<? super T> comparator) {
        if (header == null || header.getNext() == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = header;
            while (current.getNext() != null) {
                if (comparator.compare(current.getInfo(), current.getNext().getInfo()) > 0) {
                    T temp = current.getInfo();
                    current.setInfo(current.getNext().getInfo());
                    current.getNext().setInfo(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
}