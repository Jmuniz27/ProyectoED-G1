package ec.edu.espol.proyectoed_g1.modelo.Listas;


import java.util.Comparator;
import java.util.Iterator;
import ec.edu.espol.proyectoed_g1.modelo.Nodos.NodeList;
import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import java.io.Serializable;

public class LinkedList<E> implements List<E>,Serializable{
    private NodeList<E> header;
    private NodeList<E> last;
    //private int size = 0;
    
    public LinkedList(){
        this.header=null;
        this.last=null;
    }
    public NodeList<E> getHeader() {
        return header;
    }
    public boolean remove(E element) {
        if (header == null) {
            return false; // lista vacia
        }

        if (header.getContent().equals(element)) {
            header = header.getNext();
            if (header == null) {
                last = null; // lista viene vacia
            }
            return true;
        }

        NodeList<E> current = header;
        while (current.getNext() != null && !current.getNext().getContent().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                last = current; // actualiza el ult nodo
            }
            return true;
        }

        return false; // no fue encontrado
    }

    public void setHeader(NodeList<E> header) {
        this.header = header;
    }

    public NodeList<E> getLast() {
        return last;
    }
    
    public LinkedList<E> copy() {
        LinkedList<E> copy = new LinkedList<>();
        NodeList<E> current = this.header;

        while (current != null) {
            copy.addLast(current.getContent());
            current = current.getNext();
        }
        
        return copy;
    }
    
    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) { //dado un elemento generico
        //size++;
        if(e!=null) {
            NodeList<E> newNode=new NodeList<>(e); // constructor crea un nodo aislado
            if(header != null){
                newNode.setNext(header); //El siguiente de ese nuevo nodo es Header
            }
            this.setHeader(newNode);//actualizar el header de la lista
            if(last == null){
                last = newNode;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addLast(E e) {
        //size++;
        if(e!=null){
            NodeList<E> newNode = new NodeList<>(e);
            if(last !=null){
                last.setNext(newNode);
            }
            last = newNode;
            
            if(header == null){
                header = newNode;
            }
            return true;
        } else {
            return false;
        }  
    }
    
    private NodeList<E> getPrevious(NodeList<E> node){
        NodeList<E> previous = null;
        NodeList<E> n;
        
        for(n = header; n!=node; n= n.getNext()){
            previous = n;
        }
        return previous;
    }
    
    private void recorrerHaciAtras(){
        NodeList<E> n;
        
        for (n = last; n != header; n = this.getPrevious(n)){
            System.out.println(n);
        }
    }
    
    @Override
    public E removeFirst() {
        if(size()==1){
            E content = header.getContent();
            last=null;
            header=null;
            return content;
        } else if(size()==0){
            return null;
        }
        NodeList<E> n = header.getNext();
        E content = header.getContent();
        this.setHeader(n);
        return content;
    }

    @Override
    public E removeLast() {
        if(size()==1){
            E content = last.getContent();
            last=null;
            header=null;
            return content;
        }else if(size()==0){
            return null;
        }
        NodeList<E> n = null;
        for(NodeList<E> i = header; i!=last; i=i.getNext()){
            n = i;
        }
        n.setNext(null);
        E content = last.getContent();
        this.setLast(n);
        return content;
        //size--;
    }

    @Override
    public int size() {
        // return size; // O(1)
        // primera parte declaro variables a iterar
        // segunda parte condicion logica
        // tercera parte instrucciones
        //for (int i=0, j=0; i < 10 && j >8; i++){
        //for (NodeList<E> n = header; n ! = null ; n = n.getNext()){
        
        // Complejidad lineal O(n) a pesar de que no es tan buena como O(1) evita que tenga que darle mantenimiento a size
        int size = 0;
        NodeList<E> n; //declaro un nodo viajero
        //declaro un nodo viajero, mientras sea diferente de null, se mueve al siguiente nodo
        
        for (n = header ; n!= null ; n = n.getNext( )) {
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString(){
        String string = "[";
        for(NodeList<E> n = header;n!=null;n=n.getNext()){
            if(n == last){
                string += n.getContent() + "]";
                
            }else{
                string += n.getContent() + ", ";
            }
        }
        return string;
    }
    
    public Iterator<E> iterator(){
        Iterator<E> it=new Iterator<E>() {
                NodeList<E> cursor = header;
                
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext();
                return e;
            }
        };
        
        
        return it;
    }
    

    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sort(Comparator<E> comparator) {
    if (header == null || header.getNext() == null) {
        return; // La lista está vacía o tiene un solo elemento
    }

    NodeList<E> sorted = null; // Lista donde se almacenarán los nodos ordenados
    NodeList<E> current = header; // Comenzar con el primer elemento de la lista original

    while (current != null) {
        NodeList<E> next = current.getNext(); // Guardar el siguiente nodo
        sorted = insertSorted(sorted, current, comparator); // Insertar el nodo actual en la lista ordenada
        current = next; // Mover al siguiente nodo
    }

    header = sorted; // Actualizar el encabezado de la lista con la lista ordenada
    // Reconstruir el último nodo
    last = header;
    if (last != null) {
        while (last.getNext() != null) {
            last = last.getNext(); // Actualizar el último nodo
        }
    }
}

    private NodeList<E> insertSorted(NodeList<E> sorted, NodeList<E> newNode, Comparator<E> comparator) {
        if (sorted == null || comparator.compare(newNode.getContent(), sorted.getContent()) < 0) {
            newNode.setNext(sorted);
            return newNode;
        }

        NodeList<E> current = sorted;
        while (current.getNext() != null && comparator.compare(newNode.getContent(), current.getNext().getContent()) >= 0) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        return sorted;
    }

    @Override
    public boolean addAll(List<E> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}