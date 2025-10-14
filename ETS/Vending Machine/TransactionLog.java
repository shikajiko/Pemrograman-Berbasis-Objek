import java.util.ArrayList;

public class TransactionLog
{
    public ArrayList transactionLog;

    public TransactionLog() {
        transactionLog = new ArrayList();
    }

    public void AddTransactionLog(String log){
        transactionLog.add(log);
    }

    public void DisplayLog(){
        int logLength = transactionLog.size();
        for(int i=0; i<logLength; i++){
            System.out.println(transactionLog.get(i).toString());
        }
    }


    
}