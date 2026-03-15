import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection mySQLConnection;
    public DBConnection() {
        try{
            mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "root");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
