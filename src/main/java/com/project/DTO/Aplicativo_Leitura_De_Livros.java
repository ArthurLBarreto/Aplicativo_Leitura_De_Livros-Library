package com.project.DTO;

import com.project.VIEW.ConsoleView;
import com.project.VIEW.LivroView;
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
 
        ConsoleView s =new ConsoleView();
               AcessoLivros a=  new AcessoLivros();

         
        ConfigDTO p = s ;
       s.index();
        
        
    }
        
}
