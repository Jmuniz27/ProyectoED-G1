package ec.edu.espol.proyectoed_g1.modelo.Listas;

import java.util.Comparator;
import java.util.Iterator;

import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import ec.edu.espol.proyectoed_g1.modelo.Nodos.DoublyNode;

public class DoublyLinkedList<E> implements List<E> {
    private DoublyNode<E> head;
    private DoublyNode<E> last;

    //constructor
    public DoublyLinkedList() {
        head = null;
        last = null;
    }
    // implementacion de los metodos de la interfaz List
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private DoublyNode<E> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E content = cursor.getContent();
                cursor = cursor.getNext();
                return content;
            }
        };
        return it;
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null){
            DoublyNode<E> newNode = new DoublyNode<E>(e);
            newNode.setNext(head);
            head.setPrevious(newNode);
            this.setHead(newNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            DoublyNode<E> newNode = new DoublyNode<>(e);
            if (last != null) {
                last.setNext(newNode);
                newNode.setPrevious(last);
            } else {
                head = newNode;
            }
            last = newNode;
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (head != null){
            E content = head.getContent();
            head = head.getNext();
            head.setPrevious(null);
            return content;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (last != null){
            E content = last.getContent();
            last = last.getPrevious();
            last.setNext(null);
            return content;
        }
        return null;
    }

    @Override
    public int size() {
        Iterator<E> it = this.iterator();
        int contador = 0;
        while (it.hasNext()){
            contador++;
            it.next();
        }
        return contador;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        DoublyNode<E> newNode = new DoublyNode<>(element);
        if(element != null && index >= 0 && index <= this.size()){
            if (index == 0){
                this.addFirst(element);
            } else if (index == this.size()){
                this.addLast(element);
            } else {
                DoublyNode<E> cursor = head;
                //hasta que llegue a la posicion anterior a la que se quiere insertar
                for (int i = 0; i < index; i++){
                    cursor = cursor.getNext();
                }
                newNode.setNext(cursor);
                newNode.setPrevious(cursor.getPrevious());
                cursor.getPrevious().setNext(newNode);
                cursor.setPrevious(newNode);
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < this.size()) {
            if (index == 0) {
                return removeFirst();
            } else if (index == this.size() - 1) {
                return removeLast();
            } else {
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
        DoublyNode<E> cursor = head;
        int index = 0;
        while (cursor != null) {
            if (cursor.getContent().equals(element)) {
                return index;
            }
            cursor = cursor.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public void sort(Comparator<E> comparator) {
        if (head == null || head.getNext() == null) {
            return; // La lista está vacía o tiene un solo elemento, ya está ordenada.
        }

        DoublyNode<E> current = head.getNext();
        while (current != null) {
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

    //getters and setters
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}