public class TicketMachine
{
    private int balance;
    private int price;
    private int total;
    
    public TicketMachine(int cost){
        price = cost;
        balance = 0;
        total = 0;
    }
    
    public int GetPrice(){
        return price;
    }
    
    public int GetBalance(){
        return balance;
    }
    
    public void InsertMoney(int amount){
        if(amount>0){
            balance = balance + amount;
        }
        else{
            System.out.println("error: uang 0");
        }
    }
    
    public void printTicket(){
        if(balance >= price){
            System.out.println("########################");
            System.out.println("# Kereta Api Indonesia");
            System.out.println("# Tiket");
            System.out.println("# Rp" + price);
            System.out.println("########################");
            
            total = total + price;
            balance = balance - price;
        }
        else{
            System.out.println("Anda harus memasukkan setidaknya: Rp");
            System.out.println(price - balance);
        }    
    }
    
    public int refundBalance(){
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
    