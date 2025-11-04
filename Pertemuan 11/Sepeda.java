public class Sepeda extends Kendaraan
{
    private String jenisSepeda;

    public Sepeda(String merk, String model, String tahunProduksi, String jenisSepeda){
        super(merk, model, tahunProduksi);
        this.jenisSepeda = jenisSepeda;
    }

    @Override
    public void showDetail(){
        System.out.println("Sepeda ");
        super.showDetail();
        System.out.println("Jenis Sepeda " + jenisSepeda);
    }
}
