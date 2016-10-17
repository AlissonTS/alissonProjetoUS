package br.ufsm.ceesp.ceee.beans;

import br.ufsm.ceesp.ceee.util.GeradorData;
import br.ufsm.ceesp.ceee.util.LeitorCSV;

import javax.swing.*;
import java.io.*;

public class ConversorCEEE {

    public static void main(String[] args) throws Exception {

        InputStream arquivo = null;
        File f = null;
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(new JFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            f = fc.getSelectedFile();
            //This is where a real application would open the file.
            arquivo = new FileInputStream(f);
        }

        // Funcionando em CSV e TXT

        LeitorCSV csv = new LeitorCSV(arquivo);

        String[] retorno = null;

        retorno = csv.nextLine(true);
        retorno = csv.nextLine(true);

        System.out.println("Carregando Linhas...");
        do{
            if(retorno.length>0){


            }
            retorno = csv.nextLine(true);
        }while(retorno!=null);

        // Criar arquivo
        File saida = new File(f.getAbsolutePath() + ".ceee.exp");
        if(!saida.exists()) {
            saida.createNewFile();
            System.out.println("Arquivo criado no diretório..");
        }
        else{
            System.out.println("Arquivo Já existente no diretório..");
        }

        try {
            // Começo da escrita do arquivo.
            FileWriter fw = new FileWriter(saida);

            GeradorData gd = new GeradorData();
            String dataFormatada = gd.dataFormatada();
            String horaFormatada = gd.horaFormatada();
            String dataFormatadaReferencia = gd.dataFormatadaReferencia();

            fw.write("PRI;\r\n");
            fw.write(dataFormatada+" "+horaFormatada+"- v2.89;\r\n");
            fw.write("DATA DE REFERÊNCIA = "+dataFormatadaReferencia+";\r\n");

            fw.write("VER;\r\n4.0;\r\n\r\n");

            fw.write("CHAVE;\r\n");

            fw.write("END;\r\n");

            fw.close();
            System.out.println("Arquivo preenchido..");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
