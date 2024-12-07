package com.project.DTO;

import com.project.VIEW.LivroView;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.swing.JFrame;

public class AcessoLivros extends ConfigDTO {

    private int pagina;
    public ArrayList<String> livro;

    public ImageIcon PaginaLivro() {

        try {
            PDDocument doc = Loader.loadPDF(new File(getCaminho() + "/" + livro.get(pagina) + ".pdf"));
            BufferedImage render = new PDFRenderer(doc).renderImageWithDPI(acharPagina(), 100);
            ImageIcon imagem = new ImageIcon(render);
            return imagem;
        } catch (IOException e) {
            System.out.println("Erro " + e);
            return null;
        }

    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int acharPagina() {
        try (BufferedReader read = new BufferedReader(new FileReader(getCaminho() + "/config.txt"))) {
            String linha;
            while ((linha = read.readLine()) != null) {
                if (linha.startsWith(livro.get(pagina) + ".pdf")) {
                    String[] t = linha.split("=");

                    return Integer.parseInt(t[1]);
                }
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public void telaLivro() {

        JFrame telalivro = new JFrame();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JLabel pagina = new javax.swing.JLabel(),
                ldDireito = new javax.swing.JLabel(),
                ldEsquerdo = new javax.swing.JLabel();
        telalivro.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ldDireito.setText("jLabel2");
        ldDireito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ldDireitoMouseClicked(evt);
            }
        });
        telalivro.getContentPane().add(ldDireito, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 6, 110, 600));

        ldEsquerdo.setText("jLabel2");
        ldEsquerdo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ldEsquerdoMouseClicked(evt);
            }
        });
        telalivro.getContentPane().add(ldEsquerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 600));

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

    private void ldEsquerdoMouseClicked(java.awt.event.MouseEvent evt) {
        
        if(acharPagina()>0){
            mudarPagina(acharPagina(), -1);
        }
        
        
    }

    private void ldDireitoMouseClicked(java.awt.event.MouseEvent evt) {

        mudarPagina(acharPagina(), 1);
    }

    public void mudarPagina(int paginaAtual, int valor) {

        try {
            String config = new String(Files.readAllBytes(Paths.get(getCaminho())));

            config = config.replace(livro.get(getPagina()) + ".pdf=" + paginaAtual, livro.get(getPagina()) + ".pdf=" + paginaAtual + (valor));

        } catch (IOException e) {
            System.out.println("Erro na alteração da pagina: " + e);
        }

    }

}
