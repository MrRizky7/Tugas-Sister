/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pkg3_kasir;

/**
 *
 * @author rizky
 */

import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Server {
     public static void main(String[] args) throws IOException {
        Socket s;
        ServerSocket ss;
        String barang = "";
        double totalbayar=0.0;
        double sebelumDiskon=0.0; 
        double diskon =0.0;
        
        try {
        ss = new ServerSocket(212);
        //System.out.println("Server Siap...");
        s = ss.accept();
       // System.out.println("Ada Client....");
        
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
    
        int nomorPilihanUser = dis.readInt(); //membaca input
        int jumlahBarangUser = dis.readInt();
        
        if(nomorPilihanUser > 5){
            System.out.println("Barang tidak ada"+nomorPilihanUser);
        }else {
          
        switch (nomorPilihanUser) {
            case 1:
                //dos.writeInt(jumlah);
                barang = "Beras";
                sebelumDiskon = (float) (50000.0 * jumlahBarangUser );
                //totalbayar = (float) (50000.0 * jumlahBarangUser * 0.1 );
                diskon =(float) (sebelumDiskon * 0.1);
                totalbayar = (float) (sebelumDiskon - diskon);
                dos.writeUTF("Beras"); //Input String
                dos.writeInt(jumlahBarangUser); //Input int
                dos.writeFloat((float) sebelumDiskon); //Input Float
                dos.writeFloat((float) diskon);
                dos.writeFloat((float) totalbayar);
                break;
            case 2:
                //dos.writeInt(jumlah);
                barang = "Minyak Goreng";
                sebelumDiskon = (float) (30000.0 * jumlahBarangUser );
                //totalbayar = (float) (50000.0 * jumlahBarangUser * 0.1 );
                diskon =(float) (sebelumDiskon * 0.1);
                totalbayar = (float) (sebelumDiskon - diskon);
                dos.writeUTF("Minyak Goreng"); //Input String
                dos.writeInt(jumlahBarangUser); //Input int
                dos.writeFloat((float) sebelumDiskon); //Input Float
                dos.writeFloat((float) diskon);
                dos.writeFloat((float) totalbayar);
                break;
            case 3:
                //dos.writeInt(jumlah);
                barang = "Sabun Mandi";
                sebelumDiskon = (float) (25000.0 * jumlahBarangUser );
                //totalbayar = (float) (50000.0 * jumlahBarangUser * 0.1 );
                diskon =(float) (sebelumDiskon * 0.07);
                totalbayar = (float) (sebelumDiskon - diskon);
                dos.writeUTF("Sabun Mandi");
                dos.writeInt(jumlahBarangUser);
                dos.writeFloat((float) sebelumDiskon);
                dos.writeFloat((float) diskon);
                dos.writeFloat((float) totalbayar);
                break;
            case 4:
                //dos.writeInt(jumlah);
                barang = "Telur";
                sebelumDiskon = (float) (28000.0 * jumlahBarangUser );
                //totalbayar = (float) (50000.0 * jumlahBarangUser * 0.1 );
                diskon =(float) (sebelumDiskon * 0.06);
                totalbayar = (float) (sebelumDiskon - diskon);
                dos.writeUTF("Telur");
                dos.writeInt(jumlahBarangUser);
                dos.writeFloat((float) sebelumDiskon);
                dos.writeFloat((float) diskon);
                dos.writeFloat((float) totalbayar);
                break;
            case 5:
                //dos.writeInt(jumlah);
                barang = "Sabun cuci";
                sebelumDiskon = (float) (35000.0 * jumlahBarangUser );
                //totalbayar = (float) (50000.0 * jumlahBarangUser * 0.1 );
                diskon =(float) (sebelumDiskon * 0.08);
                totalbayar = (float) (sebelumDiskon - diskon);
                dos.writeUTF("Sabun cuci");
                dos.writeInt(jumlahBarangUser);
                dos.writeFloat((float) sebelumDiskon);
                dos.writeFloat((float) diskon);
                dos.writeFloat((float) totalbayar);
                break;
            //default:
             //   System.out.println("Barang Tidak Ada");
               // break;
        }
        
        System.out.println("============Invoice============");
        System.out.println(" Barang yang dibeli: " + barang );
        System.out.println(" Jumlah Barang     : " + jumlahBarangUser );
        System.out.println(" Harga             : Rp" + sebelumDiskon);
        System.out.println(" Diskon            : Rp" + diskon);
        System.out.println(" Harga Bayar       : Rp" + totalbayar);

        dis.close();
        dos.close();
        s.close();
        }
        }catch (IOException e){
        
        }
    }
}
    
         
                    