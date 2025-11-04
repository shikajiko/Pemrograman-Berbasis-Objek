public class Motor extends Kendaraan
{
    private int jumlahRoda; 

    public Motor(String merk, String model, String tahunProduksi, int jumlahRoda){
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public void showDetail(){
        System.out.println("Sepeda Motor ");
        super.showDetail();
        System.out.println("Jumlah Roda: " + jumlahRoda);
    }
}
