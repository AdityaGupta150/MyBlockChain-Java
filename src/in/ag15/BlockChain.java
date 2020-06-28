package in.ag15;

import java.util.ArrayList;

public class BlockChain {
    public int consensusHeight = 0;

    final private ArrayList<Block> chain;
    public void addBlock(Block b){
        this.chain.add(b);

        ++ this.consensusHeight;        
    }
    public void dispChain(){
        for (Block block : chain) {
            block.printData();
        }
    }
    BlockChain() throws custExceptions.InvalidBlock, CloneNotSupportedException {
        this.chain = new ArrayList<>();
        this.chain.add(new Block(this, 0, null));  //Adding genesis

        this.consensusHeight = 1;
    }
	final Block getLastBlock() {
        if ( !this.chain.isEmpty() )
            return this.chain.get(consensusHeight-1);
        return null;
    }
}
