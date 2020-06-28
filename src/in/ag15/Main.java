package in.ag15;

import in.ag15.custExceptions.InvalidBlock;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		BlockChain chain = null;
		try {
			chain = new BlockChain();
		} catch (InvalidBlock | CloneNotSupportedException invalidBlock) {
			invalidBlock.printStackTrace();
		}
	}
}
