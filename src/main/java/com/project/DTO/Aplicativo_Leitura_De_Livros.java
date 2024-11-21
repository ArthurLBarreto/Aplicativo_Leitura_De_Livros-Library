package com.project.DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;


    
public class Aplicativo_Leitura_De_Livros  {
    public static void main(String[] args) throws IOException {
           new CriacaoConfig().acharLivros();          
         
          
          
          
        
    }
        
}
