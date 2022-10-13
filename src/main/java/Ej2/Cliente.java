package Ej2;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", 55555)
        ){

        }catch(java.io.IOException e){

        }
    }
}
