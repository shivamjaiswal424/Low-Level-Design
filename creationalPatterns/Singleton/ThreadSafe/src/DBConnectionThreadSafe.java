public class DBConnectionThreadSafe {
    private static DBConnectionThreadSafe instance=null;
    private DBConnectionThreadSafe(){

    }
    public static synchronized DBConnectionThreadSafe getInstance(){
        if(instance==null){
            instance=new DBConnectionThreadSafe();
        }
        return instance;
    }
    public void displaymessage(){
        System.out.println("Thread Safe Initialization - singleton - "+ instance);
    }

}
