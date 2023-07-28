package TUGAS;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Hafiz
 * @author Fauzan
 * @author Nadia
 * @version 2021 1.2
 */
public class Main {
    public static void main(String[] args) throws Exception {
        menu();
    }

    /**
     * Method untuk menampilkan tampilan seluruh menu yang ada.
     * @throws IOException membaca error dalam method dan melemparnya ke exception.
     */
    static void menu() throws Exception {
        Scanner input = new Scanner(System.in);
        INPUTAN a = new INPUTAN();
        SHOWDATA b = new SHOWDATA();
        SEARCHDATA c = new SEARCHDATA();
        DELETEDATA d = new DELETEDATA();
        UPDATEDATA x = new UPDATEDATA();
        TOOLS e = new TOOLS();
        boolean cek = false;
        int pilihan;
        System.out.println("\n\n*===================== WELCOME ========================*");
        System.out.println("|                                                      |");
        System.out.println("| 1. Input Film                                        |");
        System.out.println("| 2. Tampilkan Seluruh Daftar Film                     |");
        System.out.println("| 3. Cari Film                                         |");
        System.out.println("| 4. Update Film                                       |");
        System.out.println("| 5. Hapus Film                                        |");
        System.out.println("| 6. Reset Seluruh Data                                |");
        System.out.println("| 7. Perbarui Data                                     |");
        System.out.println("| 8. Keluar                                            |");
        System.out.println("|                                                      |");
        System.out.println("*======================================================*");
        do {
            System.out.print("| Masukkan Pilihan Anda : ");
            pilihan = input.nextInt();
            if (pilihan == 1) {
                a.inputan();
            } else if (pilihan == 2) {
                b.tampil();
                e.perulangan();
            } else if (pilihan == 3) {
                c.search();
            } else if (pilihan == 4) {
                x.update();
            } else if (pilihan == 5) {
                d.delete();
            }  else if (pilihan == 6) {
                e.reset();
            } else if (pilihan == 7) {
                e.pembaruandata();
            }else if (pilihan == 8) {
                System.exit(0);
            }else {
                System.out.println("| Maaf Pilihan Tidak Ada !!!");
                cek = true;
            }
        }while (cek);
    }
}
