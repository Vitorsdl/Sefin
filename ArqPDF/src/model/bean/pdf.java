package model.bean;

import java.util.Date;

public class pdf {

	private int numr_inscricao;
	private String nome_arquivo;
	private String data;
	private Date data_atualizada;
	private String diretorio;

	public int getNumr_inscricao() {
		return numr_inscricao;
	}
	public void setNumr_inscricao(int numr_inscricao) {
		this.numr_inscricao = numr_inscricao;
	}
	public String getNome_arquivo() {
		return nome_arquivo;
	}
	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Date getData_atualizada() {
		return data_atualizada;
	}
	public void setData_atualizada(Date data_atualizada) {
		this.data_atualizada = data_atualizada;
	}
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}



}
