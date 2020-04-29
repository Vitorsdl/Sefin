package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.conexaoBd;
import model.bean.pdf;
import views.Consulta;
import java.util.List;


public class pdfDAO {

	private Connection con = null;
	private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

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
			
		String sql = "Select numr_inscricao, nome_arquivo, data, diretorio from dbo.pdf where nome_arquivo = ?";
		
		pdf p = new pdf();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, consulta.getTexto());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				p.setDiretorio(rs.getString("diretorio"));
//				p.setNome_arquivo(rs.getString("nome_arquivo"));
//				p.setNumr_inscricao(rs.getInt("numr_inscricao"));
//				p.setData(rs.getString("data"));
			}
			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}
		
		resultado = p.getDiretorio();
		return this.resultado;
	}
	
	public String buscNumero(Consulta consulta) {
		
		String sql = "Select numr_inscricao, nome_arquivo, data, diretorio from dbo.pdf where numr_inscricao = ?";
		
		pdf p = new pdf();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, consulta.getTexto());
			rs = stmt.executeQuery();
			
			while(rs.next()) {				
				p.setDiretorio(rs.getString("diretorio"));
//				p.setNome_arquivo(rs.getString("nome_arquivo"));
//				p.setNumr_inscricao(rs.getInt("numr_inscricao"));
//				p.setData(rs.getString("data"));
			}
			
		}catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}finally {
			conexaoBd.closeConnection(con, stmt);
		}
		
		resultado = p.getDiretorio();
		return this.resultado;
	}

}
