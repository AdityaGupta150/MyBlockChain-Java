package in.ag15;

import java.util.List;

import in.ag15.Util.Hasher;
import in.ag15.custExceptions.InvalidBlock;

public class Block {
    private final BlockHeader header;   //contains 'metadata' for the block
    private final BlockData data;
    private String headerHash;

    public String getHeaderHash() {
        return this.headerHash;
    }

    public Block(BlockChain parentChain, long index, List<TransactionInfo> transactions) throws InvalidBlock, CloneNotSupportedException {
        if( transactions != null ) {
            this.data = new BlockData(transactions);
            transactions.clear();
        }else{
            this.data = null;
            if( parentChain.consensusHeight != 0 ) { //Only add null tranactions, as genesis
                throw new InvalidBlock("No transactions in Block");
            }
        }

        assert this.data != null;
        String dataHash = Hasher.getHash(this.data, "SHA-256");
        this.header = new BlockHeader(parentChain, index, dataHash);
    }

    public void printData() {
        if( this.data == null ){
            System.out.println("Genesis Block");
            return;
        }

        System.out.println("Block " + this.header.getBlockHeight());
        for (TransactionInfo info : this.data.getTransactions()) {
            System.out.println("\tFrom: " + info.from + "  To: " + info.to + " -> " + info.amount + " Rs");
        }
    }
}
