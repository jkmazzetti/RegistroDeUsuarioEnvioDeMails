/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Usuario;

/**
 *
 * @author jmazzetti
 */
class Persona {

    public enum genero {
        m,
        f,
        o
    };
    private String nombre, apellido, fechaNacimiento;//informacion personal
    private String telefono, email;//infomación de contacto
    private genero gen;

    /*
    ##      La fecha de nacimiento debe ingresarse con el siguiente formato.
    ##      ejemplo: fechaDeNacimiento="1992/06/01"
     */
    public Persona(String nombre, String apellido, String fechaNacimeinto, genero gen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimeinto;
        this.gen = gen;
    }

    public void mostrarDatos() {
        System.out.println(this.nombre + " " + this.apellido + " " + this.fechaNacimiento + " " + this.gen.toString());
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public static void main(String args[]) {
        Persona unaPersona = new Persona("Jeremias", "Mazzetti", "1992/06/01", genero.m);
        Persona otraPersona = new Persona("Naara", "Mazzetti", "1993/06/05", genero.f);
        unaPersona.mostrarDatos();
        otraPersona.mostrarDatos();
    }

}
