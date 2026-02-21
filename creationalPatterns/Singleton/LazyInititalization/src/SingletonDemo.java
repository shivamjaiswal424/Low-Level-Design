public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Testing Singleton");
        DBConnectionLazy lazy1=DBConnectionLazy.getInstance();
        DBConnectionLazy lazy2=DBConnectionLazy.getInstance();
        lazy1.displaymessage();
        lazy2.displaymessage();
        System.out.println("Same instance ? "+(lazy1==lazy2));

    }
}