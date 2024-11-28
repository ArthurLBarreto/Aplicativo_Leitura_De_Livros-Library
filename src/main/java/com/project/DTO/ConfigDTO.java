package com.project.DTO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigDTO {

    private String caminho;

    public void criarDiretorio() {
        try {
            System.out.println("Digite o caminho para criar a pasta onde ficará os livros");
            setCaminho(new Scanner(System.in).next() + "/library");
            System.out.println(getCaminho());
            File pasta = new File(getCaminho());
            pasta.mkdir();
            pasta = new File(getCaminho() + "/config.txt");
            pasta.createNewFile();
            try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminho + "/config.txt", false))) {
                escrever.write("Livros:");
            } catch (Exception e) {
                System.out.println("Erro " + e);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    public void acharLivros() {

        File pasta = new File(getCaminho());
        File[] arquivos = pasta.listFiles();
        ArrayList<String> livros = new ArrayList<>();

        if (pasta.isDirectory()) {
            for (File livro : arquivos) {
                if (livro.getName().toLowerCase().endsWith(".pdf")) {
                    livros.add(livro.getName());
                    System.out.println(livro.getName());
                }
            }
             System.out.println("Os " + livros.size() + " livros que foram encontrados são: ");
            for (String l : livros) {
                if(!checarLivros(l)){
                    inserirLivro(l);
                     System.out.println(l);
            }
               

            }

        }

        System.out.println("Caso um livro não esteja na lista verifique que ele está em formato .pdf");
    }

    public boolean checarLivros(String nome) {

        try (BufferedReader read = new BufferedReader(new FileReader(getCaminho() + "/config.txt"))) {
            String s;
            while ((s = read.readLine()) != null) {
                    if((s.replace("=0", "")).equals(nome)){
                    return true;
                    }
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
        return false;
    }
    
    
    
    
    
    public void inserirLivro(String nome){
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(getCaminho()+"/config.txt",true))){
            escrever.write("\n"+nome+"=0");
            
            
            
        } catch (IOException e) {
        }
        
    }
  
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
