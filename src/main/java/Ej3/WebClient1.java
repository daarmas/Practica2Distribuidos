package Ej3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class WebClient1 {
    public static void main(String[] args) {
        escribeRecurso("http://i1.wp.com/hipertextual.com/wp-content/uploads/2015/09", "googles-new-logo-.gif");
    }

    public static void escribeRecurso(String url, String recurso) {
        try (Socket s = new Socket(url, 80);
             PrintStream ps = new PrintStream(s.getOutputStream());
             DataInputStream dis = new DataInputStream(s.getInputStream());
             FileOutputStream fos = new FileOutputStream(recurso)
        ) {
            ps.println("GET /" + recurso+ " HTTP/1.1");
            byte [] buff = new byte[1024];
            int leidos;
            while((leidos=dis.read(buff))!=-1){
                for(byte b: buff){
                    System.out.println(b);
                }
//                fos.write(buff,0,leidos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
