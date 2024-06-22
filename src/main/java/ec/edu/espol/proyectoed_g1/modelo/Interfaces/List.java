package ec.edu.espol.proyectoed_g1.modelo.Interfaces;

import java.util.Comparator;

public interface List<E> extends Iterable<E>{

    public boolean addFirst(E e); //Inserta el elemento e al inicio
            
    public boolean addLast(E e); //Inserta el elemento e al final
            
    public E removeFirst(); //remueve el elemento al inicio de la lista
    
    public E removeLast(); // remueve el elemento al final de la lista
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
            
    public void add(int index, E element); //Inserta el elemento en la posicion index
            
    public E remove(int index); // remueve y retorna el elemento en la posicion index
    
    public E get(int index); //retorna el elemento ubicado en la posicion index
    
    public E set(int index, E element); //setea elemento en la posicion index

    public int indexOf(E element); //retorna el indice de la primera ocurrencia de element
    
    public void sort(Comparator<E> comparator); //ordena la lista segun el comparador
}
