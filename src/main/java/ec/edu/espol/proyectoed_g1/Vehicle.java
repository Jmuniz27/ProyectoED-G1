/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;

/**
 *
 * @author creditos gonzalez
 */
public class Vehicle {
    private Precio precio;
    private String marca;
    private String modelo;
    private int year;
    private float km;
    private String transmisión;
    private float peso;
    private String ubiAct;
    private Usuario dueno;
    private boolean esVendido;
    private Historial HistReparacion;
    private tipoVehiculo tipovehiculo;
    private CircularDoublyLinkedList<Imagen> imagsCarro;

    public Vehicle(Precio precio, String marca, String modelo, int year, float km, String transmisión, float peso, String ubiAct, Usuario dueno, boolean esVendido, Historial HistReparacion, tipoVehiculo tipovehiculo, CircularDoublyLinkedList<Imagen> imagsCarro) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.km = km;
        this.transmisión = transmisión;
        this.peso = peso;
        this.ubiAct = ubiAct;
        this.dueno = dueno;
        this.esVendido = esVendido;
        this.HistReparacion = HistReparacion;
        this.tipovehiculo = tipovehiculo;
        this.imagsCarro = imagsCarro;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getTransmisión() {
        return transmisión;
    }

    public void setTransmisión(String transmisión) {
        this.transmisión = transmisión;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getUbiAct() {
        return ubiAct;
    }

    public void setUbiAct(String ubiAct) {
        this.ubiAct = ubiAct;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }

    public boolean isEsVendido() {
        return esVendido;
    }

    public void setEsVendido(boolean esVendido) {
        this.esVendido = esVendido;
    }

    public Historial getHistReparacion() {
        return HistReparacion;
    }

    public void setHistReparacion(Historial HistReparacion) {
        this.HistReparacion = HistReparacion;
    }

    public tipoVehiculo getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(tipoVehiculo tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public CircularDoublyLinkedList<Imagen> getImagsCarro() {
        return imagsCarro;
    }

    public void setImagsCarro(CircularDoublyLinkedList<Imagen> imagsCarro) {
        this.imagsCarro = imagsCarro;
    }
    
    public void venderVehiculo(){
        
    }
    
    
}
