package model.dao;

import model.bean.pdf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.conexaoBd;


public class pdfDAO {

	private Connection con = null;

	public pdfDAO() {

		con = conexaoBd.getConnection();
	}

	public boolean save(pdf pdf){

		String sql = "INSERT INTO pdf (numr_inscricao, nome_arquivo, data) values (?, ?, ?)";
		System.out.println(sql);

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pdf.getNumr_inscricao());
			stmt.setString(2, pdf.getNome_arquivo());
			stmt.setString(3, pdf.getData());
			stmt.executeUpdate();
			return true;			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
			return false;
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}

	}

}
