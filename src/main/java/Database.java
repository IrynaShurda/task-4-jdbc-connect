import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database INSTANCE;
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./test");
            System.out.println("connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public Connection getConnection() {
        System.out.println("use created connection");
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("connection close");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}