package TUGAS;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */
public class TOOLS {

    /**
     * @param kata untuk menampung value dari inputan user / kata kunci dari user.
     * @param tampil untuk menampilkan judul tampilan.
     * @return an boolean (cekfilm)
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    boolean cekfilm(String[] kata, boolean tampil) throws IOException {
        FileReader fileInput = new FileReader("Data.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        String data = bufferInput.readLine();
        boolean isExist = false;

        if (tampil){
            System.out.println("\n=================== DAFTAR FILM ===================");
        }
        while (data != null){
            isExist = true;
            for(String keyword : kata){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            if (isExist){
                if (tampil){
                    StringTokenizer Token = new StringTokenizer(data, ",");
                    System.out.println("*---------------------------------------------------");
                    System.out.println("| Judul Film     |  " + Token.nextToken());
                    System.out.println("| Sutradara      |  " + Token.nextToken());
                    System.out.println("| Aktor Utama    |  " + Token.nextToken());
                    System.out.println("| Rumah Produksi |  " + Token.nextToken());
                    System.out.println("| Tahun Terbit   |  " + Token.nextToken());
                    System.out.println("*---------------------------------------------------");
                } else {
                    break;
                }
            }
            data = bufferInput.readLine();
        }
        return isExist;
    }

    /**
     * Method untuk menghapus file lama dan merename file baru.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void pembaruandata() throws Exception {
        File x = new File("Data.txt");
        x.delete();
        File y = new File("tempData.txt");
        y.renameTo(x);
        System.out.println("Data Sudah Berhasil Diperbarui ");
        Main.menu();
    }

    /**
     * Method untuk menghapus seluruh isi file.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void reset() throws Exception {
        PrintWriter pw = new PrintWriter("Data.txt");
        pw.close();
        System.out.println("Data Berhasil Di Reset");
        Main.menu();
    }

    /**
     * Method untuk melakukan perulangan.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void perulangan() throws Exception {
        Scanner inputanuser = new Scanner(System.in);
        boolean cek = false;
        do {
            System.out.println("\n---------------------------------------------------");
            System.out.println("| 1 = Ya | 2 = Tidak |");
            System.out.print("Apakah Anda Ingin Keluar ? (1/2) : ");
            int pilihan = inputanuser.nextInt();
            if (pilihan == 1) {
                System.exit(0);
            } else if (pilihan == 2) {
                Main.menu();
            } else {
                System.out.println("Pilihan Tidak Ada !!!");
                cek = true;
            }
        }while (cek);
    }
}
