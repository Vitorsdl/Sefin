package Zip;

import java.io.File;
import java.io.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.IOException;

public class ArquivoZip {
	
static final int TAMANHO_BUFFER = 1024*20; // 20kb
    
    public static void compactarParaZip(String arqSaida, File[] arqEntrada, int tam) throws IOException {
        FileOutputStream destino;
        ZipOutputStream saida;
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
        int cont;
        byte[] dados = new byte[TAMANHO_BUFFER];
        File file = new File(arquivo);
        BufferedInputStream origem = new BufferedInputStream(new FileInputStream(file), TAMANHO_BUFFER);
        ZipEntry entry = new ZipEntry(file.getName());
        saida.putNextEntry(entry);
        while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) 
            saida.write(dados, 0, cont);
        origem.close();
    }
   
}
