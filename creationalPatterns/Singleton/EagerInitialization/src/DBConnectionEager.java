public class DBConnectionEager {
    private static final DBConnectionEager instance = new DBConnectionEager();
    private DBConnectionEager() {

    }
    public static DBConnectionEager getInstance() {
        return instance;
    }
    public void displaymessage(){
        System.out.println("Eager Initialization - singleton - "+ instance);
    }
}
