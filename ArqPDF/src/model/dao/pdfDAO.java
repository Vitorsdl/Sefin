package model.dao;

import java.sql.PreparedStatement;

import conexao.conexaoBd;
import model.bean.pdf;

public class pdfDAO {
	
	private conexaoBd  
	con = null;
	
	public pdfDAO() {
		
		con = conexaoBd.getConnection();
	}
	
	public boolean save(pdf pdf){
		
		String sql = "";
		
		
		PreparedStatement stmt = null;
		 stmt = con.preparedStatement(sql);
		stmt.executeUpdate();
		
	}

}
