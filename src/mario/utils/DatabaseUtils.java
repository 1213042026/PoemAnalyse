package mario.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	public static final String URL = "jdbc:mysql://127.0.0.1/poem?useUnicode=true&characterEncoding=utf-8";
    public static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "root";
  
    public static Connection getCon() {  
    	Connection con = null;
        try {  
            Class.forName(DRIVE_NAME);
            con = DriverManager.getConnection(URL, DB_USER_NAME, DB_PASSWORD); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        
        return con;
    }  
  
    public static void close(Connection con) {  
        try {  
            con.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}
