package com.project.DTO;

import com.project.VIEW.ConsoleView;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;



    
public class Aplicativo_Leitura_De_Livros  {
    public static void main(String[] args) {
 
    
    
     System.out.println("Texto antes da limpeza...");
        
        try {
            Thread.sleep(2000); // Aguarda 2 segundos antes de limpar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux ou Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    
        
        System.out.println("Console limpo!");
    }
          
          
    }
        

