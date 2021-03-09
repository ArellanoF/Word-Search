package Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	private static String bd="sopaletras";
	private static String user="root";
	private static String pass="";
	private static String url="jdbc:mysql://127.0.0.1:3306/"+bd;
	
	public Connection getMysqlConnection() {
		
		Connection db = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			db = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Error en la conexion"+e.getMessage());
		}
		return db;
	}
}
