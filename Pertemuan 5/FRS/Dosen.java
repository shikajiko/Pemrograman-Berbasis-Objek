import java.util.ArrayList;

public class Dosen
{
    private String nip;
    private String nama;
    private ArrayList<Matkul> mengampu;

    public Dosen(String nip, String nama)
    {
        this.nip = nip;
        this.nama = nama;
        this.mengampu = new ArrayList<Matkul>();
    }

    public String getNIP(){
        return this.nip;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void addMatkul(Matkul matkul){
        if(!mengampu.contains(matkul)){
            mengampu.add(matkul);
        }    
    }
    
    public ArrayList<Matkul> getAllMatkul(){
        return mengampu;
    }
    
    public String getDosen(){
        return "Dosen[ " + nama + " - " + nip + "]";
    }
}