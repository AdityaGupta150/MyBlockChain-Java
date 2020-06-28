package in.ag15;

import java.util.ArrayList;
import java.util.List;

import in.ag15.custExceptions.InvalidBlock;

public class BlockData {
    private List<TransactionInfo> transactions;

    BlockData(List<TransactionInfo> transactions) throws InvalidBlock, CloneNotSupportedException {
        for (TransactionInfo transaction : transactions) {
            if( !this.verifyTransaction(transaction)){
                System.err.println("Invalid transaction - " + transaction);
                throw new InvalidBlock("Invalid Transaction Provided!");
            }         
        }

        this.transactions = new ArrayList<TransactionInfo>();
        for(TransactionInfo info : transactions){
            this.transactions.add((TransactionInfo) info.clone());
        }
    }

    private boolean verifyTransaction(TransactionInfo transaction) {
        // Check here, whether that user really has the fund
        //! OUT OF ScOPE OF THIS PROJECT
        return true;
    }

    public List<TransactionInfo> getTransactions() {
        return transactions;
    }
}
