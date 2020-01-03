package model.dao;

import conexao.conexaoBd;
import model.bean.pdf;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class pdfDAO {
	
	private conexaoBd con = null;
	
	public pdfDAO() {
		
		con = conexaoBd.getConnection();
	}
	
	public boolean save(pdf pdf){
		
				
		PreparedStatement stmt = null;
		
		 stmt = con.
	}

}
