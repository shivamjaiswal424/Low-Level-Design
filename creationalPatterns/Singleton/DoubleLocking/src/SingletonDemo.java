public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Testing Singleton");
        DBConnectionDoubleLocking doubleLocking1=DBConnectionDoubleLocking.getInstance();
        DBConnectionDoubleLocking doubleLocking2=DBConnectionDoubleLocking.getInstance();
        doubleLocking1.displaymessage();
        doubleLocking2.displaymessage();
        System.out.println("Same instance ? " + (doubleLocking1==doubleLocking2));

    }
}