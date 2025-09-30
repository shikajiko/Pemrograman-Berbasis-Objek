import java.util.ArrayList;
public class Mahasiswa
{
    private String nrp;
    private String nama;
    private ArrayList<Matkul> enrolledMK;
   
    public Mahasiswa(String nrp, String nama)
    {
        this.nrp = nrp;
        this.nama = nama;
        this.enrolledMK = new ArrayList<Matkul>();
    }
 
    public String getNRP() { return nrp; }
    public String getNama() { return nama; }
    
    public boolean ambilMK(Matkul mk){
        if(mk == null || enrolledMK.contains(mk)) return false;
        boolean added = mk.addPeserta(this);
        
        if(added) {
            enrolledMK.add(mk);
            return true;
        }
        
        return false;
    }
    
    public boolean dropMK(Matkul mk) {
        if(mk == null || !enrolledMK.contains(mk)) return false;
        
        boolean removed = mk.removePeserta(this);
        
        if(removed) {
            enrolledMK.remove(mk);
            return true;
        }
        
        return false;
    }
    
    public ArrayList<Matkul> getAllMK() {
        return enrolledMK;
    }
    
    public String getMahasiswa() {
        return "Mahasiswa[ " + nama + " - " + nrp + " ]";
    }
}