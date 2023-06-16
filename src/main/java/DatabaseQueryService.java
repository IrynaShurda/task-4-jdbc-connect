import model.LongestProject;
import model.MaxProjectClient;
import model.MaxSalaryWorker;
import model.ProjectPrices;
import model.YoungestEldestWorkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static final String SQL_PRINT_PROJECT_PRICES_SQL = "sql/print_project_prices.sql";
    public static final String SQL_FIND_MAX_PROJECTS_CLIENT_SQL = "sql/find_max_projects_client.sql";
    public static final String SQL_FIND_LONGEST_PROJECT_SQL = "sql/find_longest_project.sql";
    public static final String SQL_FIND_MAX_SALARY_WORKER_SQL = "sql/find_max_salary_worker.sql";
    public static final String SQL_FIND_YOUNGEST_ELDEST_WORKERS_SQL = "sql/find_youngest_eldest_workers.sql";

    static Database instance = Database.getInstance();

    public static void main(String[] args) throws SQLException, IOException {
        List<MaxProjectClient> maxProjectsClient = new DatabaseQueryService().findMaxProjectsClient();
        maxProjectsClient.stream().forEach(System.out::println);

        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        longestProjects.stream().forEach(System.out::println);

        List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        maxSalaryWorker.stream().forEach(System.out::println);

        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        youngestEldestWorkers.stream().forEach(System.out::println);

        List<ProjectPrices> projectPrices = new DatabaseQueryService().findProjectPrices();
        projectPrices.stream().forEach(System.out::println);

        instance.closeConnection();
    }

    List<MaxProjectClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectClient> maxProjectClientList = new ArrayList<>();
        String sql = readFile(SQL_FIND_MAX_PROJECTS_CLIENT_SQL);

        try (Statement statement = instance.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");

                MaxProjectClient maxProjectClient = new MaxProjectClient(name, projectCount);
                maxProjectClientList.add(maxProjectClient);
            }
        }
        return maxProjectClientList;
    }

    List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> findLongestProjectList = new ArrayList<>();
        String sql = readFile(SQL_FIND_LONGEST_PROJECT_SQL);

        try (Statement statement = instance.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int monthCount = resultSet.getInt("MONTH_COUNT");

                LongestProject longestProject = new LongestProject(name, monthCount);
                findLongestProjectList.add(longestProject);
            }
        }
        return findLongestProjectList;
    }

    List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> findMaxSalaryWorkerList = new ArrayList<>();
        String sql = readFile(SQL_FIND_MAX_SALARY_WORKER_SQL);

        try (Statement statement = instance.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salaryCount = resultSet.getInt("SALARY");

                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name, salaryCount);
                findMaxSalaryWorkerList.add(maxSalaryWorker);
            }
        }
        return findMaxSalaryWorkerList;
    }

    List<YoungestEldestWorkers> findYoungestEldestWorkers() throws IOException, SQLException {
        List<YoungestEldestWorkers> findYoungestEldestWorkersList = new ArrayList<>();
        String sql = readFile(SQL_FIND_YOUNGEST_ELDEST_WORKERS_SQL);

        try (Statement statement = instance.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(type, name, birthday);
                findYoungestEldestWorkersList.add(youngestEldestWorkers);
            }
        }
        return findYoungestEldestWorkersList;
    }

    List<ProjectPrices> findProjectPrices() throws IOException, SQLException {
        List<ProjectPrices> findProjectPricesList = new ArrayList<>();
        String sql = readFile(SQL_PRINT_PROJECT_PRICES_SQL);

        try (Statement statement = instance.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectPrice = resultSet.getInt("PRISE");

                ProjectPrices projectPrices = new ProjectPrices(name, projectPrice);
                findProjectPricesList.add(projectPrices);
            }
        }
        return findProjectPricesList;
    }

    private static String readFile(String sqlQuery) throws IOException {
        return String.join(
                "\n",
                Files.readAllLines(Paths.get(sqlQuery))
        );
    }
}