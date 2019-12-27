package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textNum;
	private JTextField textNom;
	private JTextField textDat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(24, 21, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 70, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(24, 95, 54, 14);
		contentPane.add(lblNumero);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(24, 120, 46, 14);
		contentPane.add(lblData);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(234, 20, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnAbrir = new JButton("Abrir arquivo");
		btnAbrir.setBounds(120, 145, 120, 32);
		contentPane.add(btnAbrir);
		
		textNum = new JTextField();
		textNum.setEditable(false);
		textNum.setBounds(75, 92, 89, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setBounds(62, 67, 164, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textDat = new JTextField();
		textDat.setEditable(false);
		textDat.setBounds(55, 117, 86, 20);
		contentPane.add(textDat);
		textDat.setColumns(10);
	}
}
