package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class CadPDF extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textNome;
	private JTextField textArq;
	private JTextField textDiretorio;

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
		setBounds(100, 100, 331, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblDadosPdf = new JLabel("Dados PDF");
		lblDadosPdf.setBounds(10, 11, 87, 14);
		contentPane.add(lblDadosPdf);
		lblDadosPdf.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNumero = new JLabel("Numero de inscri\u00E7\u00E3o");
		lblNumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumero.setBounds(20, 40, 119, 14);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(20, 58, 119, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome arquivo");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNome.setBounds(20, 89, 87, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(20, 104, 244, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		
		JLabel lblDataHora = new JLabel();
		Date data = new Date();
		lblDataHora.setText("Data/Hora: " + data);
		GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.MINUTE,1);
		lblDataHora.setBounds(59, 404, 236, 14);
		contentPane.add(lblDataHora);
		
		JLabel lblArq = new JLabel("Arquivo:");
		lblArq.setBounds(20, 146, 63, 14);
		contentPane.add(lblArq);
		
		textArq = new JTextField();		
		textArq.setBounds(20, 171, 289, 20);		
		contentPane.add(textArq);
		textArq.setColumns(10);
		
		JLabel lblSalvarLocal = new JLabel("Salvar em: ");
		lblSalvarLocal.setBounds(20, 251, 63, 14);
		contentPane.add(lblSalvarLocal);
		
		textDiretorio = new JTextField();
		textDiretorio.setBounds(20, 276, 289, 20);
		contentPane.add(textDiretorio);
		textDiretorio.setColumns(10);
				
		JButton btnArq = new JButton("Buscar");
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
		btnArq.setBounds(115, 202, 85, 23);
		contentPane.add(btnArq);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textNumero.getText() != null || textNome.getText() != null ){
					
					JOptionPane.showMessageDialog(null, "Não e permitido campo vazio!");
					
				}else {
					
					JOptionPane.showMessageDialog(null, "ok");
				}
				
			}
		});
		btnSalvar.setBounds(115, 429, 106, 38);
		contentPane.add(btnSalvar);
		
		JButton btnDiretorio = new JButton("Buscar");
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
		btnDiretorio.setBounds(113, 307, 87, 23);
		contentPane.add(btnDiretorio);
		
	}
}
