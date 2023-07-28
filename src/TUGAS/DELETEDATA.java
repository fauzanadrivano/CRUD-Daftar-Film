package TUGAS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */
public class DELETEDATA {

    Scanner inputanuser = new Scanner(System.in);
    boolean cek;

    //Modifikasi versiku
    List<ModelData> filmList = new ArrayList<>();

    /**
     * Method untuk menghapus isi dari file.
     *
     * @throws IOException membaca error dalam method dan melemparnya ke
     * exception.
     */
    void delete() throws IOException, Exception {
        SHOWDATA x = new SHOWDATA();
        Scanner input = new Scanner(System.in);
        File Data = new File("Data.txt");
        FileReader fileInput = new FileReader(Data);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        File tempData = new File("tempData.txt");
        FileWriter fileOutput = new FileWriter(tempData);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        x.tampil();
        System.out.print("Pilih Nomor Film Yang Ingin Dihapus : ");
        int pilihan = input.nextInt();

        boolean ada = false;
        int hitung = 1;
        String data = bufferInput.readLine();

        boolean hapus = false;

        while (data != null) {

            StringTokenizer Token = new StringTokenizer(data, ",");

            if (hitung == pilihan) {
                String judul = Token.nextToken();
                String sutradara = Token.nextToken();
                String aktor = Token.nextToken();
                String rumah = Token.nextToken();
                String tahun = Token.nextToken();

                System.out.println("Film Yang Dihapus Adalah : ");
                System.out.println("*---------------------------------------------------");
                System.out.println("| Judul Film     |  " + judul);
                System.out.println("| Sutradara      |  " + sutradara);
                System.out.println("| Aktor Utama    |  " + aktor);
                System.out.println("| Rumah Produksi |  " + rumah);
                System.out.println("| Tahun Terbit   |  " + tahun);
                System.out.println("*---------------------------------------------------");
                hapus = true;
                ada = true;
                //System.out.println("Restart Program Untuk Memperbarui Data !");

                //Modifikasi versiku
                ModelData md = new ModelData();
                md.setJudul(judul);
                md.setSutradara(sutradara);
                md.setAktor(aktor);
                md.setRumah(rumah);
                md.setTahun(tahun);
                filmList.add(md);
            } else {
                //Modifikasi versiku
                ModelData md = new ModelData();
                md.setJudul(Token.nextToken());
                md.setSutradara(Token.nextToken());
                md.setAktor(Token.nextToken());
                md.setRumah(Token.nextToken());
                md.setTahun(Token.nextToken());
                filmList.add(md);
            }

            data = bufferInput.readLine();
            hitung++;
        }

        if (hapus) {
            filmList.remove(pilihan - 1);
            Data.delete();

            String filePath = "Data.txt";
            String result = fileToString(filePath);
            result = result.replaceAll("\\bTutorialspoint\\b", "");
            PrintWriter writer = new PrintWriter(new File(filePath));
            writer.append("");
            writer.flush();

            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;

            for (int i = 0; i < filmList.size(); i++) {
                try {
                    fw = new FileWriter("Data.txt", true);
                    bw = new BufferedWriter(fw);
                    pw = new PrintWriter(bw);
                    pw.println(filmList.get(i).getJudul()+","+filmList.get(i).getSutradara()+","+filmList.get(i).getAktor()+","+filmList.get(i).getRumah()+","+filmList.get(i).getTahun());
                    pw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Film Berhasil Dihapus ");
        } else {
            bufferedOutput.write(data);
            bufferedOutput.newLine();
        }

        if (!ada) {
            System.err.println("Film Tidak Ditemukan !!!");
        }
        bufferedOutput.flush();
        Data.delete();
        tempData.renameTo(Data);

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
        } while (cek);
    }

    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }

    class ModelData {

        private String judul, sutradara, aktor, rumah, tahun;

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getSutradara() {
            return sutradara;
        }

        public void setSutradara(String sutradara) {
            this.sutradara = sutradara;
        }

        public String getAktor() {
            return aktor;
        }

        public void setAktor(String aktor) {
            this.aktor = aktor;
        }

        public String getRumah() {
            return rumah;
        }

        public void setRumah(String rumah) {
            this.rumah = rumah;
        }

        public String getTahun() {
            return tahun;
        }

        public void setTahun(String tahun) {
            this.tahun = tahun;
        }
    }
}
