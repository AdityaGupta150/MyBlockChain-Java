package in.ag15;

public class custExceptions {
    static public class InvalidBlock extends Exception{
        private static final long serialVersionUID = 1L;
        InvalidBlock(String cause){
            super(cause);
        }
    }
}
