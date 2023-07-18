/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pkg3_kasir;

/**
 *
 * @author rizky
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket s = null;
        int nomorBarang = 0 ;
        int jumlahBarang = 0 ;
        s = new Socket("127.0.0.1",212 );
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        try{
    
        Scanner input = new Scanner(System.in);    
        System.out.println("List BARANG - BARANG");
        System.out.println("1. Beras");
        System.out.println("2. Minyak Goreng");
        System.out.println("3. Sabun Mandi");
        System.out.println("4. Telur");
        System.out.println("5. Sabun Cuci");
        
        System.out.print("Pilih Barang   : "); 
        nomorBarang = input.nextInt(); // input data user
        
        out.writeInt(nomorBarang); 
        System.out.print("Jumlah Barang  : ");
        jumlahBarang = input.nextInt();
        out.writeInt(jumlahBarang); // output client dikirim ke server sebagai inputan
        
        System.out.println("============Invoice============");
        System.out.println("Barang yang dibeli : " + in.readUTF()); //Baca Inputan 
        System.out.println("Jumlah Barang      : " + in.readInt());
        System.out.println("Harga              : Rp" + in.readFloat());
        System.out.println("Diskon             : Rp" +in.readFloat());
        System.out.println("Harga Bayar        : Rp" + in.readFloat());

        in.close();
        out.close();
        s.close();
        
        } catch (IOException e){
        
        }
    }
    
}