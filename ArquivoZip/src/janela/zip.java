package janela;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.text.*;
import java.io.File;
import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class zip {
	FTPClient ftp = new FTPClient();
	private JFrame frame;
	private JTextField txtLogintext;
	private JTextField txtDominiotext;
	private JPasswordField pwdSenhatext;
	private JTextField txtDirarqtext;
	private JTextField txtDirsalarqtext;
	private JTextField txtLogs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zip window = new zip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public zip() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel statusConexaoLabel = new JLabel("Status: OFFILINE");
		statusConexaoLabel.setBounds(180, 11, 106, 24);
		statusConexaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel dominioLabel = new JLabel("Dominio:");
		dominioLabel.setBounds(66, 49, 46, 14);

		JLabel loginLabel = new JLabel("Login: ");
		loginLabel.setBounds(80, 77, 46, 14);

		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setBounds(245, 80, 41, 14);

		JLabel diretorioLabel = new JLabel("Diretorio de Arquivos: ");
		diretorioLabel.setBounds(40, 112, 130, 14);

		JLabel diretorioSalvarArquivosLabel = new JLabel("Diretorio Salvar Arquivo.zip: ");
		diretorioSalvarArquivosLabel.setBounds(10, 143, 160, 14);

		txtLogintext = new JTextField();
		txtLogintext.setText("tempftp");
		txtLogintext.setBounds(123, 77, 117, 20);
		txtLogintext.setColumns(10);

		txtDominiotext = new JTextField();
		txtDominiotext.setBounds(113, 46, 298, 20);
		txtDominiotext.setText("10.52.1.102");
		txtDominiotext.setColumns(10);

		pwdSenhatext = new JPasswordField();
		pwdSenhatext.setEchoChar('*');
		pwdSenhatext.setText("comdata");
		pwdSenhatext.setBounds(289, 77, 122, 20);

		txtDirarqtext = new JTextField();
		txtDirarqtext.setEnabled(false);
		txtDirarqtext.setBounds(169, 109, 314, 20);
		txtDirarqtext.setText("C:\\\\Users\\\\m1415425\\\\Documents\\\\Novapasta");
		txtDirarqtext.setColumns(10);

		txtDirsalarqtext = new JTextField();
		txtDirsalarqtext.setEnabled(false);
		txtDirsalarqtext.setBounds(169, 140, 314, 20);
		txtDirsalarqtext.setText("C:\\\\Users\\\\m1415425\\\\Documents\\\\Zip\\\\Arquivo.zip");
		txtDirsalarqtext.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(statusConexaoLabel);
		frame.getContentPane().add(dominioLabel);
		frame.getContentPane().add(txtDominiotext);
		frame.getContentPane().add(txtLogintext);
		frame.getContentPane().add(loginLabel);
		frame.getContentPane().add(senhaLabel);
		frame.getContentPane().add(pwdSenhatext);
		frame.getContentPane().add(diretorioLabel);
		frame.getContentPane().add(diretorioSalvarArquivosLabel);
		frame.getContentPane().add(txtDirarqtext);
		frame.getContentPane().add(txtDirsalarqtext);
		

		JLabel horarioExecucaoLabel = new JLabel("Horário Execução: --:--:--");
		horarioExecucaoLabel.setBounds(113, 245, 370, 14);
		frame.getContentPane().add(horarioExecucaoLabel);

		JLabel proximaExecucaoLabel = new JLabel("Próxima Execução: --:--:--");
		proximaExecucaoLabel.setBounds(113, 270, 370, 14);
		frame.getContentPane().add(proximaExecucaoLabel);

		JLabel logsLabel = new JLabel("Salvar Logs de Envio:");
		logsLabel.setVerticalAlignment(SwingConstants.TOP);
		logsLabel.setBounds(10, 174, 149, 17);
		frame.getContentPane().add(logsLabel);

		txtLogs = new JTextField();
		txtLogs.setText("C:\\\\Users\\\\m1415425\\\\Documents\\\\Zip\\\\");
		txtLogs.setEnabled(false);
		txtLogs.setBounds(169, 171, 314, 20);
		frame.getContentPane().add(txtLogs);
		txtLogs.setColumns(10);
		
		JTextArea txtArqEnviados = new JTextArea();
		txtArqEnviados.setEditable(false);
		txtArqEnviados.setBounds(113, 374, 314, 199);
		frame.getContentPane().add(txtArqEnviados);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane = new JScrollPane(txtArqEnviados);
		jScrollPane.setBounds(new Rectangle(113, 374, 314, 199)); // tamanho do jScrollPane
		jScrollPane.setVerticalScrollBarPolicy(jScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // só mostra a barra vertical																			// se necessário
		jScrollPane.setHorizontalScrollBarPolicy(jScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // nunca mostra a barra de
																							// rolagem horizontal
		txtArqEnviados.setWrapStyleWord(true);
		txtArqEnviados.setLineWrap(true); // quebra a linha
		txtArqEnviados.getText();
		frame.getContentPane().add(jScrollPane);
		
		JButton enviarBotao = new JButton("Enviar");//Botao Enviar
		enviarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArqEnviados.setText("");
				txtDirarqtext.setEnabled(false);
				txtDirsalarqtext.setEnabled(false);
				txtLogs.setEnabled(false);
				//Declaração de váriaveis necessárias
				Date date = new Date();
                Calendar data = Calendar.getInstance();
                DateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy_HH-mm");
                GregorianCalendar gc = new java.util.GregorianCalendar();
                File arquivoEscrita = new File(txtLogs.getText().toString()+ formatoData.format(data.getTime()) + "_log.txt");
				File arquivos[];
				//{
                File diretorio = new File(txtDirarqtext.getText().toString());
                arquivos = diretorio.listFiles();
                for (File arquivo : arquivos) 
					txtArqEnviados.append(arquivo.getName()+"     "+arquivo.length()+"bytes"+"\n");
                horarioExecucaoLabel.setText("Horário execução: " + date);
                gc.add(Calendar.MINUTE, 15);
				proximaExecucaoLabel.setText("Próxima execução: " + gc.getTime());

                try (FileWriter fileWrite = new FileWriter(arquivoEscrita) //arquivo para escrita
                ) {
                    for (File arquivo : arquivos) {
                        fileWrite.write(arquivo.getName()+"\n");
                    }
                } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		enviarBotao.setEnabled(false);
		enviarBotao.setBounds(180, 329, 122, 23);
		
		JButton desconectarBotao = new JButton("Desconectar");//Botão desconectar
		JButton conectarBotao = new JButton("Conectar");//Botão conectar
		conectarBotao.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (txtDominiotext.getText().trim().equals(""))//Verifica se o campo dominio está vazio
					{
						JOptionPane.showMessageDialog(null, "CAMPO DOMINIO VAZIO!", "ALERTA!",JOptionPane.ERROR_MESSAGE);
						txtDominiotext.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if (txtLogintext.getText().trim().equals(""))//Verifica se o campo login está vazio
					{
						JOptionPane.showMessageDialog(null, "CAMPO LOGIN VAZIO!", "ALERTA!", JOptionPane.ERROR_MESSAGE);
						txtLogintext.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else if (pwdSenhatext.getText().trim().equals(""))//Verifica se o campo senha está vazio
					{
						JOptionPane.showMessageDialog(null, "CAMPO SENHA VAZIO!", "ALERTA!", JOptionPane.ERROR_MESSAGE);
						pwdSenhatext.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					else {
						//realiza a conexão
						ftp.connect(txtDominiotext.getText().toString());
						ftp.login(txtLogintext.getText().toString(), pwdSenhatext.getText().toString());
						//Habilita e desabilita funcionalidades da tela
						JOptionPane.showMessageDialog(null, "SERVIÇO CONECTADO!", "ALERTA!", JOptionPane.ERROR_MESSAGE);
						txtDirarqtext.setEnabled(true);
						txtDirsalarqtext.setEnabled(true);
						txtLogs.setEnabled(true);
						desconectarBotao.setEnabled(true);
						enviarBotao.setEnabled(true);
						txtDominiotext.setEnabled(false);
						txtLogintext.setEnabled(false);
						pwdSenhatext.setEnabled(false);
						conectarBotao.setEnabled(false);
						statusConexaoLabel.setText("Status: ONLINE");
						txtDominiotext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						txtLogintext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						pwdSenhatext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
				} catch (IOException f) {
					JOptionPane.showMessageDialog(null, "SERVIÇO NÃO CONECTADO!", "ALERTA!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		conectarBotao.setBounds(108, 295, 122, 23);
		
		
		desconectarBotao.setEnabled(false);//Botão Desconectar
		desconectarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ftp.logout();
					ftp.disconnect();
					txtDominiotext.setEnabled(true);
					txtLogintext.setEnabled(true);
					pwdSenhatext.setEnabled(true);
					conectarBotao.setEnabled(true);
					txtDirarqtext.setEnabled(false);
					txtDirsalarqtext.setEnabled(false);
					txtLogs.setEnabled(false);
					desconectarBotao.setEnabled(false);
					enviarBotao.setEnabled(false);
					statusConexaoLabel.setText("Status: OFFILINE");
					horarioExecucaoLabel.setText("Horário Execução: --:--:--");
					proximaExecucaoLabel.setText("Próxima Execução: --:--:--");
				} catch (IOException f) {
					JOptionPane.showMessageDialog(null, "SERVIÇO DESCONECTADO!", "ALERTA!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		desconectarBotao.setBounds(247, 295, 122, 23);
		frame.getContentPane().add(conectarBotao);
		frame.getContentPane().add(desconectarBotao);
		frame.getContentPane().add(enviarBotao);
		
		

	}
}
