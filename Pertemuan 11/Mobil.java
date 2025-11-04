public class Mobil extends Kendaraan
{
    private int jumlahRoda; 

    public Mobil(String merk, String model, String tahunProduksi, int jumlahRoda){
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public void showDetail(){
        System.out.println("Mobil ");
        super.showDetail();
        System.out.println("Jumlah Roda: " + jumlahRoda);
    }
}
