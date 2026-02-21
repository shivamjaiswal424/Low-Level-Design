public class DBConnectionLazy {
    private static DBConnectionLazy instance =null;
    private DBConnectionLazy() {

    }
    public static DBConnectionLazy getInstance() {
        if (instance == null) {
            instance=new DBConnectionLazy();
        }
        return instance;
    }
    public void displaymessage(){
        System.out.println("Lazy Initialization - singleton - "+ instance);
    }
}
