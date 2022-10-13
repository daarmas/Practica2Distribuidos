package Ej1;

import java.net.InetAddress;
import java.text.NumberFormat;
import java.util.Scanner;

public class NsLookUp {
    public static void main(String[] args) {
        ejecuta();
    }

    public static void ejecuta(){
       String s="";
       String sv[];
       try{
           Scanner sc = new Scanner(System.in);
           s=sc.nextLine();
           sv=s.split("\\.");

           if(esIp(sv)){
               InetAddress address = InetAddress.getByName(s);
               System.out.println("El nombre relacionado con la IP "+s+" es: "+address.getHostName());
           }
           else{
               InetAddress [] address = InetAddress.getAllByName(s);
               for(InetAddress ad: address) {
                   System.out.println("La IP relacionada con el nombre " + s + " es: " + ad.getHostAddress());
               }
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    }

    public static boolean esIp(String [] sv){
        try{
            if(sv.length!=4) return false;
            for(String s: sv){
                if(0>Integer.parseInt(s) && Integer.parseInt(s)>255) {
                    return false;
                }
            }
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
