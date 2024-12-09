package com.project.DTO;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

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
        JLabel pagina = new javax.swing.JLabel();
        telalivro.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pagina.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "Alterar Página Adicionar");
        pagina.getActionMap().put("Alterar Página Adicionar", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try (PDDocument pdf = Loader.loadPDF(new File(getCaminho() + "/" + livro.get(getLivroSelecionado()+1) + ".pdf"))) {
                    if (pdf.getNumberOfPages() >= (acharPagina() + 1)) {

                        mudarPagina(1);
                        pagina.setIcon(PaginaLivro());

                    }

                } catch (IOException er) {
                    System.out.println("erro: " + er);
                }
            }

        }
        );
        pagina.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "Alterar Página Reduzir");
        pagina.getActionMap().put("Alterar Página Reduzir", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try (PDDocument pdf = Loader.loadPDF(new File(getCaminho() + "/" + livro.get(getLivroSelecionado()+1) + ".pdf"))) {
                    if (0 <= (acharPagina()- 1)) {

                        mudarPagina(-1);
                        pagina.setIcon(PaginaLivro());

                    }

                } catch (IOException er) {
                    System.out.println("erro: " + er);
                }

            }
        });

        telalivro.pack();

        telalivro.setVisible(true);

    }

    public void mudarPagina(int valor) {

        try {
            String config = new String(Files.readAllBytes(Paths.get(getCaminho() + "/config.txt")));

            config = config.replace(livro.get(getPagina()) + ".pdf=" + acharPagina(), livro.get(getPagina()) + ".pdf=" + (acharPagina() + (valor)));
            Files.write(Paths.get(getCaminho() + "/config.txt"), config.getBytes());

        } catch (IOException e) {
            System.out.println("Erro na alteração da pagina: " + e);
        }

    }

}
