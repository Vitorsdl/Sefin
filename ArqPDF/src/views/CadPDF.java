package views;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.bean.pdf;
import model.dao.pdfDAO;

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
		setBounds(100, 100, 425, 240);
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
		textNumero.setBounds(20, 67, 211, 20);		
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(20, 106, 211, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		
		JLabel lblDataHora = new JLabel();
		Date data = new Date();
		DateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
		lblDataHora.setText("Data: " + formatoData.format(data.getTime()));
		GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.MINUTE,1);
		lblDataHora.setBounds(303, 12, 99, 14);
		contentPane.add(lblDataHora);
				
		JButton btnArq = new JButton("selecionar arquivo");
		btnArq.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnArq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser file = new JFileChooser();
				file.setDialogTitle("Procurar arquivo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf", "png", "jpeg");
				file.setFileFilter(filter);
				file.setMultiSelectionEnabled(true);
				file.setAcceptAllFileFilterUsed(false);
				
				int retorno = file.showOpenDialog(file);
				
				if(retorno == JFileChooser.APPROVE_OPTION) {
					File arq = file.getSelectedFile();
					
					JTextField txtarq = new JTextField();
					txtarq.setText(arq.getPath());
					
					//System.out.println(arq.length());
					File[] files = file.getSelectedFiles();
					System.out.println(files);
					/*
					for(int i=0; files < i; i++){
					
					String nome = arq.getName();
					arq.renameTo(new File("C:\\Users\\m1416685\\Desktop\\pdfs/" + nome);
					}
					
					
					
					
					*/
					//String nome = arq.getName();
													
					//arq.renameTo(new File("C:\\Users\\m1416685\\Desktop\\pdfs/" + nome ));
					
					//System.out.println("movido com sucesso");
					
				}
			}
		});
		btnArq.setBounds(262, 86, 138, 23);
		contentPane.add(btnArq);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				if(textNumero.getText().trim().equals("")){
					textNumero.setBorder(BorderFactory.createLineBorder(Color.RED)); //marca campo errado
					JOptionPane.showMessageDialog(null, "Campo numero vazio!");
					 				
					
				}else if( textNome.getText().trim().equals("")){
					textNome.setBorder(BorderFactory.createLineBorder(Color.RED)); //marca campo errado
					JOptionPane.showMessageDialog(null, "Campo nome vazio!");
					
				}else {							
					
					/*pdf p = new pdf();
					
					p.setNumeroinc(Integer.parseInt(textNumero.getText()));
					p.setNomeaqr(textNome.getText());
					
					pdfDAO dao = new pdfDAO();
					
					if(dao.save(p)) {
						JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao salvar.");
					}*/					
				}				
			}
		});
		btnSalvar.setBounds(303, 172, 87, 30);
		contentPane.add(btnSalvar);		
		
		JLabel lblNDeIncrio = new JLabel("N\u00BA de incri\u00E7\u00E3o");
		lblNDeIncrio.setBounds(20, 51, 87, 14);
		contentPane.add(lblNDeIncrio);
		
		JLabel lblNomeDoArquivo = new JLabel("Nome do arquivo");
		lblNomeDoArquivo.setBounds(20, 90, 99, 14);
		contentPane.add(lblNomeDoArquivo);
		
	}
}
