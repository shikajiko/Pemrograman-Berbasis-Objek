import java.util.*;

public class TransactionHandler
{
    public HashMap<String, Integer> priceList;

    public TransactionHandler() 
    {
        priceList = new HashMap<String, Integer>();
        priceList.put("Energy Drink", 8000);
        priceList.put("Soda", 10000);
        priceList.put("Lemonade", 10000);
        priceList.put("Air Putih", 6000);
    }

    public int GetPriceFromName(String name){
        return priceList.get(name);
    }
    
    public int VerifyPayment(int paidAmount, int totalPrice){
        if(paidAmount < totalPrice){
            System.out.println("Saldo tidak cukup!");
            return 0;
        }
        else{
            System.out.println("Ambil pesanan anda!");
            return 1;
        }
    }

    
}