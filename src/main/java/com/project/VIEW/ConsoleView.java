package com.project.VIEW;

import com.project.DTO.AcessoLivros;
import com.project.DTO.ConfigDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleView extends ConfigDTO {

    AcessoLivros acesso = new AcessoLivros();

    public void index() {
        int t = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (t == 0) {
                System.out.println("O que deseja fazer?");
                System.out.println("""
                                   1- Criar Diretorio
                                   2- Adicionar Diretorio Existente
                                   3- Listar Livros existentes
                                   4- Adicionar novos(Coloque dentro da pasta library Antes de adicionar)
                                   5- Abrir Livro
                                   6- Sair
                                   """);
                System.out.print("->");
                int n = sc.nextInt();
                switch (n) {
                    case 1 ->
                        criarDiretorio();
                    case 2 -> {
                        System.out.println("Digite o caminho");
                        setCaminho(new Scanner(System.in).next());

                    }
                    case 3 ->
                        listaLivros();
                    case 4 ->
                        acharLivros();
                    case 5 -> {
                        listaLivros();
                        System.out.println("Digite o numero do livro da lista acima");
                        System.out.print("-> ");
                        setLivroSelecionado(new Scanner(System.in).nextInt());
                        if (getLivroSelecionado() > 0) {
                            acesso.setPagina(getLivroSelecionado());
                            acesso.livro =livros;
                            acesso.PaginaLivro();
                            acesso.telaLivro();
                        } else {
                            System.out.println("Valor digitado invalido");
                        }
                    }

                    case 6 ->
                        t = 1;
                    default ->
                        throw new AssertionError();
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

}
