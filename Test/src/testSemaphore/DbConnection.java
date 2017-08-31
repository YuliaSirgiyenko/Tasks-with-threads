package testSemaphore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    private static Connection con = null;
    private static String username = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mydb";

    public Connection connection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Загружаем драйвер
        con = DriverManager.getConnection(URL, username, password); //соединяемся
        if (con != null) {
            //System.out.println("Connection Successful !\n");
        }
        if (con == null) {
            System.out.println("Mistake during connection \n");
            System.exit(0);
        }
        
        /*Examples: creation of table in DB.
        Statement st = con.createStatement();
        int res = st.executeUpdate("create TABLE ExamResults (id int, mark int)");

        Cleaning of data in table.
        int res = st.executeUpdate("delete from ExamResults");
        */
        
        return con;
    }

}
