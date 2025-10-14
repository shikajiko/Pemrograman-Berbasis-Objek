public class VendingMachine
{
    private MenuDisplayer menuDisplayer = new MenuDisplayer();
    private InputReader inputReader = new InputReader();
    private StockManager stockManager = new StockManager();
    private TransactionHandler transactionHandler = new TransactionHandler();
    private TransactionLog transactionLog = new TransactionLog();
    public int isRunning;
    public void main() {
        isRunning = 1;
        while (isRunning != 0) { 
            vendingMachineLoop();
        }
    }

    public void vendingMachineLoop(){
        stockManager.ReportEmpty();
        menuDisplayer.DisplayMenuAndSize();
        int choosenDrinkIndex = inputReader.readMessage();

        if(choosenDrinkIndex > 4){
            isRunning = 0;
            return;
        }
        System.out.println("");
        String choosenDrink = menuDisplayer.GetMenuFromIndex(choosenDrinkIndex);

        int stock = stockManager.getStock(choosenDrink);

        if(stock < 1){
            System.out.println("Tidak dapat memproses pesanan karena stock habis");
            return;
        }

        int totalPrice = transactionHandler.GetPriceFromName(choosenDrink);

        menuDisplayer.DisplayTotalPrice(choosenDrink, totalPrice);
        int paidAmount = inputReader.readMessage();
        int accepted = transactionHandler.VerifyPayment(paidAmount, totalPrice);
        
        if(accepted == 1){
            String log = choosenDrink + " " + totalPrice;
            transactionLog.AddTransactionLog(log);
            stockManager.DecreaseStock(choosenDrink);
        }
    }

    public void ShowTransactionLog(){
        transactionLog.DisplayLog();
    }

}