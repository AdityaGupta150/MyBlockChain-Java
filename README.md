Trial Uses
----

* Add these lines to the end of main function ->

    ```java
  ArrayList<TransactionInfo> pendingTransactions = new ArrayList<TransactionInfo>();
    pendingTransactions.add(new TransactionInfo("Adi", "Adg", 0.0005));
    pendingTransactions.add(new TransactionInfo("J", "AdG", 0.00405));
    pendingTransactions.add(new TransactionInfo("Adi", "unknown", 0.006));

    try {

        chain.addBlock(new Block(chain, 1, pendingTransactions));

    } catch (InvalidBlock | CloneNotSupportedException e) {

        System.err.println(e);

        e.printStackTrace();

    }

    chain.dispChain();
  ```

  * This will give this output ->

    ```sh
    Genesis Block
    Block 1
     From: Adg  To: Adi -> 5.0E-4 Rs
     From: AdG  To: J -> 0.00405 Rs
     From: unknown  To: Adi -> 0.006 Rs
    ```
