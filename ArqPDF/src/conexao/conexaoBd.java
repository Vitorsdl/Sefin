package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexaoBd {
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.Driver ";//com.microsoft.sqlserver.jdbc.SQLServerDriver
	private static final String URL = "jdbc:microsoft:sqlserver://10.52.0.144:1433;databaseName=DW_SEFIN"; //ati.goiania.go.gov.br
	private static final String USER = "m1415425";
	private static final String PASS = "8218";
	//String usuario = "hsegura_gerente";
	//String senha = "123456";
	//private static final String url = "jdbc:sqlserver://10.52.0.144:1433;databaseName=DW_SEFIN" +";user=" + USER + ";password=" + PASS + ";";
	public static Connection getConnection() {
		System.out.print("oie");
		try {
			Class.forName(DRIVER);			
			return DriverManager.getConnection(URL, USER, PASS);
			
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
