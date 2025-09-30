import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private ArrayList<Matkul> daftarMK = new ArrayList<Matkul>();
    private ArrayList<Dosen> daftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> daftarMhs = new ArrayList<Mahasiswa>();
    private Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        Main app = new Main();
        app.dummySeeder();   
        app.run();  
    }
    
    public void run() {
        int pilihan;
        do {
            System.out.println("\n== PENGAMBILAN MATA KULIAH MAHASISWA ==\n");
            System.out.println("1. Daftar Mahasiswa\n");
            System.out.println("2. Daftar Mata Kuliah\n");
            System.out.println("3. Daftar Dosen\n");
            System.out.println("4. Ambil MK\n");
            System.out.println("5. Drop MK\n");
            System.out.println("6. Tampilkan FRS Mahasiswa\n");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanMahasiswa();
                case 2 -> tampilkanMataKuliah();
                case 3 -> tampilkanDosen();
                case 4 -> ambilMKInteraktif();
                case 5 -> dropMKInteraktif();
                case 6 -> tampilkanKRSInteraktif();
                case 0 -> System.out.println("Keluar...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
    
    private void dummySeeder() {
        Dosen d1 = new Dosen("D001", "Dr. Andi, S.Kom., M.Kom.");
        Dosen d2 = new Dosen("D002", "Prof. Rina, S.T., M.T., Ph.D.");
        Dosen d3 = new Dosen("D003", "Agus, S.Kom., M.Sc.");
        Dosen d4 = new Dosen("D004", "Dr. Maya, S.Kom., M.T.I.");
        Dosen d5 = new Dosen("D005", "Prof. Hendra, S.T., M.Eng., Ph.D.");

        daftarDosen.add(d2);
        daftarDosen.add(d3);
        daftarDosen.add(d4);
        daftarDosen.add(d5);

        Matkul mk1 = new Matkul("EF111101", "Algoritma dan Struktur Data", 4, 70);
        Matkul mk2 = new Matkul("EF111102", "Basis Data", 3, 65);
        Matkul mk3 = new Matkul("EF111103", "Kecerdasan Buatan", 3, 60);
        Matkul mk4 = new Matkul("EF111104", "Sistem Informasi", 2, 50);
        Matkul mk5 = new Matkul("EF111105", "Grafika Komputer", 3, 75);
        Matkul mk6 = new Matkul("EF111106", "Keamanan Informasi", 4, 80);

        mk1.setDosenPengampuMK(d1);
        mk2.setDosenPengampuMK(d2);
        mk3.setDosenPengampuMK(d3);
        mk4.setDosenPengampuMK(d5);
        mk5.setDosenPengampuMK(d4);
        mk6.setDosenPengampuMK(d2);
        
        daftarMK.add(mk1);
        daftarMK.add(mk2);
        daftarMK.add(mk3);
        daftarMK.add(mk4);
        daftarMK.add(mk5);
        daftarMK.add(mk6);

        Mahasiswa m1 = new Mahasiswa("M001", "Adam");
        Mahasiswa m2 = new Mahasiswa("M002", "Hawa");
        daftarMhs.add(m1);
        daftarMhs.add(m2);
    }
    
    private void tampilkanMahasiswa() {
        int i = 1;
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa m : daftarMhs) {
            System.out.println(i++ + " - " + m.getMahasiswa());
        }
    }
    
    private void tampilkanDosen() {
        int i = 1;
        System.out.println("\nDaftar Dosen:");
        for (Dosen d : daftarDosen) {
            System.out.println(i++ + " - " + d.getDosen());
        }
    }
    
    private void tampilkanMataKuliah() {
        int i = 1;
        System.out.println("\nDaftar Mata Kuliah:");
        for (Matkul mk : daftarMK) {
            System.out.println(i++ + " - " + mk.getMatkul());
        }
    }

    private void ambilMKInteraktif() {
        tampilkanMahasiswa();
        System.out.print("Pilih Mahasiswa: ");
        int idxMhs = sc.nextInt() - 1;
        sc.nextLine();

        if (idxMhs < 0 || idxMhs >= daftarMhs.size()) {
            System.out.println("Mahasiswa tidak valid!");
            return;
        }

        tampilkanMataKuliah();
        System.out.print("Pilih Mata Kuliah: ");
        int idxMK = sc.nextInt() - 1;
        sc.nextLine();

        if (idxMK < 0 || idxMK >= daftarMK.size()) {
            System.out.println("Mata kuliah tidak valid!");
            return;
        }

        Mahasiswa m = daftarMhs.get(idxMhs);
        Matkul mk = daftarMK.get(idxMK);

        if (m.ambilMK(mk)) {
            System.out.println(m.getNama() + " berhasil ambil " + mk.getNamaMK());
        } else {
            System.out.println("Gagal ambil MK. Mungkin sudah penuh atau sudah diambil.");
        }
    }
    
    private void dropMKInteraktif() {
        tampilkanMahasiswa();
        System.out.print("Pilih Mahasiswa: ");
        int idxMhs = sc.nextInt() - 1;
        sc.nextLine();

        if (idxMhs < 0 || idxMhs >= daftarMhs.size()) {
            System.out.println("Mahasiswa tidak valid!");
            return;
        }

        Mahasiswa m = daftarMhs.get(idxMhs);
        ArrayList<Matkul> list = m.getAllMK();

        if (list.isEmpty()) {
            System.out.println("Mahasiswa ini belum ambil MK.");
            return;
        }

        System.out.println("MK yang diambil:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getNamaMK());
        }
        System.out.print("Pilih MK untuk drop: ");
        int idxDrop = sc.nextInt() - 1;
        sc.nextLine();

        if (idxDrop < 0 || idxDrop >= list.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Matkul mk = list.get(idxDrop);
        if (m.dropMK(mk)) {
            System.out.println(m.getNama() + " berhasil drop " + mk.getNamaMK());
        }
    }

    private void tampilkanKRSInteraktif() {
        tampilkanMahasiswa();
        System.out.print("Pilih Mahasiswa: ");
        int idxMhs = sc.nextInt() - 1;
        sc.nextLine();

        if (idxMhs < 0 || idxMhs >= daftarMhs.size()) {
            System.out.println("Mahasiswa tidak valid!");
            return;
        }

        Mahasiswa m = daftarMhs.get(idxMhs);
        System.out.println("KRS " + m.getNama() + ":");
        for (Matkul mk : m.getAllMK()) {
            System.out.println(" - " + mk.getKodeMK() + " " + mk.getNamaMK());
        }
    }
}