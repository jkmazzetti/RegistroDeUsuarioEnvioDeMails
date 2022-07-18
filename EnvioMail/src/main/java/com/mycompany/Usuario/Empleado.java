/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Usuario;

/**
 *
 * @author jmazzetti
 */
public abstract class Empleado extends Persona {

    private int nivelDePermisos; //Del 1 al 5, mayor numero mas permisos.
    private int legajo;
    private Sector sector;

    public Empleado(String nombre, String apellido, String fechaNacimeinto, genero gen, int legajo) {
        super(nombre, apellido, fechaNacimeinto, genero.m);
        this.legajo = legajo;

    }

    public String getSector() {
        return this.sector.toString();
    }

    public void setSector(Sector unSector) {
        this.sector = unSector;
    }

    public enum Sector {
        produccion,
        ventas,
        marketing,
        desarrollo,
        gerencia
    }

    public void setNivelDePermisos(int permiso) {
        this.nivelDePermisos = permiso;
    }

    public void mostarDatosDeEmpleo() {
        System.out.println(getNombre() + " " + getApellido() + " " + this.sector + " " + this.nivelDePermisos + " " + this.legajo
        );
    }
}
