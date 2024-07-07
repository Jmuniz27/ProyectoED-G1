/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import javafx.scene.image.Image;

/**
 *
 * @author creditos gonzalez
 */
public class Vehicle {
    private Precio precio;
    private Marca marca;
    private String modelo;
    private int year;
    private int km;
    private String transmision;
    private double peso;
    private String ubiAct;
    private String motor;
    private Usuario dueno;
    private boolean esVendido;
    private Historial historial;
    private CircularDoublyLinkedList<Image> imagsCarro;
    private boolean esLiked;

    public Vehicle(Precio precio, Marca marca, String modelo, int year, int km, String transmision, double peso, String ubiAct, String motor, Usuario dueno, boolean esVendido, Historial HistReparacion, CircularDoublyLinkedList<Image> imagsCarro) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.km = km;
        this.transmision = transmision;
        this.peso = peso;
        this.ubiAct = ubiAct;
        this.dueno = dueno;
        this.esVendido = esVendido;
        this.historial = HistReparacion;
        this.imagsCarro = imagsCarro;
        this.motor = motor;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public String getMotor() {
        return motor;
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmisión) {
        this.transmision = transmisión;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
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

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public CircularDoublyLinkedList<Image> getImagsCarro() {
        return imagsCarro;
    }

    public void setImagsCarro(CircularDoublyLinkedList<Image> imagsCarro) {
        this.imagsCarro = imagsCarro;
    }

    public boolean isEsLiked() {
        return esLiked;
    }

    public void setEsLiked(boolean esLiked) {
        this.esLiked = esLiked;
    }
    
}
