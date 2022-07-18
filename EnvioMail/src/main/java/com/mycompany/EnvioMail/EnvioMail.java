/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.EnvioMail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioMail {

    static EnvioMail mail = null;
    static String destinatario, mensaje, asunto;

    private EnvioMail() {

    }

    public static void enviar(String destinatario, String asunto, String mensaje) throws FileNotFoundException {
        if (mail == null) {
            mail = new EnvioMail();
        }
        EnvioMail.destinatario = destinatario;
        EnvioMail.asunto = asunto;
        EnvioMail.mensaje = mensaje;
        mail.ejecutar();

    }

    public void ejecutar() throws FileNotFoundException {
        try ( InputStream input = new FileInputStream("src/main/java/com/mycompany/EnvioMail/config.properties")) {
            Properties props = new Properties();
            props.load(input);
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
                }
            });
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(props.getProperty("username")));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(EnvioMail.destinatario));
                message.setSubject(EnvioMail.asunto);
                message.setText(EnvioMail.mensaje);

                Transport.send(message);

                System.out.println("Enviado!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
