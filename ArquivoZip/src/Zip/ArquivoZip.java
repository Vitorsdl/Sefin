package Zip;

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
import janela.zip;

public class ArquivoZip {
	
static final int TAMANHO_BUFFER = 20480; // 20kb
    
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

    public static void main(String[] args) throws Exception  {
        short t=0;
        //new ArquivoTela().setVisible(true);
        long tempoDeEspera=6000;//900000
        File arquivos[];
        File diretorio = new File("C:\\Users\\m1415425\\Documents\\Novapasta");
        FTPClient ftp = new FTPClient();
        
        if(ftp.isConnected())
            System.out.println("Conectado");
        else 
            System.out.println("Não Conectado");

        FileInputStream arqEnviar = new FileInputStream("C:\\Users\\m1415425\\Documents\\Zip\\Arquivo.zip");
        
        while(t != 1){
        ftp.connect("10.52.1.102");
        ftp.login("tempftp", "comdata");
        arquivos = diretorio.listFiles();
        for (int i = 0; i < arquivos.length; i++)
            System.out.println(arquivos[i].toString());

        compactarParaZip("C:\\Users\\m1415425\\Documents\\Zip\\Arquivo.zip", arquivos, arquivos.length);

        
        if (ftp.storeFile("Arquivo.zip", arqEnviar))
            System.out.println("Arquivo armazenado com sucesso!");
        else 
            System.out.println("Erro ao armazenar o arquivo.");
        ftp.logout();
        ftp.disconnect();
        System.out.println("Disconnected!");
        
        Date date = new Date();
        System.out.println("Horário execução: "+date);
        GregorianCalendar gc = new java.util.GregorianCalendar();
        gc.add(Calendar.MINUTE,1);
        System.out.println("Próxima execução: "+gc.getTime());
        
        Thread.sleep(tempoDeEspera);
    }
    }

}
