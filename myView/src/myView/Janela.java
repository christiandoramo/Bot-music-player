package myView;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Janela extends Application {
	public void start(Stage primaryStage) throws Exception {
		Button add = new Button("Adicionar Musica");
		Button remove = new Button("Remover Musica");
		Button trocarLink = new Button("Trocar Link");
		Button selecionar = new Button("Selecionar Musica");
		Button verCompleta = new Button("Ver Playlist Completa");
		Button verGenero = new Button("Ver Playlist Por Genero");
		Label titulo = new Label("meu bot auto-player");
		Label sessao = new Label("Menu Inicial");
		
		
		HBox boxEscolhas = new HBox();
		VBox boxFundo = new VBox();
		boxEscolhas.getChildren().add(add);
		boxEscolhas.getChildren().add(remove);
		boxEscolhas.getChildren().add(trocarLink);
		boxEscolhas.getChildren().add(selecionar);
		boxEscolhas.getChildren().add(verCompleta);
		boxEscolhas.getChildren().add(verGenero);
		boxEscolhas.setSpacing(10);
		boxFundo.setAlignment(Pos.CENTER);
		boxFundo.setSpacing(10);
		boxFundo.getChildren().add(titulo);
		boxFundo.getChildren().add(sessao);
		boxFundo.getChildren().add(boxEscolhas);
		boxEscolhas.setAlignment(Pos.TOP_CENTER);
		Scene cenaInicial = new Scene(boxFundo,800,600);
		primaryStage.setScene(cenaInicial);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
