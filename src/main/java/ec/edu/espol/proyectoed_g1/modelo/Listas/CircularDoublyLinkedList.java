package ec.edu.espol.proyectoed_g1.modelo.Listas;

import java.util.Comparator;
import java.util.Iterator;

import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import ec.edu.espol.proyectoed_g1.modelo.Nodos.DoublyNode;

public class CircularDoublyLinkedList<E> implements List<E>{
    private DoublyNode<E> head;
    private DoublyNode<E> last;
    public CircularDoublyLinkedList() {
        head = null;
        last = null;
    }
    @Override
    public Iterator<E> iterator() {
        Iterator <E> it = new Iterator<E>(){
            private DoublyNode<E> cursor = head;
            private boolean first = true;
            @Override
            public boolean hasNext() {
                if (cursor == null) {
                    return false;
                }
                if (cursor == head && !first) {
                    return false;
                }
                return true;
            }
            @Override
            public E next() {
                E content = cursor.getContent();
                if (first) {
                    first = false;
                }
                cursor = cursor.getNext();
                return content;
            }
        };
        return it;}
    @Override
    public boolean addFirst(E e) {
        DoublyNode<E> newNode = new DoublyNode<>(e);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrevious(last);
            head.setPrevious(newNode);
            last.setNext(newNode);
            head = newNode;
        }
        return true;
    }
    @Override
    public boolean addLast(E e) {
        DoublyNode<E> newNode = new DoublyNode<>(e);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrevious(last);
            head.setPrevious(newNode);
            last.setNext(newNode);
            last = newNode;
        }
        return true;
    }
    @Override
    public E removeFirst() {
        if(!isEmpty()){
            E contenido = head.getContent();
            last.setNext(head.getNext());
            head.getNext().setPrevious(last);
            head = head.getNext();
            return contenido;
        }
        return null;
    }
    @Override
    public E removeLast() {
        if(!isEmpty()){
            E contenido = last.getContent();
            head.setPrevious(last.getPrevious());
            last.getPrevious().setNext(head);
            last = last.getPrevious();
            return contenido;
        }
        return null;
    }
    @Override
    public int size() {
        int count = 0;
        DoublyNode<E> current = head;
        if (current == null) {
            return count;
        }
        count++;
        current = current.getNext();
        while (current != head) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public void clear() {
        
    }
    @Override
    public void add(int index, E element) {

        if(element != null && index>=0 && index<size()){
            if (index == 0) {
                addFirst(element);
            } else if (index == size()) {
                addLast(element);
            } else {
                DoublyNode<E> newNode = new DoublyNode<>(element);
                DoublyNode<E> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                newNode.setNext(current.getNext());
                newNode.setPrevious(current);
                current.getNext().setPrevious(newNode);
                current.setNext(newNode);
            }
        }
    }
    @Override
    public E remove(int index) {
        if(index>=0 && index<this.size()){
            if(index==0){
                return removeFirst();
            } else if(index == this.size()-1){
                return removeLast();
            }else{
                DoublyNode<E> cursor = head;
                // buscar el nodo anterior al que se quiere eliminar
                for (int i = 0; i < index; i++) {
                    cursor = cursor.getNext();
                }
                E content = cursor.getContent();
                cursor.getPrevious().setNext(cursor.getNext());
                cursor.getNext().setPrevious(cursor.getPrevious());
                return content;
            }
        }
        return null;
    }
    @Override
    public E get(int index) {
        if (index >= 0 && index < this.size()) {
            DoublyNode<E> cursor = head;
            // buscar el nodo en la posición index
            for (int i = 0; i < index; i++) {
                cursor = cursor.getNext();
            }
            return cursor.getContent();
        }
        return null;
    }
    @Override
    public E set(int index, E element) {
        if (element != null && index >= 0 && index < this.size()) {
            DoublyNode<E> cursor = head;
            // buscar el nodo en la posición index
            for (int i = 0; i < index; i++) {
                cursor = cursor.getNext();
            }
            E oldContent = cursor.getContent();
            cursor.setContent(element);
            return oldContent;
        }
        return null;
    }
    @Override
    public int indexOf(E element) {
        if (isEmpty()) {
            return -1; // La lista está vacía.
        }
        
        DoublyNode<E> current = head;
        
        for (int index = 0; index < this.size(); index++) {
            if ((current.getContent() == null && element == null) || (current.getContent() != null && current.getContent().equals(element))) {
                return index;
            }
            current = current.getNext();
        }

        return -1; // Elemento no encontrado.
    }
    @Override
    public void sort(Comparator<E> comparator) {
        if (head == null || head.getNext() == null) {
            return; // La lista está vacía o tiene un solo elemento, ya está ordenada.
        }
        DoublyNode<E> current = head.getNext();
        while (current != head) {
            E temp = current.getContent();
            DoublyNode<E> left = current.getPrevious();
            while (left != null && comparator.compare(left.getContent(), temp) > 0) {
                left.getNext().setContent(left.getContent());
                left = left.getPrevious();
            }
            if (left == null) {
                head.setContent(temp);
            } else {
                left.getNext().setContent(temp);
            }
            current = current.getNext();
        }
    }

    //getters y setters
    public DoublyNode<E> getHead() {
        return head;
    }
    public void setHead(DoublyNode<E> head) {
        this.head = head;
    }
    public DoublyNode<E> getLast() {
        return last;
    }
    public void setLast(DoublyNode<E> last) {
        this.last = last;
    }

    @Override
    public boolean addAll(List<E> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (E element : list) {
            this.addLast(element);
        }
        return true;
    }
    
}
