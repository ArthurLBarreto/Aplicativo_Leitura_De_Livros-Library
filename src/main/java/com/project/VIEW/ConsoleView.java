package com.project.VIEW;

import com.project.DTO.AcessoLivros;
import com.project.DTO.ConfigDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleView extends ConfigDTO {

    public void index() {
        int t = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (t == 0) {
                System.out.println("O que deseja fazer?");
                System.out.println("1-Adicionar Diretorio\n"
                        + "2- Listar Livros existentes\n"
                        + "3- Adicionar novos(Coloque dentro da pasta library Antes de adicionar)\n"
                        + "4- Abrir Livro\n"
                        + "5- Sair\n");
                System.out.print("->");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        criarDiretorio();
                        break;
                    case 2:
                        listaLivros();
                        break;
                    case 3:
                        acharLivros();
                        break;
                    case 4:
                        new LivroView().setVisible(true);
                        break;
                    case 5:

                        t = 1;
                        break;
                    default:
                        throw new AssertionError();
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

   

}
