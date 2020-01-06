package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.bean.pdf;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CadPDF extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPDF frame = new CadPDF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadPDF() {
		super("Cadastro PDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblDadosPdf = new JLabel("Dados PDF");
		lblDadosPdf.setBounds(10, 11, 87, 14);
		contentPane.add(lblDadosPdf);
		lblDadosPdf.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textNumero = new JTextField();
		textNumero.setText("Numero de inscrição");
		textNumero.setBounds(20, 52, 211, 20);		
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		textNome = new JTextField();
		textNome.setText("Nome arquivo");
		textNome.setBounds(20, 104, 211, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		
		JLabel lblDataHora = new JLabel();
		Date data = new Date();
		DateFormat formatoData = new SimpleDateFormat("dd-MM-yy");
		lblDataHora.setText("Data: " + formatoData.format(data.getTime()));
		GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.MINUTE,1);
		lblDataHora.setBounds(347, 12, 87, 14);
		contentPane.add(lblDataHora);
				
		JButton btnArq = new JButton("selecionar arquivo");
		btnArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser file = new JFileChooser();
				file.setDialogTitle("Procurar arquivo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
				file.setFileFilter(filter);
				file.setAcceptAllFileFilterUsed(false);
				int retorno = file.showOpenDialog(file);
				
				if(retorno == JFileChooser.APPROVE_OPTION) {
					
					File arq = file.getSelectedFile();
					textArq.setText(arq.getPath());
					textArq.setEnabled(false);
				}
			}
		});
		btnArq.setBounds(274, 51, 138, 23);
		contentPane.add(btnArq);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*pdf p = new pdf();
				
				p.setNumeroinc(Integer.parseInt(textNumero.getText()));
				p.setNomeaqr(textNome.getText());
				p.setData(new java.sql.Date(lblDataHora.getTime()));*/
				
				
				/*textNome.setBorder(BorderFactory.createLineBorder(Color.RED));
				
				if(textNumero.getText().trim().equals("")){
					
					
				}elsif( textNome.getText().trim().equals("")){
					
					
				}else {
					
					
				}*/
				
			}
		});
		btnSalvar.setBounds(306, 165, 106, 38);
		contentPane.add(btnSalvar);
		
		JButton btnDiretorio = new JButton("selecionar diretorio");
		btnDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser destino = new JFileChooser();
				destino.setDialogTitle("Selecione local");				
				destino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retorn = destino.showOpenDialog(destino);
				
				if(retorn == JFileChooser.APPROVE_OPTION) {
					File ende = destino.getSelectedFile();
					textDiretorio.setText(ende.getPath());
					textDiretorio.setEnabled(false);
				}				
			}
		});
		btnDiretorio.setBounds(274, 103, 138, 23);
		contentPane.add(btnDiretorio);
		
	}
}
