package Ej2;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
     public static AgendaTfno at;
    public static void main(String[] args) {
        try(ServerSocket sv = new ServerSocket(55555);
                Socket s = sv.accept()){
            BufferedWriter bw;
            BufferedReader br;
            String leido, leidos[];
            at = new AgendaTfno();
            while(true){
//                bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintStream p = new PrintStream(s.getOutputStream());
                DataInputStream dis = new DataInputStream(s.getInputStream());
                leido=dis.readLine();
                leidos=leido.split(" ");
                if(leidos[0].equalsIgnoreCase("get")){
                    if(at.contieneNombre(leidos[1])){
                        p.println(at.getTfno(leidos[1]));
                    }
                    else p.println("Desconocido");
                }else if(leidos[0].equalsIgnoreCase("put")){
                    at.añadeTelefono(leidos[1], leidos[2]);
                    p.println("OK");
                }else p.println("Error");
                p.flush();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
