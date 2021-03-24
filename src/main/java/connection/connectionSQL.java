package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionSQL {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/sopaletras";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private Connection connection;
    private Properties properties;
    

   
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
        
        }
        return properties;
    }

  
    public Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
