/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Registro;

import com.mycompany.EnvioMail.EnvioMail;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jmazzetti
 */
public class InterfazUsuario {

    static InterfazUsuario interfaz = null;

    private InterfazUsuario() {

    }

    public static void mostrar() {
        if (interfaz == null) {
            interfaz = new InterfazUsuario();
        }
        interfaz.menu();

    }

    private void menu() {
        boolean ejecutar = true;

        try {
            Statement sql = ConexionSQL.getConexion().createStatement();
            String consulta = ""; //Determino que base usar.
            ResultSet resultado;
            while (ejecutar) {
                System.out.println("¿Qué quiere hacer?\n1. Registrar Personas\n2. Registrar Empleados\n3. Crear Sector\n4. Enviar mails a todo el mundo\n5. Salir\n");
                String seleccion = (new Scanner(System.in)).next();
                switch (seleccion) {
                    case "1":
                        consulta += "INSERT INTO Personas (DNI, Nombre, Apellido,Telefono,Email,FechaDeNacimiento,id_Genero) VALUES (";
                        System.out.println("DNI: ");
                        consulta += (new Scanner(System.in)).next() + ",";
                        System.out.println("Nombre: ");
                        consulta += "\'" + (new Scanner(System.in)).next() + "\',";
                        System.out.println("Apellido: ");
                        consulta += "\'" + (new Scanner(System.in)).next() + "\',";
                        System.out.println("Telefono: ");
                        consulta += "\'" + (new Scanner(System.in)).next() + "\',";
                        System.out.println("Email: ");
                        consulta += "\'" + (new Scanner(System.in)).next() + "\',";
                        System.out.println("FechaDeNacimiento: ");
                        consulta += "\'" + (new Scanner(System.in)).next() + "\',";
                        System.out.println("Genero 1.masculino 2.femenino 3.otros: ");
                        consulta += (new Scanner(System.in)).next() + ")";
                        sql.executeQuery(consulta); //ejecuto query
                        break;
                    case "2":
                        resultado = sql.executeQuery(consulta); //ejecuto query
                        break;
                    case "3":
                        resultado = sql.executeQuery(consulta); //ejecuto query
                        break;
                    case "4":
                        consulta = "SELECT nombre,apellido,email FROM Personas";
                        resultado = sql.executeQuery(consulta); //ejecuto query
                        while (resultado.next()) {                            
                            System.out.println(resultado.getString(3));
                            EnvioMail.enviar(resultado.getString(3), "PRUEBA", "HOLA " + resultado.getString(1));
                        }

                        break;
                    case "5":
                        resultado = sql.executeQuery(consulta); //ejecuto query
                        ejecutar = false;
                        break;
                    default:
                        menu();
                }
            }
        } catch (Exception e) {

        }

    }
}
