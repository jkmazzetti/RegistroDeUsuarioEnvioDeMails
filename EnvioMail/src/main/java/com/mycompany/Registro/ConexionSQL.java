/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Registro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jmazzetti
 */
public class ConexionSQL {

    public static Connection getConexion() {
        Properties props = new Properties();
        try ( InputStream input = new FileInputStream("src/main/java/com/mycompany/EnvioMail/config.properties")) {
            props.load(input);
        } catch (IOException ex) {
        }
        try {
            String URLconexion = "jdbc:" + props.getProperty("jdbc")
                    + ";databaseName=" + props.getProperty("databaseName")
                    + ";database=" + props.getProperty("database")
                    + ";user="
                    + props.getProperty("user")
                    + ";password=" + props.getProperty("db.password")
                    + ";loginTimeout=" + props.getProperty("loginTimeout");
            Connection conexion = DriverManager.getConnection(URLconexion);
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }
}
