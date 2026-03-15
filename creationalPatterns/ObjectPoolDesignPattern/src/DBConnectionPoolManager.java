import java.util.ArrayList;
import java.util.List;


public class DBConnectionPoolManager {
    private static DBConnectionPoolManager dbConnectionPoolManagerInstance = null;
    List<DBConnection> freeConnections = new ArrayList<>();
    List<DBConnection> usedConnections = new ArrayList<>();
    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;

    private DBConnectionPoolManager(){
        for(int i = 0; i < INITIAL_POOL_SIZE; i++){
            freeConnections.add(new DBConnection());
        }
    }
    public static DBConnectionPoolManager getInstance(){
        if(dbConnectionPoolManagerInstance == null){
            synchronized (DBConnectionPoolManager.class){
                if(dbConnectionPoolManagerInstance == null){
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }

        }
        return dbConnectionPoolManagerInstance;
    }
    public synchronized DBConnection getDBConnection(){
        DBConnection dbConnection = null;
        if(freeConnections.isEmpty() && usedConnections.size() < MAX_POOL_SIZE){
            freeConnections.add(new DBConnection());
            System.out.println("New DBConnection created and added to freeConnections list.");
            System.out.println("freeConnections size: " + freeConnections.size());
            System.out.println("inUseConnections size: " + usedConnections.size());
        }
        else if (freeConnections.isEmpty() && usedConnections.size() >= MAX_POOL_SIZE){
            System.out.println("Pool is full. Cannot create new DBConnection.");
            return null;

        }
        dbConnection = freeConnections.remove(freeConnections.size() - 1);
        usedConnections.add(dbConnection);
        System.out.println("DBConnection retrieved from freeConnections list and added to inUseConnections list.");
        System.out.println("freeConnections size: " + freeConnections.size());
        System.out.println("inUseConnections size: " + usedConnections.size());
        return dbConnection;

    }
    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if (dbConnection != null) {
            usedConnections.remove(dbConnection);
            freeConnections.add(dbConnection);
            System.out.println("DBConnection released from inUseConnections list and added to freeConnections list.");
            System.out.println("freeConnections size: " + freeConnections.size());
            System.out.println("inUseConnections size: " + usedConnections.size());
        } else {
            System.out.println("DBConnection is null. Cannot release.");
        }
    }

}
