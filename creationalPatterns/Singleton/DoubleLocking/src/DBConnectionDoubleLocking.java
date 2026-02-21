public class DBConnectionDoubleLocking {

    public static DBConnectionDoubleLocking instance=null;
    private DBConnectionDoubleLocking(){}
    public static DBConnectionDoubleLocking getInstance(){
        if(instance==null){
            synchronized (DBConnectionDoubleLocking.class){
                if(instance==null){
                    instance=new DBConnectionDoubleLocking();
                }
            }
        }
        return instance;
    }
    public void displaymessage(){
        System.out.println("Double Locking Thread Safe Initialization - singleton - "+ instance);
    }
}
