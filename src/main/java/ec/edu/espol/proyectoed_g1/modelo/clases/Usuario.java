/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;

/**
 *
 * @author creditos gonzalez
 */
public class Usuario {
    private String name;
    private String lastName;
    private String number;
    private String mail;
    private DoublyLinkedList<Vehicle> misVehiculos;

    public Usuario(String name, String number, String mail) {
        this.name = name;
        this.number = number;
        this.mail = mail;
        this.misVehiculos = new DoublyLinkedList<>();
    }

    
    public Usuario(String name, String lastName, String number, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.mail = mail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public DoublyLinkedList<Vehicle> getMisVehiculos() {
        return misVehiculos;
    }

    public void setMisVehiculos(DoublyLinkedList<Vehicle> misVehiculos) {
        this.misVehiculos = misVehiculos;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
