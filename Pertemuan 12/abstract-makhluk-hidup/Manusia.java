public class Manusia extends MakhlukHidup {
    private String jumlahKaki;
    
    public Manusia(String jumlahKaki){
        this.jumlahKaki = jumlahKaki;
    }
    public void berdiri (){
        System.out.println("Manusia berdiri menggunakan : " + jumlahKaki);
    }
}