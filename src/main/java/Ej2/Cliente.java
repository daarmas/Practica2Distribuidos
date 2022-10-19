package Ej2;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Cliente {
    public static void main(String[] args) {
        String envio, leido;
        try(Socket s = new Socket("localhost", 55555);
                //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                //BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()))
                ) {
            PrintStream p = new PrintStream(s.getOutputStream());
            DataInputStream dis= new DataInputStream(s.getInputStream());
            while(true){
                envio= (new Scanner(System.in)).nextLine();
                p.println(envio);
                p.flush();
                leido=dis.readLine();
                System.out.println(leido);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
