import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String initDb = "sql/init_db.sql";

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDb))
            );
            Database instance = Database.getInstance();
            instance.executeUpdate(sql);

            System.out.println("sql = " + sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}