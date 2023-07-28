package TUGAS;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */

public class INPUTAN {

    private String judul;
    private String sutradara;
    private String aktor;
    private String label;
    private int tahun;

    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    Scanner input5 = new Scanner(System.in);
    Scanner inputanuser = new Scanner(System.in);

    /**
     * method untuk mengambil inputan user dan memasukkan ke dalam file.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void inputan() throws Exception {
        TOOLS x = new TOOLS();
        FileWriter fileInput = new FileWriter("Data.txt", true);
        BufferedWriter bufferInput = new BufferedWriter(fileInput);
        boolean cek = false;
        boolean cek2;
        do {
            setJudul();
            setSutradara();
            setAktor();
            setLabel();
            setTahun();

            // cek film ada atau tidak di dalam file
            String[] kata = {judul + "," + sutradara + "," + aktor + "," + label + "," + tahun};
            System.out.println(Arrays.toString(kata));

            boolean isExist = x.cekfilm(kata, false);

            if (!isExist){
                System.out.println("\nData Yang Anda Tambahkan Adalah : ");
                System.out.println("*-------------------------------------------------");
                System.out.println("| Judul Film     |  " + getJudul());
                System.out.println("| Sutradara      |  " + getSutradara());
                System.out.println("| Aktor Utama    |  " + getAktor());
                System.out.println("| Rumah Produksi |  " + getLabel());
                System.out.println("| Tahun Terbit   |  " + getTahun());

                bufferInput.write(judul + "," + sutradara + "," + aktor + "," + label + "," + tahun);
                bufferInput.newLine();
                bufferInput.flush();
            } else {
                System.out.println("\nFilm Sudah Ada Di dalam Database !!!");
                x.cekfilm(kata, true);
                Main.menu();
            }
        do {
            System.out.println("\n---------------------------------------------------");
            System.out.println("| 1 = Ya | 2 = Tidak |");
            System.out.print("Apakah Anda Ingin Input Lagi ? (1/2) : ");
            int pilihan = inputanuser.nextInt();
                if (pilihan == 1) {
                    cek = true;
                    cek2 = false;
                } else if (pilihan == 2) {
                    cek = false;
                    cek2 = false;
                } else {
                    System.out.println("Pilihan Tidak Ada !!!");
                    cek2 = true;
                }
            }while (cek2);
        }while (cek);
        bufferInput.close();
        Main.menu();
    }

    public String getJudul() {
        return judul;
    }
    public String getSutradara(){
        return sutradara;
    }
    public String getAktor() {
        return aktor;
    }
    public String getLabel() {
        return label;
    }
    public int getTahun() {
        return tahun;
    }

    /**
     * Method untuk mengambil value judul dari inputan user
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    public void setJudul() throws Exception {
        try {
            System.out.print("Judul Film  : ");
            judul = input.nextLine();
        }catch (Exception e){
            System.err.println("Judul Tidak Valid !!!");
            Main.menu();
        }
    }

    /**
     * Method untuk mengambil value sutradara dari inputan user
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    public void setSutradara() throws Exception {
        try {
            System.out.print("Sutradara  : ");
            sutradara = input2.nextLine();
        }catch (Exception e){
            System.err.println("Inputan Tidak Valid !!!");
            Main.menu();
        }
    }

    /**
     * Method untuk mengambil value aktor dari inputan user
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    public void setAktor() throws Exception {
        try {
            System.out.print("Aktor Utama : ");
            aktor = input3.nextLine();
        }catch (Exception e){
            System.err.println("Inputan Tidak Valid !!!");
            Main.menu();
        }
    }

    /**
     * Method untuk mengambil value label dari inputan user
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    public void setLabel() throws Exception {
        try {
            System.out.print("Rumah Produksi : ");
            label = input4.nextLine();
        }catch (Exception e){
            System.err.println("Inputan Tidak Valid !!!");
            Main.menu();
        }
    }

    /**
     * Method untuk mengambil value tahun dari inputan user
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    public void setTahun() throws Exception {
        try {
            System.out.print("Tahun Terbit    : ");
            tahun = input5.nextInt();
        }catch (Exception e){
            System.err.println("Tahun Tidak Valid!!!");
            Main.menu();
        }
    }
}
