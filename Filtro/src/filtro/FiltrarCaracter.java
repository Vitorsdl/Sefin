package filtro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FiltrarCaracter {
	
	public static void main (String [] args) {
		try {
			/**
			 * Leitura do arquivo;
			 */
			FileInputStream arquivo1 = new FileInputStream ("filtrado.txt");
			InputStreamReader iSR = new InputStreamReader (arquivo1);
			BufferedReader bR = new BufferedReader (iSR);
			/**
			 * Escrita em outro arquivo;
			 */
			FileOutputStream arquivo2 = new FileOutputStream("resultado.txt");
			PrintWriter pW = new PrintWriter (arquivo2);

			String linha;
			System.out.println("Executando");//Inicio da execucao;
			do {
				linha = bR.readLine();
				if (linha != null) {
					String[] palavras = linha.split("-");
					for (int i = 0; i < palavras.length; i++) {
						if (i == 0) {
							char[] n = palavras[i].toCharArray();
							for (int j = 0; j < n.length; j++) {
								if (n[j] != 'A' && n[j] != 'B' && n[j] != 'C' && n[j] != 'D' && n[j] != 'E' && n[j] != 'F' && n[j] != 'G' && n[j] != 'H' && 
										n[j] != 'I' && n[j] != 'J' && n[j] != 'K' && n[j] != 'L' && n[j] != 'M' && n[j] != 'N' && n[j] != 'O' && n[j] != 'P' && 
										n[j] != 'Q' && n[j] != 'R' && n[j] != 'S' && n[j] != 'T' && n[j] != 'U' && n[j] != 'V' && n[j] != 'W' && n[j] != 'X' &&
										n[j] != 'Y' && n[j] != 'Z' && n[j] != ' ' && n[j] != '.' && n[j] != '&' && n[j] != '/' && n[j] != '0' && n[j] != '1' && n[j] != '2' && 
										n[j] != '3' && n[j] != '4' && n[j] != '5' && n[j] != '6' && n[j] != '7' && n[j] != '8' && n[j] != '9' && n[j] != '(' && n[j] != ')' &&
										n[j] != '_' && n[j] != ','){
									pW.println(palavras[0] + " - " + palavras[1]);
								}
							}
						}
					}
				}
			} while (linha != null);
			iSR.close();
			arquivo1.close();
			pW.close();
			arquivo2.close();
			System.out.println("Terminou!");//Conclusao da execucao;
		}
		catch(Exception e) {
			System.out.println("Erro ao ler o arquivo!");	
		}
	}
}
//" ”
