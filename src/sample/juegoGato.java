package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class juegoGato implements Initializable{

    @FXML
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    @FXML
    AnchorPane principal;

    @FXML
    private int contador = 0;
    @FXML
    private int[][] mapa = new int[][]{
                            {1,-2,-3},
                            {-4,-5,-6},
                            {-1,-2,-3}};

    @Override

    public void initialize(URL location, ResourceBundle resources) {

        this.btn1.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(0,0);
                comprobar();
            }
        });

        this.btn2.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(0,1);
                comprobar();
            }
        });

        this.btn3.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(0,2);
                comprobar();
            }
        });

        this.btn4.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(1,0);
                comprobar();
            }
        });

        this.btn5.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(1,1);
                comprobar();
            }
        });

        this.btn6.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(1,2);
                comprobar();
            }
        });

        this.btn7.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(2,0);
                comprobar();
            }
        });

        this.btn8.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(2,1);
                comprobar();
            }
        });

        this.btn9.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                evento(2,2);
                comprobar();
            }
        });


    }

    //Aqui comienso  con los metodos :)....
//metodo EVENTO
    public void evento(int fila, int columna ){

        switch (fila)
        {
            case 0:
                switch (columna)
                {
                    case 0: this.mapa[0][0] = botones(this.btn1); break;
                    case 1: this.mapa[0][1] = botones(this.btn2); break;
                    case 2: this.mapa[0][2] = botones(this.btn3); break;
                };break;
            case 1:
                switch (columna)
                {
                    case 0: this.mapa[1][0] = botones(this.btn4); break;
                    case 1: this.mapa[1][1] = botones(this.btn5); break;
                    case 2: this.mapa[1][2] = botones(this.btn6); break;
                }break;

            case 2:
                switch (columna)
                {
                    case 0: this.mapa[2][0] = botones(this.btn7); break;
                    case 1: this.mapa[2][1] = botones(this.btn8); break;
                    case 2: this.mapa[2][2] = botones(this.btn9); break;
                }break;

        }
    }

    private int botones (Button button)
    {
        int user = -1;
        if(contador %2 == 0)
        {
            user = 0;
            button.setText("O");

        }
        else
        {
            user = 1;
            button.setText("X");
        }
        button.setVisible(true);
        this.contador++;
        return user;
    }

    //metodo COMPROVAR
    private void comprobar()
    {
        for(int fila = 0; fila < 3; fila++)
        {
            if (mapa[fila][0]== mapa[fila][1] && mapa[fila][1]== mapa[fila][2])
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Juego del Gato");
                alert.setHeaderText("Resultado de Partida");
                alert.setContentText("GANO EL GUGADOR " + mapa[fila][0]);
                alert.showAndWait();

                bloqueoElementos();
                reset();
                this.contador = 0;
                return;
            }
            if (mapa[0][fila]== mapa[1][fila] && mapa[1][fila]== mapa[2][fila])
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Juego del Gato");
                alert.setHeaderText("Resultado de Partida");
                alert.setContentText("GANO EL GUGADOR " + mapa[0][fila]);
                alert.showAndWait();

                bloqueoElementos();
                reset();
                this.contador = 0;
                return;
            }
        }
        if (mapa[0][0]== mapa[1][1] && mapa[1][1]== mapa[2][2])
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juego del Gato");
            alert.setHeaderText("Resultado de Partida");
            alert.setContentText("GANO EL GUGADOR " + mapa[0][0]);
            alert.showAndWait();

            bloqueoElementos();
            reset();
            this.contador = 0;
            return;
        }
        if (mapa[2][0]== mapa[1][1] && mapa[1][1]== mapa[0][2])
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juego del Gato");
            alert.setHeaderText("Resultado de Partida");
            alert.setContentText("GANO EL GUGADOR " + mapa[2][0]);
            alert.showAndWait();

            bloqueoElementos();
            reset();
            this.contador = 0;
            return;
        }
        if (contador %9 == 0 ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juego del Gato");
            alert.setHeaderText("Resultado de Partida");
            alert.setContentText("ES UN EMPATE");
            alert.showAndWait();

            reset();
            return;
        }
    }

    private void bloqueoElementos() {
    }

    private void reset()
    {

    }
}
