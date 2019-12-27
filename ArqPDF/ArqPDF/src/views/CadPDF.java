package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

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
	private JTextField textLocalArq;
	private JTextField textSalvarLocal;

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
		setBounds(100, 100, 534, 377);
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
		lblNome.setBounds(169, 36, 87, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(169, 58, 244, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		
		JLabel lblDataHora = new JLabel();
		Date data = new Date();
		lblDataHora.setText("Data/Hora: Mon Dec 23 09:01:30 BRT 2019");
		//GregorianCalendar gc = new java.util.GregorianCalendar();
        //gc.add(Calendar.MINUTE,1);
		lblDataHora.setBounds(20, 198, 236, 14);
		contentPane.add(lblDataHora);
		
		JLabel lblLocalArq = new JLabel("Local do arquivo:");
		lblLocalArq.setBounds(20, 93, 99, 14);
		contentPane.add(lblLocalArq);
		
		textLocalArq = new JTextField();		
		textLocalArq.setBounds(124, 90, 289, 20);		
		contentPane.add(textLocalArq);
		textLocalArq.setColumns(10);
		
		JLabel lblSalvarLocal = new JLabel("Salvar em: ");
		lblSalvarLocal.setBounds(20, 124, 63, 14);
		contentPane.add(lblSalvarLocal);
		
		textSalvarLocal = new JTextField();
		textSalvarLocal.setBounds(84, 121, 289, 20);
		contentPane.add(textSalvarLocal);
		textSalvarLocal.setColumns(10);
				
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser file = new JFileChooser();
				file.setDialogTitle("Procurar arquivo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
				file.setFileFilter(filter);
				int retorno = file.showOpenDialog(file);
				
				if(retorno == JFileChooser.APPROVE_OPTION) {
					
					File arq = file.getSelectedFile();
					textLocalArq.setText(arq.getPath());
					textLocalArq.setEnabled(false);
				}
			}
		});
		btnSelect.setBounds(433, 89, 85, 23);
		contentPane.add(btnSelect);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(222, 268, 106, 38);
		contentPane.add(btnSalvar);
		
		JButton button = new JButton("Select");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser destino = new JFileChooser();
				destino.setDialogTitle("Selecione local");				
				destino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retorn = destino.showOpenDialog(destino);
				
				if(retorn == JFileChooser.APPROVE_OPTION) {
					File ende = destino.getSelectedFile();
					textSalvarLocal.setText(ende.getPath());
					textSalvarLocal.setEnabled(false);
				}				
			}
		});
		button.setBounds(397, 121, 87, 23);
		contentPane.add(button);
		
	}
}
