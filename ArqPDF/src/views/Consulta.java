package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.pdfDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private JTextField textNum;
	private JTextField textNom;
	private JTextField textDat;
	private String lc;
	public String texto;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}




	/**
	 * Create the frame.
	 */

	public Consulta() {
		super("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 70, 46, 14);
		contentPane.add(lblNome);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(24, 95, 54, 14);
		contentPane.add(lblNumero);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(24, 120, 46, 14);
		contentPane.add(lblData);

		textBusca = new JTextField();
		textBusca.setBounds(24, 24, 189, 20);
		contentPane.add(textBusca);
		textBusca.setColumns(10);

		textNum = new JTextField();
		textNum.setEnabled(false);
		textNum.setBounds(75, 92, 89, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);

		textNom = new JTextField();
		textNom.setEnabled(false);
		textNom.setBounds(62, 67, 164, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);

		textDat = new JTextField();
		textDat.setEnabled(false);
		textDat.setBounds(55, 117, 86, 20);
		contentPane.add(textDat);
		textDat.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean arqui = false;
				String dir = "C:\\Users\\m1416685\\Desktop\\pdfs";
				File file = new File(dir);
				if (file.exists() && file.isDirectory()) {
					System.out.println("entrou");
					
					texto = textBusca.getText();
					for(int i = 0; i < texto.length(); i++) {
						
						if(Character.isDigit(texto.charAt(i))==true) {
							
							Consulta com = new Consulta();
							com.setTexto(textBusca.getText());
							
							pdfDAO dao = new pdfDAO();
							
							if(dao.buscNumero(com)) {JOptionPane.showMessageDialog(null, "Achado com sucesso.");
							dispose();
							}else {JOptionPane.showMessageDialog(null, "Erro ao buscar."); dispose();}
							
							//JOptionPane.showMessageDialog(null, "Possui numeros");s
							break;
						}else {
							
							Consulta com = new Consulta();
							com.setTexto(textBusca.getText());
							
							pdfDAO dao = new pdfDAO();
							
							if(dao.buscaNome(com)) {JOptionPane.showMessageDialog(null, "Achado com sucesso.");
							dispose();
							}else {JOptionPane.showMessageDialog(null, "Erro ao buscar."); dispose();}
							
						}
							
					}
					
				}
			}
		});
		btnConsultar.setBounds(241, 23, 89, 23);
		contentPane.add(btnConsultar);

		JButton btnAbrir = new JButton("Abrir arquivo");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// abre o arquivo encontrado na busca
				try {
					java.awt.Desktop.getDesktop().open(new File(lc));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAbrir.setBounds(120, 145, 120, 32);
		contentPane.add(btnAbrir);
	}
}
