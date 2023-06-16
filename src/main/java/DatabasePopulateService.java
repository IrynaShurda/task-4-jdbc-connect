import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String populateDb = "sql/populate_db.sql";

            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(populateDb))
            );

            Database instance = Database.getInstance();
            instance.executeUpdate(sql);

            System.out.println("sql = " + sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}