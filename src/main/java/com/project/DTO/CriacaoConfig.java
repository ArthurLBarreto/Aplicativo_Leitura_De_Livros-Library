package com.project.DTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CriacaoConfig {

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
                }
                System.out.println("Os " + livros.size() + " livros que foram encontrados são: ");
            }
            for (String l : livros) {
                System.out.println(l);

            }

        }

        System.out.println("Caso um livro não esteja na lista verifique que ele está em formato .pdf");
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
