package com.test.Livros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Teste_AcessoLivros {

    String caminho = "C:/Users/Teste/Documentos/Estudo/library";

    @Test
    void teste_CriarConfig() {
        System.out.println("Diretorio que deseja criar pasta");

        try {
            File Teste = new File(caminho);
            if (Teste.mkdir()) {
                Teste = new File(caminho + "/config.txt");
                if (Teste.createNewFile()) {
                } else {
                    System.out.println("Não foi possivel criar o arquivo config");
                }
            } else {
                System.out.println("Pasta já existe. Criando apenas arquivo config");
                Teste = new File(caminho + "/config.txt");
                if (Teste.createNewFile()) {
                } else {
                    System.out.println("Não foi possivel criar o arquivo config");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro na criação da pasta: " + e);
        }
    }

    @Test
    void teste_adicionarConfiguracaoNoConfig() {
        String texto = "Teste adicionar:";

        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminho + "/config.txt", false))) {

            escrever.write(texto);
            System.out.println("Texto adiconado com sucesso");

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    @Test
    void teste_acharPDFs() {

        File pasta = new File(caminho);
        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();
            ArrayList<String> livros = new ArrayList<>();
            
            
            if(arquivos!=null && arquivos.length>0){
            for (File livro : arquivos) {
                if (livro.getName().toLowerCase().endsWith(".pdf")) {
                    livros.add(String.valueOf(livro.getName()));
                }
            }

            System.out.println("Há um total de: " + livros.size() + " Livros");
            for (String l : livros) {
                teste_localizarLivro(l);
                System.out.println(l);
            }

        }
        }
    }

    @Test
    void teste_adicionarLivroNoConfig(String nome) {
        nome = "ola";
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminho + "/config.txt", true))) {
            escrever.write("\n" + nome);
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    @Test
    void teste_localizarLivro(String nome) {
        boolean teste = false;
        try (BufferedReader read = new BufferedReader(new FileReader(caminho + "/config.txt"))) {
            if (read.readLine() == nome) {
                teste = false;
            } else {
                teste = true;
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

        if (!teste) {

        }
    }

}
