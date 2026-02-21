public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Testing Singleton");
        DBConnectionDoubleCheckLockFix doubleLocking1=DBConnectionDoubleCheckLockFix.getInstance();
        DBConnectionDoubleCheckLockFix doubleLocking2=DBConnectionDoubleCheckLockFix.getInstance();
        doubleLocking1.displaymessage();
        doubleLocking2.displaymessage();
        System.out.println("Same instance ? " + (doubleLocking1==doubleLocking2));

    }
}