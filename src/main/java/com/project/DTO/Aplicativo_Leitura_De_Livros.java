package com.project.DTO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;


public class Aplicativo_Leitura_De_Livros  {
    public static void main(String[] args) throws IOException {
     
            File pdfFilename =  new File("C:/Users/arthu/OneDrive/Desktop/exemplo_pdf_unica_pagina.pdf");
        
        PDDocument document = PDDocument.load(pdfFilename);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
int pageCounter = 0;
for (PDPage page : document.getPages())
{
    // note that the page number parameter is zero based
    BufferedImage bim = pdfRenderer.renderImageWithDPI(pageCounter, 300, ImageType.RGB);

    // suffix in filename will be used as the file format
    ImageIOUtil.writeImage(bim, pdfFilename + "-" + (pageCounter++) + ".png", 300);
}
document.close();

    
    
        
       
   
        
    }
        
}
