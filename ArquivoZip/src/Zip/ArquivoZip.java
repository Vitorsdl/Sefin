package Zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArquivoZip {

	static final int TAMANHO_BUFFER = 1024 * 20; // 20kb

	public static void compactarParaZip(String arqSaida, File[] arqEntrada, int tam) throws IOException {
		FileOutputStream destino = null;
		ZipOutputStream saida = null;
		try {
			destino = new FileOutputStream(new File(arqSaida));
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			for (int i = 0; i < tam; i++)
				add(arqEntrada[i].toString(), saida);
			saida.close();
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}
	}

	private static void add(String arquivo, ZipOutputStream saida) throws IOException {
		int cont = 0;
		byte[] dados = new byte[TAMANHO_BUFFER];
		File file = new File(arquivo);
		BufferedInputStream origem = new BufferedInputStream(new FileInputStream(file), TAMANHO_BUFFER);
		ZipEntry entry = new ZipEntry(file.getName());
		saida.putNextEntry(entry);
		while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1)
			saida.write(dados, 0, cont);
		origem.close();
	}

	public static void correcao(String caminho, String caminhoSalvar, int w) {
		try {
			 //Leitura do arquivo;
			FileInputStream arquivo1 = new FileInputStream(caminho);
			InputStreamReader iSR = new InputStreamReader(arquivo1);
			BufferedReader bR = new BufferedReader(iSR);
			// Escrita em outro arquivo;
			FileOutputStream arquivo2 = new FileOutputStream(caminhoSalvar+"\\"+"Arquivo"+w+".txt");
			PrintWriter pW = new PrintWriter(arquivo2);

			String linha;
			// array a são os caracteres a ser substituido; array b sao os caracteres para substituir; seguir a posicao dos dois arrays para adicao de novos caracteres;
			char[] a = { 'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò',
					'Ó', 'Ô', 'Õ', 'Ö', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'à', 'á', 'â', 'ã', 'ä', 'å', 'æ', 'ç', 'è', 'é', 'ê',
					'ë', 'ì', 'í', 'î', 'ï', 'ñ', 'ò', 'ó', 'ô', 'õ', 'ö', 'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'ÿ', 'Ā', 'ā',
					'Ă', 'ă', 'Ą', 'ą', 'Ć', 'ć', 'Ĉ', 'ĉ', 'Ċ', 'ċ', 'Č', 'č', 'Ď', 'ď', 'Đ', 'đ', 'Ē', 'ē', 'Ĕ', 'ĕ',
					'Ė', 'ė', 'Ę', 'ę', 'Ě', 'ě', 'Ĝ', 'ĝ', 'Ğ', 'ğ', 'Ġ', 'ġ', 'Ģ', 'ģ', 'Ĥ', 'ĥ', 'Ħ', 'ħ', 'Ĩ', 'ĩ',
					'Ī', 'ī', 'Ĭ', 'ĭ', 'Į', 'į', 'İ', 'ı', 'Ĳ', 'ĳ', 'Ĵ', 'ĵ', 'Ķ', 'ķ', 'Ĺ', 'ĺ', 'Ļ', 'ļ', 'Ľ', 'ľ',
					'Ŀ', 'ŀ', 'Ł', 'ł', 'Ń', 'ń', 'Ņ', 'ņ', 'Ň', 'ň', 'ŉ', 'Ō', 'ō', 'Ŏ', 'ŏ', 'Ő', 'ő', 'Œ', 'œ', 'Ŕ',
					'ŕ', 'Ŗ', 'ŗ', 'Ř', 'ř', 'Ś', 'ś', 'Ŝ', 'ŝ', 'Ş', 'ş', 'Š', 'š', 'Ţ', 'ţ', 'Ť', 'ť', 'Ŧ', 'ŧ', 'Ũ',
					'ũ', 'Ū', 'ū', 'Ŭ', 'ŭ', 'Ů', 'ů', 'Ű', 'ű', 'Ų', 'ų', 'Ŵ', 'ŵ', 'Ŷ', 'ŷ', 'Ÿ', 'Ź', 'ź', 'Ż', 'ż',
					'Ž', 'ž', 'ſ', 'ƒ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ǎ', 'ǎ', 'Ǐ', 'ǐ', 'Ǒ', 'ǒ', 'Ǔ', 'ǔ', 'Ǖ', 'ǖ', 'Ǘ', 'ǘ',
					'Ǚ', 'ǚ', 'Ǜ', 'ǜ', 'Ǻ', 'ǻ', 'Ǽ', 'ǽ', 'Ǿ', 'ǿ', 'Ά', 'ά', 'Έ', 'έ', 'Ό', 'ό', 'Ώ', 'ώ', 'Ί', 'ί',
					'ϊ', 'ΐ', 'Ύ', 'ύ', 'ϋ', 'ΰ', 'Ή', 'ή', '$', '²', 'ß', 'Ø', 'º', '«', '@', '', '”', 'ˆ', '‡', '±',
					'—', 'Þ', '©', '{', '¥', '¬', '¹', '?', '›', '',
					'' }; // Os dois ultimos estao com caracteres que nao conseguimos ver

			String[] b = { "A", "A", "A", "A", "O", "A", "AE", "C", "O", "E", "E", "E", "I", "O", "I", "", "D", "O",
					"O", "O", "O", "O", "O", "U", "U", "U", "U", "Y", "a", "a", "a", "a", "O", "a", "ae", "c", "O", "e",
					"e", "e", "i", "O", "i", "", "O", "o", "o", "o", "o", "o", "o", "u", "u", "u", "u", "y", "y", "A",
					"a", "A", "a", "A", "a", "C", "c", "C", "c", "C", "c", "C", "c", "D", "d", "D", "d", "E", "e", "E",
					"e", "E", "e", "E", "e", "E", "e", "G", "g", "G", "g", "G", "g", "G", "g", "H", "h", "H", "h", "I",
					"i", "I", "i", "I", "i", "I", "i", "I", "i", "IJ", "ij", "J", "j", "K", "k", "L", "l", "L", "l",
					"L", "l", "L", "l", "l", "l", "N", "n", "N", "n", "N", "n", "n", "O", "o", "O", "o", "O", "o", "OE",
					"oe", "R", "r", "R", "r", "R", "r", "S", "s", "S", "s", "S", "s", "A", "A", "T", "t", "T", "t", "T",
					"t", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "W", "w", "Y", "y", "Y", "Z", "z",
					"Z", "z", "Z", "z", "s", "f", "O", "o", "U", "u", "A", "a", "I", "i", "O", "o", "U", "u", "U", "u",
					"U", "u", "U", "u", "U", "u", "A", "a", "AE", "ae", "O", "o", "Α", "α", "Ε", "ε", "Ο", "ο", "Ω",
					"ω", "Ι", "ι", "ι", "ι", "Υ", "υ", "υ", "υ", "Η", "η", "C", "I", "A", "", "C", "C", "A", "", "E",
					"E", "", "E", "", "A", "E", "O", "I", "N", "", "/", "E", "A", "C" };

			System.out.println("Executando");// Inicio da execucao;
			do {
				linha = bR.readLine();
				if (linha != null) {
					String[] palavras = linha.split("\n");
					for (int i = 0; i < palavras.length; i++) {
						char[] n = palavras[i].toCharArray();
						for (int j = 0; j < n.length; j++) {
							boolean ver = true;// verificacao para saber se escreve o caracter original ou alterado;
							for (int k = 0; k < a.length; k++) {
								if (n[j] == a[k]) {
									pW.print(b[k]);
									ver = false;
									break;
								}
							}
							if (ver) 
								pW.print(n[j]);
						}
					}
					pW.println();
				}
			} while (linha != null);
			//Fechando arquivos que foram abertos
			iSR.close();
			pW.close();
			arquivo1.close();
			arquivo2.close();

			System.out.println("Terminou!");// Conclusao da execucao;
		} catch (Exception e) {
			System.out.println("Erro ao escrever no arquivo!");
		}
	}

}
