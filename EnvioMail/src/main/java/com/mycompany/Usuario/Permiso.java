/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Usuario;

/**
 *
 * @author jmazzetti Sectores: produccion, ventas, marketing, desarrollo,
 * gerencia
 */
//Esto es para pacticar patrones de diseño singleton.
public class Permiso {

    static Permiso permiso = null;

    private Permiso() {

    }

    public static void darPermiso(Empleado empleado) {
        if (null == permiso) {
            permiso = new Permiso();
        }
        String sector = empleado.getSector();
        switch (sector) {
            case "produccion":
                System.out.println("Lectura, nivel 1");
                empleado.setNivelDePermisos(1);
                break;
            case "ventas":
                System.out.println("Lectura, nivel 2");
                empleado.setNivelDePermisos(2);
                break;
            case "marketing":
                System.out.println("Escritura, nivel 3");
                empleado.setNivelDePermisos(3);
                break;
            case "desarrollo":
                System.out.println("Escritura, nivel 4");
                empleado.setNivelDePermisos(4);
                break;
            case "gerencia":
                System.out.println("Todo, nivel 5");
                empleado.setNivelDePermisos(5);
                break;
                
            default:
                System.out.println("Debe registrar nuevo sector o verificar dato ingresado.");
                empleado.setNivelDePermisos(0);
                break;
        }

    }
}
