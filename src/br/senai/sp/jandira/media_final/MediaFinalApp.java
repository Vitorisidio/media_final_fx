package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

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
        buttonCalcularMedia.setOnAction( click ->{
            System.out.println("Botão clicado");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //CALCULAR MÉDIA
            //OBTER AS NOTAS

            //CRIAR VETOR (array) DE NOTAS
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            // USO DE LOOP while (ENQUANTO)


            //Calculo
            int i = 0;
            double mediaFinal = 0.0;

                    while (i < notas.length) {
                        mediaFinal = mediaFinal + notas[i];
                        i = i + 1;

                    }
                    mediaFinal = mediaFinal / notas.length;

                        String mediaFinalStr = String.format("%.2f", mediaFinal); // deixa 2 casas decimais

            labelMediaFInal.setText("Média Final: " + mediaFinalStr);

            //Aprovado ou reprovado

            String situacao = "";

            if (mediaFinal < 4){
                situacao = "REPROVADO";
            }else if (mediaFinal >= 6 ){
                situacao = "APROVADO";
            } else {
                situacao = "RECUPERAÇÃO";
            }

            labelSituacao.setText("Situçao: " + situacao);


        });

        buttonLimpar.setOnAction( click -> {
            textFieldNome.setText("");
            textFieldNota1.setText("");
            textFieldNota2.setText("");
            textFieldNota3.setText("");
            textFieldNota4.setText("");
            labelMediaFInal.setText("");
            labelAluno.setText("");
            labelSituacao.setText("");
            textFieldNome.requestFocus();
        });

        buttonSair.setOnAction( click ->{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "confirma a saída?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPrecionado = alerta.showAndWait();
            if (botaoPrecionado.get() == ButtonType.YES ) {
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "até logo");
                alerta2.showAndWait();
                System.exit(0);
            }
        });



    }
}
