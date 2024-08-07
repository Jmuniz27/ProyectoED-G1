package ec.edu.espol.proyectoed_g1.modelo.Nodos;

import java.io.Serializable;

public class DoublyNode<E> implements Serializable{
    private E content;
    private DoublyNode<E> next;
    private DoublyNode<E> previous;
    public DoublyNode(E content) {
        this.content = content;
        this.next = null;
        this.previous = null;
    }
    public E getContent() {
        return content;
    }
    public void setContent(E content) {
        this.content = content;
    }
    public DoublyNode<E> getNext() {
        return next;
    }
    public void setNext(DoublyNode<E> next) {
        this.next = next;
    }
    public DoublyNode<E> getPrevious() {
        return previous;
    }
    public void setPrevious(DoublyNode<E> previous) {
        this.previous = previous;
    }
    @Override
    public String toString() {
        return "DoublyNode [content=" + content + "]";
    }
    
}
