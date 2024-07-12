
package ec.edu.espol.proyectoed_g1.modelo.Nodos;

import java.io.Serializable;

public class NodeList<E> implements Serializable{
    private E content;
    private NodeList<E> next;

    public NodeList(E content) {
        this.content = content;
        this.next = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public NodeList<E> getNext() {
        return next;
    }

    public void setNext(NodeList<E> next) {
        this.next = next;
    }
    
}
