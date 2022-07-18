/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Usuario;

/**
 *
 * @author jmazzetti
 */
public class Desarrollador extends Empleado {
    public Desarrollador(String nombre, String apellido, String fechaNacimeinto, genero gen, int legajo){
        super(nombre, apellido, fechaNacimeinto, gen, legajo);
        setSector(Sector.desarrollo);
        
    }
    
    public static void main(String args[]) {
        Desarrollador unDesarrollador=new Desarrollador("Jeremias", "Mazzetti", "1992/06/01", genero.m, 109010);
        Permiso.darPermiso(unDesarrollador);
        unDesarrollador.mostarDatosDeEmpleo();
    }
}
