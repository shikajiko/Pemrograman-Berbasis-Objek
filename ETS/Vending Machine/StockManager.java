
public class StockManager
{
    public int energyDrink;
    public int soda;
    public int lemonade;
    public int water;

    public StockManager() 
    {
        energyDrink = 3;
        soda = 3;
        lemonade = 1;
        water = 2;
    }

    
    public int getStock(String name){
        switch (name) {
            case "Energy Drink":
                return energyDrink;
            case "Soda":
                return soda;
            case "Lemonade":
                return lemonade;
            case "Air Putih":
                return water;
        }
        return -1;
    }

    public void DecreaseStock(String name){
        switch (name) {
            case "Energy Drink":
                --energyDrink;
                break;
            case "Soda":
                --soda;
                break;
            case "Lemonade":
                --lemonade;
                break;
            case "Air Putih":
                --water;
                break;
        }
    }

    public void ReportEmpty(){
        if(energyDrink < 1){
            System.out.println("==== Energy Drink Habis! ===");
        }
        if(soda < 1){
            System.out.println("==== Soda Habis! ===");
        }
        if(lemonade < 1){
            System.out.println("==== Lemonade Habis! ===");
        }
        if(water < 1){
            System.out.println("==== Air Putih Habis! ===");
        }
    }
}