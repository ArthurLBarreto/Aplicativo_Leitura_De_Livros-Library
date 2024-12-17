
package com.project.ANIMATION;

import java.io.File;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animacao extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Dimensões do livro
        double larguraLivro = 400;
        double alturaLivro = 300;

        
                // Página 1 (imagem de fundo)
        ImageView pagina1 = new ImageView(new Image("C:\\Users\\arthu\\OneDrive\\Pictures\\Programas\\images.png")); // Substitua pelo caminho da sua imagem
        pagina1.setFitWidth(larguraLivro);
        pagina1.setFitHeight(alturaLivro);

        // Página 2 (imagem que será virada)
        ImageView pagina2 = new ImageView(new Image("C:\\Users\\arthu\\OneDrive\\Pictures\\Programas\\images.png")); // Substitua pelo caminho da sua imagem
        pagina2.setFitWidth(larguraLivro);
        pagina2.setFitHeight(alturaLivro);

        // Centralizar as páginas
        Group grupoPaginas = new Group(pagina1, pagina2);
        grupoPaginas.setTranslateX(200);
        grupoPaginas.setTranslateY(150);

        // Animação para virar a página (Página 2)
        RotateTransition virarPagina = new RotateTransition(Duration.seconds(1), pagina2);
        virarPagina.setAxis(Rotate.Y_AXIS); // Rotação em torno do eixo Y
        virarPagina.setFromAngle(0);        // Início da rotação
        virarPagina.setToAngle(180);       // Final da rotação
        virarPagina.setInterpolator(Interpolator.EASE_IN);
        virarPagina.setOnFinished(e -> {
            // Aqui você pode trocar a imagem da página para a próxima, se necessário
        });

        // Evento de clique para acionar a animação
        pagina2.setOnMouseClicked(e -> virarPagina.play());

        // Cena principal
        Scene scene = new Scene(grupoPaginas, 800, 600, Color.LIGHTGRAY);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Livro com Animação de Página");
        primaryStage.show();
    }

    public static void main(String[] args) {
       
        
    }
}
