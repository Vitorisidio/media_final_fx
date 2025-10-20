package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Determinando o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(500);

        // Determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //Painel Raiz(root)
        BorderPane root = new BorderPane();

        //Titulo
        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof. Vicente Amato\"");
        //formatação do texto da Label titulo
        labelTitulo.setStyle("-fx-text-fill: #ff2900; -fx-font-size: 32; -fx-font-weight: bold; "); //cor
        labelTitulo.setPadding(new Insets(5, 0, 10, 10)); //espaçamentos

        //painel de Resultados - parte de baixo
        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets(0, 0, 10, 10)); //espaçamentos
        Label labelAluno = new Label("Nome do aluno:");
        Label labelMediaFInal = new Label("Média Final:");
        Label labelSituacao = new Label("Situação:");
        painelResultado.getChildren().addAll(labelAluno, labelMediaFInal, labelSituacao);

        //painel de botões
        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets(50, 80, 10, 0)); //espaçamentos
        painelDeBotoes.setSpacing(10); //espaçamentos vertical

        Button buttonCalcularMedia = new Button("Calcular Média");
        buttonCalcularMedia.setPrefWidth(100); //largura do botão
        buttonCalcularMedia.setPrefHeight(30);// tamanho do botao

        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(100); //largura do botão
        buttonLimpar.setPrefHeight(30);// tamanho do botao

        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(100); //largura do botão
        buttonSair.setPrefHeight(30);// tamanho do botao
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        //painel de formulario

        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(0, 0, 10, 10)); //espaçamentos
        Label labelNome = new Label("Nome do Aluno:");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");

        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();
        painelFormulario.getChildren().addAll(
          labelNome, textFieldNome,
          labelNota1, textFieldNota1,
          labelNota2, textFieldNota2,
          labelNota3, textFieldNota3,
          labelNota4, textFieldNota4
        );

        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);
        root.setLeft(painelFormulario);

        Scene scene = new Scene(root);

        stage.setScene(scene);


        //mostrar o stage
        stage.show();

        //Eventos de click dos botões
        //buttonCalcularMedia.addEventHandler();

    }
}
