package designpattern.singleton;

public class DBConnection {
    private static DBConnection instance;
    private DBConnection() {
        System.out.println("Initializing instance");
    }

    public static DBConnection getInstance() {
        if (DBConnection.instance == null) {
            DBConnection.instance = new DBConnection();
        }
        return DBConnection.instance;
    }
}
