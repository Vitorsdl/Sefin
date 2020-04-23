package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.conexaoBd;
import model.bean.pdf;
import views.Consulta;


public class pdfDAO {

	private Connection con = null;
	private String resultado;

	public pdfDAO() {

		con = conexaoBd.getConnection();
	}

	public boolean save(pdf pdf){

		String sql = "INSERT INTO pdf (numr_inscricao, nome_arquivo, data, diretorio) values (?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pdf.getNumr_inscricao());
			stmt.setString(2, pdf.getNome_arquivo());
			stmt.setString(3, pdf.getData());
			stmt.setString(4, pdf.getDiretorio());
			stmt.executeUpdate();
			return true;			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
			return false;
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}

	}
	
	public String buscaNome(Consulta consulta) {
		
		String sql = "Select diretorio from dbo.pdf where nome_arquivo = ?";
		
		pdf p = new pdf();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, consulta.getTexto());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				p.setDiretorio(rs.getString("diretorio"));
			}
			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}
		
		resultado = p.getDiretorio();
		return resultado;
	}
	
	public String buscNumero(Consulta consulta) {
		
		String sql = "Select diretorio from dbo.pdf where numr_inscricao = ?";
		
		pdf p = new pdf();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, consulta.getTexto());
			rs = stmt.executeQuery();
			
			while(rs.next()) {				
				p.setDiretorio(rs.getString("diretorio"));
			}
			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}
		
		resultado = p.getDiretorio();
		return resultado;
	}

}
