package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB연결객체를 자기자신이 리턴하는 클래스
public class MakeConnection {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER ="scott";
	private static final String PASSWORD = "tiger";
	
	
	static Connection conn = null;
	
	private static MakeConnection mc;
	
	private MakeConnection() {};
	
	public static MakeConnection getInstance() {
		if(mc == null)mc = new MakeConnection();
		return mc;
	}
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			conn =  DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
	}
}
