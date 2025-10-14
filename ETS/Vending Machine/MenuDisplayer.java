import java.util.ArrayList;

public class MenuDisplayer
{
    private ArrayList menuList = new ArrayList();

    public MenuDisplayer() {
        menuList.add("Energy Drink");
        menuList.add("Soda");
        menuList.add("Lemonade");
        menuList.add("Air Putih");
    }

    public void DisplayMenuAndSize(){
        System.out.println("Selamat Datang di Monster Machine");
        System.out.println("Masukkan angka untuk memilih item: ");
        System.out.println("1. Energy Drink --- 8K");
        System.out.println("2. Soda --- 10K");
        System.out.println("3. Lemonade --- 10K");
        System.out.println("4. Air Putih --- 6K");
        System.out.println("5. Keluar");
    }

    public String GetMenuFromIndex(int index){
        return menuList.get(index-1).toString();
    }

    public void DisplayTotalPrice(String drink, int totalPrice){
        System.out.println("Pesanan anda adalah " + drink);
        System.out.println("Dengan total harga: " + totalPrice);
        System.out.println("Masukkan pembayaran yang sesuai");
    }


}
