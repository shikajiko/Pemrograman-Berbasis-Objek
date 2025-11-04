public class Kendaraan
{
    private String merk;
    private String model;
    private String tahunProduksi;

    public Kendaraan(String merk, String model, String tahunProduksi){
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public void showDetail(){
        System.out.println("Merk: " + merk);
        System.out.println("Model: " + model);
        System.out.println("Tahun Produksi: " + tahunProduksi);
    }


}
