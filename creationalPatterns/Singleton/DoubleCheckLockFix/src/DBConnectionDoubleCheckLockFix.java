public class DBConnectionDoubleCheckLockFix {
    private static volatile DBConnectionDoubleCheckLockFix instance = null;
    int portNumber ;
    private DBConnectionDoubleCheckLockFix(int portNumber) {
        this.portNumber = portNumber;
    }
    public static DBConnectionDoubleCheckLockFix getInstance() {
        if (instance == null) {
            synchronized (DBConnectionDoubleCheckLockFix.class) {
                if (instance == null) {
                    instance = new DBConnectionDoubleCheckLockFix(8080);
                }
            }
        }
        return instance;
    }
    public void displaymessage(){
        System.out.println("Double Check Lock fix Thread Safe Initialization - singleton - "+ instance);
    }

}
