//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("Testing Singleton");
        DBConnectionEager eager1=DBConnectionEager.getInstance();
        DBConnectionEager eager2=DBConnectionEager.getInstance();
        eager1.displaymessage();
        eager2.displaymessage();


    }
}