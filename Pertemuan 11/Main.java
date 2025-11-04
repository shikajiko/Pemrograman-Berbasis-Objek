import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    private ArrayList<Kendaraan> listKendaraan = new ArrayList<>();
    private HashMap<Kendaraan, String> penyewa = new HashMap<>();
    private InputReader inputReader = new InputReader();

    public void Run(){
        while(true){
            showGreetings();
            int input = inputReader.readMessage();
            if(input == 1){
                showList();
            }
            else if(input == 2){
                showPenyewa();
            }
            else{
                return;
            }
        }
    }

    public void addMobil(String merk, String model, String tahunProduksi, int jumlahRoda){
        Mobil mobil = new Mobil(merk, model, tahunProduksi, jumlahRoda);
        listKendaraan.add(mobil);
    }

    public void addMotor(String merk, String model, String tahunProduksi, int jumlahRoda){
        Motor motor = new Motor(merk, model, tahunProduksi, jumlahRoda);
        listKendaraan.add(motor);
    }

    public void addSepeda(String merk, String model, String tahunProduksi, String jenisSepeda){
        Sepeda sepeda = new Sepeda(merk, model, tahunProduksi, jenisSepeda);
        listKendaraan.add(sepeda);
    }

    public void addPenyewa(int index, String namaPenyewa) {
        if (index >= 0 && index < listKendaraan.size()) {
            Kendaraan k = listKendaraan.get(index);
            if (!penyewa.containsKey(k)) {
                penyewa.put(k, namaPenyewa);
                System.out.println("Kendaraa berhasil disewa.");
            } else {
                System.out.println("Gagal: Kendaraan sudah disewa.");
            }
        } else {
            System.out.println("Indeks kendaraan tidak valid.");
        }
    }


    public void showList(){
        System.out.println("=== Kendaraan Tersedia ===");
        for (Kendaraan k : listKendaraan) {
            if (!penyewa.containsKey(k)) { 
                k.showDetail();
                System.out.println("--------------------");
            }
        }
    }
    
    public void showPenyewa() {
        System.out.println("=== Kendaraan Disewa ===");
        for (Kendaraan k : penyewa.keySet()) {
            k.showDetail();
            System.out.println("Disewa oleh: " + penyewa.get(k));
            System.out.println("--------------------");
        }
    }

    public void showGreetings(){
        System.out.println("Selamat datang di aplikasi sewa kendaraan");
        System.out.println("Pilih salah satu: ");
        System.out.println("1. Tampilkan kendaraan yang tersedia");
        System.out.println("2. Tampilkan list penyewa");
        System.out.println("3. Keluar");
    }
}



