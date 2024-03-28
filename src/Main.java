import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/firm";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM employees WHERE employee_salary > 40000");
            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("employee_id"));
                System.out.println("Name: " + resultSet.getString("employee_name"));
                System.out.println("Position: " + resultSet.getString("employee_position"));
                System.out.println("Salary: " + resultSet.getInt("employee_salary"));
                System.out.println("--------------------------------------------");
            }
        }catch (SQLException e){
            e.getMessage();
        }
    }
}