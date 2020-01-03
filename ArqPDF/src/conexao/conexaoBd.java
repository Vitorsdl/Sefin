package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexaoBd {
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.Driver";
	private static final String URL = "ati.goiania.go.gov.br";
	private static final String USER = "m1333984";
	private static final String PASS = "Candido@21";
	
	public static conexaoBd getConnection() {
		
		try {
			Class.forName(DRIVER);			
			return (conexaoBd) DriverManager.getConnection(URL, USER, PASS);
			
		} catch (ClassNotFoundException | SQLException ex) {
			
			throw new RuntimeException("Erro na conexão", ex);
		}
		
	}
	
	public static void closeConnection(Connection con) {
		
		if(con != null) {
			
			try {
				con.close();
			} catch (SQLException ex) {
				System.err.print("error: " + ex);
			}
		}
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
			
			if(stmt != null) {
				
				try {
					stmt.close();
				} catch (SQLException ex) {
					System.err.print("error: " + ex);
				}
			}			
			
			closeConnection(con);
			
			
		}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		if(rs != null) {
			
			try {
				rs.close();
			} catch (SQLException ex) {
				System.err.print("error: " + ex);
			}
		}
		
		closeConnection(con, stmt);
		
		
	}
	
	

}
