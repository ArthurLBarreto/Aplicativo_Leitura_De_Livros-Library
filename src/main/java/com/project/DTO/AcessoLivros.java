package com.project.DTO;

import com.project.VIEW.LivroView;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.swing.JFrame;

public class AcessoLivros  extends ConfigDTO{
    
    public ImageIcon PaginaLivro()  {
        
        try {
            PDDocument doc = Loader.loadPDF(new File(getCaminho()+"/"+livros.get(0)+".pdf"));
            BufferedImage render = new PDFRenderer(doc).renderImageWithDPI(acharPagina(), 100);
            ImageIcon imagem = new ImageIcon(render);
            return imagem;
        } catch (IOException e) {
            System.out.println("Erro " + e);
            return null;
        }
        
    }
    
    public int acharPagina() {
        try (BufferedReader read = new BufferedReader(new FileReader(getCaminho()+"/config.txt"))) {
            String linha;
            while((linha = read.readLine())!=null){
                if(linha.startsWith(livros.get(getLivroSelecionado())+".pdf")){ 
                  String[] t = linha.split("=");
                  
                    return Integer.parseInt(t[1]);
                }      
            }
        } catch (Exception e) {
        }
        
        return 0;
    }
    
    public void telaLivro(){
        
        JFrame telalivro = new JFrame();
           JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JLabel pagina = new javax.swing.JLabel();

        telalivro.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pagina.setIcon(PaginaLivro());
        jScrollPane1.setViewportView(pagina);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(telalivro.getContentPane());
        telalivro.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
        );

        telalivro.pack();
        
        telalivro.setVisible(true);
        
        
    }
    
    
    
    
    
}
