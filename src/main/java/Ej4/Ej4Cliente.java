package Ej4;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Ej4Cliente {
    public static void main(String[] args) {

    }

    public static void enviaArchivo2Partes(String archivo){
        try (Socket cliente = new Socket("localhost", 55555);
             PrintStream ps = new PrintStream(cliente.getOutputStream();
             FileInputStream fis = new FileInputStream(archivo)
        ) {
            File f = new File(archivo);
            if(f.isFile()){
                long bytesTotales=f.length();
                ps.println("Nombre: "+ f.getName());
                ps.println("Tamaño: "+bytesTotales;
                byte[] buff = new byte[1];
                int leidos;
                leidos=fis.read(buff);
                for(int i=0; i<bytesTotales/2; i++){
                    leidos=fis.read(buff);

                }
//                while(bytesLeidos==2*bytesTotales){
//                    bytesLeidos+=leidos;
//                    leidos=fis.read();
//                }
                ps.println("He mandado la mitad");
                while((leidos=fis.read())!=-1){

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
