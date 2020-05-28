package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.bean.pdf;
import model.dao.pdfDAO;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
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
		setBounds(100, 100, 364, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);

		textBusca = new JTextField();
		textBusca.setBounds(24, 24, 189, 20);
		contentPane.add(textBusca);
		textBusca.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dir = "C:\\Users\\m1416685\\Desktop\\pdfs";
				File file = new File(dir);

				if (file.exists() && file.isDirectory()) {

					texto = textBusca.getText();

					pdfDAO dao = new pdfDAO();
					
					//verifica se foi digitado int ou string
					for(int i = 0; i < texto.length(); i++) {

						if(Character.isDigit(texto.charAt(i))==true) {

							Consulta com = new Consulta(); com.setTexto(textBusca.getText());

							if(dao.buscNumero(com) != null) {JOptionPane.showMessageDialog(null,"Achado com sucesso."); 
							lc = dao.getResultado();

							}else {JOptionPane.showMessageDialog(null, "Erro ao buscar.");}
							break; }
						else {Consulta com = new Consulta(); com.setTexto(textBusca.getText());

						if(dao.buscaNome(com) != null) {JOptionPane.showMessageDialog(null,"Achado com sucesso.");
						lc = dao.getResultado();

						}else{JOptionPane.showMessageDialog(null, "Erro ao buscar.");}
						break;
						}
					}
				}
				else {JOptionPane.showMessageDialog(null, "Falha no diretorio.");}
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
					e.printStackTrace();
				}
			}
		});
		btnAbrir.setBounds(122, 81, 120, 32);
		contentPane.add(btnAbrir);
	}
}
