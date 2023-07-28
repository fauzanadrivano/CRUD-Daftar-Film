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

public class UPDATEDATA {
    Scanner inputanuser = new Scanner(System.in);
    boolean cek;

    /**
     * Method untuk mengupdate isi dari file.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void update() throws Exception {
        TOOLS z = new TOOLS();
        SHOWDATA x = new SHOWDATA();
        Scanner input = new Scanner(System.in);
        Scanner judulbaru = new Scanner(System.in);
        String judulbaru2;

        File Data = new File("Data.txt");
        FileReader fileInput = new FileReader(Data);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempData = new File("tempData.txt");
        FileWriter fileOutput = new FileWriter(tempData);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        x.tampil();
        System.out.print("Pilih Nomor Film Yang Ingin Diupdate : ");
        int pilihan = input.nextInt();

        String data = bufferInput.readLine();
        int hitung = 0;
        boolean ada = false;

        while (data != null){
            hitung++;
            StringTokenizer Token = new StringTokenizer(data, ",");

            if(pilihan == hitung){
                System.out.println("Film Yang Akan Diupdate Adalah : ");
                System.out.println("*---------------------------------------------------");
                System.out.println("| Judul Film     |  " + Token.nextToken());
                System.out.println("| Sutradara      |  " + Token.nextToken());
                System.out.println("| Aktor Utama    |  " + Token.nextToken());
                System.out.println("| Rumah Produksi |  " + Token.nextToken());
                System.out.println("| Tahun Terbit   |  " + Token.nextToken());
                System.out.println("*---------------------------------------------------");

                String[] isidata = {"Judul","Sutradara","Aktor","Label","Tahun"};
                String[] datasementara = new String[5];

                for(int i = 0; i < isidata.length; i++){
                    if (isidata[i].equalsIgnoreCase("Judul")){
                        System.out.print("Masukkan Judul Baru : ");
                        judulbaru2 = judulbaru.nextLine();
                        datasementara[i] = judulbaru2;
                    } else {
                        input = new Scanner(System.in);
                        System.out.print("Masukan " + isidata[i] + " Baru: ");
                        datasementara[i] = input.nextLine();
                    }
                }

                Token = new StringTokenizer(data, ",");
                System.out.println("Data Film Yang Baru Adalah : ");
                System.out.println("*----------------------------------------------------------------");
                System.out.println("| Judul Film     |  " + Token.nextToken() + " ==> " + datasementara[0]);
                System.out.println("| Sutradara      |  " + Token.nextToken() + " ==> " + datasementara[1]);
                System.out.println("| Aktor Utama    |  " + Token.nextToken() + " ==> " + datasementara[2]);
                System.out.println("| Rumah Produksi |  " + Token.nextToken() + " ==> " + datasementara[3]);
                System.out.println("| Tahun Terbit   |  " + Token.nextToken() + " ==> " + datasementara[4]);
                System.out.println("*----------------------------------------------------------------");
                boolean sudahada = z.cekfilm(datasementara, false);

                if(sudahada){
                    System.out.println("\nFilm Sudah Ada Di dalam Database !!!");
                    bufferedOutput.write(data);
                }else {
                  String judul = datasementara[0];
                  String sutradara = datasementara[1];
                  String aktor = datasementara[2];
                  String label = datasementara[3];
                  String tahun = datasementara[4];

                  bufferedOutput.write(judul + "," + sutradara + "," + aktor + "," + label + "," + tahun );
                    System.out.println("Restart Program Untuk Memperbarui Data !");
                    ada = true;
                }
            }else {
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();
            data = bufferInput.readLine();
        }
        if (!ada){
            System.out.println("Pilihan Tidak Ada !!!");
        }
        bufferedOutput.flush();

        do {
            System.out.println("\n---------------------------------------------------");
            System.out.println("| 1 = Ya | 2 = Tidak |");
            System.out.print("Apakah Anda Ingin Keluar ? (1/2) : ");
            int pilihan2 = inputanuser.nextInt();
            if (pilihan2 == 1) {
                System.exit(0);
            } else if (pilihan2 == 2) {
                Main.menu();
            } else {
                System.out.println("Pilihan Tidak Ada !!!");
                cek = true;
            }
        }while (cek);
    }
}
