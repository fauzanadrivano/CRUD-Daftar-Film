package TUGAS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */

public class SEARCHDATA {
    TOOLS x = new TOOLS();
    FileReader fileOutput;
    BufferedReader bufferOutput;
    Scanner inputanuser = new Scanner(System.in);
    boolean cek;

    /**
     * Method untuk mencari inputan user di dalam file.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void search() throws Exception {
        try {
            fileOutput = new FileReader("Data.txt");
            bufferOutput = new BufferedReader(fileOutput);
        }catch (Exception e){
            System.err.println("File Tidak Ditemukan !!!");
            System.err.println("Silahkan Buat File Terlebih Dahulu !!!");
            Main.menu();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Kata Kunci : ");
        String carikata = input.nextLine();
        String[] kata = carikata.split("\\s+"); // split untuk mencari kata kunci di dalam file dengan inputan menggunakan spasi
        System.out.println("Film Yang Cocok Dengan Kata Kunci : ");
        x.cekfilm(kata, true);
        do {
            System.out.println("\n----------------------------------------------------");
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
