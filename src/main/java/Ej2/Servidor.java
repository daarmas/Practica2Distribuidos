package Ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
     public static AgendaTfno at;
    public static void main(String[] args) {
        try(ServerSocket sv = new ServerSocket(55555)){
            Socket s;
            BufferedWriter bw;
            BufferedReader br;
            String leido, leidos[];
            at = new AgendaTfno();
            while(true){
                s=sv.accept();
                bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                leido=br.readLine();
                leidos=leido.split(" ");
                if(leidos[0].equalsIgnoreCase("get")){
                    if(at.contieneNombre(leidos[1])){
                        bw.write(at.getTfno(leidos[1])+"\r\n");
                    }
                }else if(leidos[0].equalsIgnoreCase("put")){
                    at.añadeTelefono(leidos[1], leidos[2]);
                }else bw.write("Error\r\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
