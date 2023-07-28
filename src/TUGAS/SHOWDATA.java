package TUGAS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */

public class SHOWDATA {
    FileReader fileOutput;
    BufferedReader bufferOutput;

    /**
     * Method untuk menampilkan isi dari file.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    void tampil() throws IOException {
        try {
            fileOutput = new FileReader("Data.txt");
            bufferOutput = new BufferedReader(fileOutput);
        }catch (Exception e){
            System.err.println("File Tidak Ditemukan !!!");
            System.err.println("Silahkan Buat File Terlebih Dahulu !!!");
            System.exit(0);
        }

        String data = bufferOutput.readLine(); // mengisikan isi file ke dalam object data.

        int urutan = 1;

        try {
            System.out.println("\n================= DAFTAR FILM =====================");
            while (data != null) {
                StringTokenizer Token = new StringTokenizer(data, ",");
                System.out.println("*------------------>>> "+urutan+" <<<-----------------------");
                System.out.println("| Judul Film     |  " + Token.nextToken());
                System.out.println("| Sutradara      |  " + Token.nextToken());
                System.out.println("| Aktor Utama    |  " + Token.nextToken());
                System.out.println("| Rumah Produksi |  " + Token.nextToken());
                System.out.println("| Tahun Terbit   |  " + Token.nextToken());
                urutan++;
                data = bufferOutput.readLine();
            }
            System.out.println("*---------------------------------------------------");
        }catch (NoSuchElementException e){
            System.err.println("Isi Dari File Tidak Ditemukan !!!");
            System.out.println("Silahkan Cek Terlebih Dahulu Isi File !!!");
        }
    }
}
