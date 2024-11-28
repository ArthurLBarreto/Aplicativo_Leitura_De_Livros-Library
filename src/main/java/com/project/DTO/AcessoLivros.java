package com.project.DTO;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

public class AcessoLivros {
    
    public ImageIcon PaginaLivro() {
        
        try {
            PDDocument doc = Loader.loadPDF(new File("C:/Users/arthu/OneDrive/Documentos/Estudo/library/Alberto Souza - Spring MVC_ Domine o principal framework web Java. 1-CASA DO CODIGO (2015).pdf"));
            BufferedImage render = new PDFRenderer(doc).renderImageWithDPI(acharPagina(), 100);
            ImageIcon imagem = new ImageIcon(render);
            return imagem;
        } catch (IOException e) {
            System.out.println("Erro " + e);
            return null;
        }
        
    }
    
    public int acharPagina() {
        try (BufferedReader read = new BufferedReader(new FileReader("C:/Users/arthu/OneDrive/Documentos/Estudo/library/config.txt"))) {
            String linha;
            while((linha = read.readLine())!=null){
                if(linha.startsWith("Alberto Souza - Spring MVC_ Domine o principal framework web Java. 1-CASA DO CODIGO (2015).pdf")){ 
                  String[] t = linha.split("=");
                  
                    return Integer.parseInt(t[1]);
                }   
                   
            }
            
            
        } catch (Exception e) {
        }
        
        return 0;
    }
    
}
