package in.ag15;

import java.time.Instant;
import java.util.Objects;

import in.ag15.custExceptions.InvalidBlock;

public class BlockHeader {
    long nonce;
    private final long blockHeight;
    // private final long blockDataSize;
    
    /*
     * A hash representation of the block data, different methods can be used to
     * accomplish this such as- 1. a generating a Merkle tree), 2. and storing the
     * root hash 3. or by utilizing a hash of all the combined block data).
     */
    private String prevHeaderHash;
    private final String dataHash;
    private final Instant timestamp;

    public BlockHeader(BlockChain parentChain, long blockHeight, String dataHash) throws InvalidBlock {
        if( blockHeight < parentChain.consensusHeight ){
            System.err.println("Invalid block, chain already has additional blocks, after index " + blockHeight);
            throw new custExceptions.InvalidBlock("Chain already bigger");
        }

        this.blockHeight = blockHeight;
        this.nonce = 0;

        this.timestamp = Instant.now();

        if( parentChain.consensusHeight < 1 ){
            //ie. genesis block not yer added
            this.prevHeaderHash = null;
        }
        else    this.prevHeaderHash = parentChain.getLastBlock().getHeaderHash();
        this.dataHash = dataHash;
    }

    public long getBlockHeight() {
        return blockHeight;
    }
}
