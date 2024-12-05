package com.project.DTO;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigDTO {

    private String caminho="C:\\Users\\arthu\\OneDrive\\Documentos\\Estudo\\library";
   public ArrayList<String> livros = new ArrayList();
private int livroSelecionado;

    
    public void criarDiretorio() {
        try {
            System.out.println("Digite o caminho para criar a pasta onde ficará os livros");
            setCaminho(new Scanner(System.in).next() + "/library");
            File pasta = new File(getCaminho());

            if (pasta.exists() && pasta.isDirectory()) {
                System.out.println("Repositório já existe");
                pasta = new File(getCaminho() + "/config.txt");
                if (pasta.exists()) {
                    System.out.println("já está tudo previamente pronto para o uso");
                } else {
                    pasta.createNewFile();
                    try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminho + "/config.txt", false))) {
                        escrever.write("Livros:");
                        acharLivros();
                    } catch (Exception e) {
                        System.out.println("Erro " + e);
                    }
                }

            } else {
                pasta.mkdir();
                pasta = new File(getCaminho() + "/config.txt");
                if (pasta.exists()) {
                    System.out.println("já está tudo previamente pronto para o uso");
                } else {
                    pasta.createNewFile();
                    try (BufferedWriter escrever = new BufferedWriter(new FileWriter(caminho + "/config.txt", false))) {
                        escrever.write("Livros:");
                        acharLivros();
                    } catch (Exception e) {
                        System.out.println("Erro " + e);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

    }

    public void acharLivros() {
              String line;
        File pasta = new File(getCaminho());
        File[] arquivos = pasta.listFiles();
        ArrayList<String> Livros = new ArrayList<>();
        if (pasta.isDirectory()) {
            for (File livro : arquivos) {
                if (livro.getName().toLowerCase().endsWith(".pdf")) {
                    Livros.add(livro.getName());
                    System.out.println(livro.getName());
                }
            }
            organizarTela();
            System.out.println("Os " + Livros.size() + " livros que foram encontrados são: ");
            for (String l : Livros) {
                if (!checarLivros(l)) {
                    inserirLivro(l);
                    System.out.println(l);
                }

            }
            
               try (BufferedReader read = new BufferedReader(new FileReader(getCaminho() + "/config.txt"))) {
            while ((line = read.readLine()) != null) {
               livros.add(line.split(".pdf")[0]);
            }
            
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
            
            
            
            
            
            
            
            organizarTela();
        }

        System.out.println("Caso um livro não esteja na lista verifique que ele está em formato .pdf");
    }

    public boolean checarLivros(String nome) {

        try (BufferedReader read = new BufferedReader(new FileReader(getCaminho() + "/config.txt"))) {
            String s;
            while ((s = read.readLine()) != null) {
                if ((s.split("=")[0]).equals(nome.split("=")[0])) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
        return false;
    }

    public void inserirLivro(String nome) {
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter(getCaminho() + "/config.txt", true))) {
            escrever.write("\n" + nome + "=0");

          
            
        } catch (IOException e) {
        }

    }
    
     public void listaLivros() {

        for (int i = 0; i < livros.size(); i++) {
                System.out.println(i>0 ? (i)+"°"+livros.get(i):""+livros.get(i));
            }
            
       
        organizarTela();
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
public int getLivroSelecionado() {
        return livroSelecionado;
    }

    public void setLivroSelecionado(int livroSelecionado) {
        this.livroSelecionado = livroSelecionado;
    }
    public void organizarTela() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
        }
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
        }

    }



}
