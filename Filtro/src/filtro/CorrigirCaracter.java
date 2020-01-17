package filtro;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CorrigirCaracter {
	
	public static void main (String [] args) {
		try {
			/**
			 * Leitura do arquivo;
			 */
			FileInputStream arquivo1 = new FileInputStream ("dados3.txt");
			InputStreamReader iSR = new InputStreamReader (arquivo1);
			BufferedReader bR = new BufferedReader (iSR);
			/**
			 * Escrita em outro arquivo;
			 */
			FileOutputStream arquivo2 = new FileOutputStream("corrigido.txt");
			PrintWriter pW = new PrintWriter (arquivo2);
			
			String linha;
			/**
			 * array a são os caracteres a ser substituido;
			 * array b sao os caracteres para substituir;
			 * seguir a posicao dos dois arrays para adicao de novos caracteres;
			 */
			char[] a = {'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó', 'Ô',
					'Õ', 'Ö', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'à', 'á', 'â', 'ã', 'ä', 'å', 'æ', 'ç', 'è', 'é', 'ê', 'ë', 'ì',
					'í', 'î', 'ï', 'ñ', 'ò', 'ó', 'ô', 'õ', 'ö', 'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'ÿ', 'Ā', 'ā', 'Ă', 'ă', 'Ą', 'ą',
					'Ć', 'ć', 'Ĉ', 'ĉ', 'Ċ', 'ċ', 'Č', 'č', 'Ď', 'ď', 'Đ', 'đ', 'Ē', 'ē', 'Ĕ', 'ĕ', 'Ė', 'ė', 'Ę', 'ę', 'Ě', 'ě',
					'Ĝ', 'ĝ', 'Ğ', 'ğ', 'Ġ', 'ġ', 'Ģ', 'ģ', 'Ĥ', 'ĥ', 'Ħ', 'ħ', 'Ĩ', 'ĩ', 'Ī', 'ī', 'Ĭ', 'ĭ', 'Į', 'į', 'İ', 'ı',
					'Ĳ', 'ĳ', 'Ĵ', 'ĵ', 'Ķ', 'ķ', 'Ĺ', 'ĺ', 'Ļ', 'ļ', 'Ľ', 'ľ', 'Ŀ', 'ŀ', 'Ł', 'ł', 'Ń', 'ń', 'Ņ', 'ņ', 'Ň', 'ň',
					'ŉ', 'Ō', 'ō', 'Ŏ', 'ŏ', 'Ő', 'ő', 'Œ', 'œ', 'Ŕ', 'ŕ', 'Ŗ', 'ŗ', 'Ř', 'ř', 'Ś', 'ś', 'Ŝ', 'ŝ', 'Ş', 'ş', 'Š',
					'š', 'Ţ', 'ţ', 'Ť', 'ť', 'Ŧ', 'ŧ', 'Ũ', 'ũ', 'Ū', 'ū', 'Ŭ', 'ŭ', 'Ů', 'ů', 'Ű', 'ű', 'Ų', 'ų', 'Ŵ', 'ŵ', 'Ŷ', 
					'ŷ', 'Ÿ', 'Ź', 'ź', 'Ż', 'ż', 'Ž', 'ž', 'ſ', 'ƒ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ǎ', 'ǎ', 'Ǐ', 'ǐ', 'Ǒ', 'ǒ', 'Ǔ', 'ǔ',
					'Ǖ', 'ǖ', 'Ǘ', 'ǘ', 'Ǚ', 'ǚ', 'Ǜ', 'ǜ', 'Ǻ', 'ǻ', 'Ǽ', 'ǽ', 'Ǿ', 'ǿ', 'Ά', 'ά', 'Έ', 'έ', 'Ό', 'ό', 'Ώ', 'ώ',
					'Ί', 'ί', 'ϊ', 'ΐ', 'Ύ', 'ύ', 'ϋ', 'ΰ', 'Ή', 'ή', '$', '²', 'ß', 'Ø', 'º', '«', '@', ''};	
			
			String[] b = {"A", "A", "A", "A", "A", "A", "AE", "C", "E", "E", "E", "E", "I", "I", "I", "I", "D", "N", "O", "O", "O",
					"O", "O", "U", "U", "U", "U", "Y", "a", "a", "a", "a", "a", "a", "ae", "c", "e", "e", "e", "e", "i",
					"i", "i", "i", "n", "o", "o", "o", "o", "o", "o", "u", "u", "u", "u", "y", "y", "A", "a", "A", "a", "A", "a",
					"C", "c", "C", "c", "C", "c", "C", "c", "D", "d", "D", "d", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e",
					"G", "g", "G", "g", "G", "g", "G", "g", "H", "h", "H", "h", "I", "i", "I", "i", "I", "i", "I", "i", "I", "i",
					"IJ", "ij", "J", "j", "K", "k", "L", "l", "L", "l", "L", "l", "L", "l", "l", "l", "N", "n", "N", "n", "N", "n",
					"n", "O", "o", "O", "o", "O", "o", "OE", "oe", "R", "r", "R", "r", "R", "r", "S", "s", "S", "s", "S", "s", "S",
					"s", "T", "t", "T", "t", "T", "t", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "W", "w", "Y",
					"y", "Y", "Z", "z", "Z", "z", "Z", "z", "s", "f", "O", "o", "U", "u", "A", "a", "I", "i", "O", "o", "U", "u",
					"U", "u", "U", "u", "U", "u", "U", "u", "A", "a", "AE", "ae", "O", "o", "Α", "α", "Ε", "ε", "Ο", "ο", "Ω", "ω",
					"Ι", "ι", "ι", "ι", "Υ", "υ", "υ", "υ", "Η", "η", "C", "I", "A", "", "C", "C", "A", ""};
			
			System.out.println("Executando");//Inicio da execucao;
			do {
				linha = bR.readLine();
				if (linha != null) {
					String[] palavras = linha.split("\n");
					for (int i = 0; i < palavras.length; i++) {
						char[] n = palavras[i].toCharArray();
						for(int j = 0; j < n.length; j++) {
							boolean ver = true;// verificacao para saber se escreve o caracter original ou alterado;
							for(int k = 0; k < a.length; k++) {
								if(n[j] == a[k]) {
									pW.print(b[k]);
									ver = false;
									break;
								}
							}
							if(ver) {
								pW.print(n[j]);
							}
						}
					}
					pW.println();
				}
			} while (linha != null);
			/**
			 * Fechando arquivos que foram abertos
			 */
			iSR.close();
			pW.close();
			arquivo1.close();
			arquivo2.close();

			System.out.println("Terminou!");//Conclusao da execucao;
		}catch(Exception e) {
			System.out.println("Erro ao escrever o arquivo!");	
		}
	}
}
