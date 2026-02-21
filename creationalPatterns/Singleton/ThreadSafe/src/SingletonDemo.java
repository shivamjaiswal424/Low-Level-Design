public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Testing Singleton");
        DBConnectionThreadSafe threadSafe1=DBConnectionThreadSafe.getInstance();
        DBConnectionThreadSafe threadSafe2=DBConnectionThreadSafe.getInstance();
        threadSafe1.displaymessage();
        threadSafe2.displaymessage();
        System.out.println("Same instance ? " + (threadSafe1==threadSafe2));

    }
}