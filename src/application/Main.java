package application;

import controlador.Controlador;
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.ConexionSQL;

public class Main extends Application {

	ConexionSQL modelo;
	Controlador controlador;

	@Override
	public void start(Stage primaryStage) {
		modelo = new ConexionSQL();
		controlador = new Controlador();
		controlador.setpersonData1(modelo);
		modelo.CargarBBDD();
		modelo.SELECTDatos();
		controlador.AbrirVentanaPrincipal(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
