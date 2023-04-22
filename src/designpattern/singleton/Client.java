package designpattern.singleton;

public class Client {
    public static void main(String[] args) {
        DBConnection conn1 = DBConnection.getInstance();
        DBConnection conn2 = DBConnection.getInstance();
    }
}
