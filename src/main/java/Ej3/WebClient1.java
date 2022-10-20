package Ej3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class WebClient1 {
    public static void main(String[] args) {
        escribeRecurso("http://i1.wp.com/hipertextual.com/wp-content/uploads/2015/09/googles-new-logo-.gif", "googles-new-logo-.gif");
    }

    public static void escribeRecurso(String url, String nombreGuardado) {
        String[] direccion= url.split("http://");
        String[] sinHTTP= direccion[1].split("/");
        String recurso=url.split(sinHTTP[0])[1];
        try (Socket soc = new Socket(sinHTTP[0], 80);
             PrintStream ps = new PrintStream(soc.getOutputStream());
             DataInputStream dis = new DataInputStream(soc.getInputStream());
             FileOutputStream fos = new FileOutputStream(nombreGuardado)
        ) {
            ps.println("GET " + recurso+ " HTTP/1.1");
            ps.println("Host: "+sinHTTP[0]);
            ps.println(); //Esta linea es necesaria para que el servidor HTTP responda.
            ps.flush();
            byte [] buff = new byte[128];
            int leidos;
            while(!dis.readLine().equals("")){
            }
            while((leidos=dis.read(buff))!=-1){
                fos.write(buff,0,leidos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
