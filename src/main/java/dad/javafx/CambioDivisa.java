package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {

	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.8873);
	private Divisa dolar = new Divisa("Dolar", 1.2007);
	private Divisa yen = new Divisa("Yen", 133.59);
	private TextField moneyText;
	private ComboBox<String> monedaOrigen;
	private TextField intercambio;
	private ComboBox<String> monedaDestino;
	private Button button;
	private Double cantidad;

	public void start(Stage primaryStage) throws Exception {

		moneyText = new TextField();
		moneyText.setPromptText("cantidad que quieres cambiar");
		moneyText.setMaxWidth(80);

		monedaOrigen = new ComboBox<String>();
		monedaOrigen.getItems().addAll("euro", "libra", "dolar", "yen");
		monedaOrigen.setPromptText("Moneda de Origen");

		intercambio = new TextField();
		intercambio.setPromptText("resultado");
		intercambio.setMaxWidth(80);

		monedaDestino = new ComboBox<String>();
		monedaDestino.getItems().addAll("euro", "libra", "dolar", "yen");
		monedaDestino.setPromptText("Moneda Destino");

		button = new Button("Cambiar moneda");
		button.setDefaultButton(true);
		button.setOnAction(e -> OnEventHandler(e));
		
		HBox monedaAcambiar=new HBox(5,moneyText,monedaOrigen);
		monedaAcambiar.setAlignment(Pos.CENTER);
		
		HBox monedaCambiada=new HBox(5,intercambio,monedaDestino);
		monedaCambiada.setAlignment(Pos.CENTER);
		
		VBox root=new VBox(monedaAcambiar,monedaCambiada,button);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Cambio divisa: ");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	private void OnEventHandler(ActionEvent e) {
		cantidad = Double.parseDouble(moneyText.getText());
		String moneda1 = monedaOrigen.getValue();
		String moneda2 = monedaDestino.getValue();

		switch (moneda1) {
		case "euro":
			if (moneda2 == "euro")
				intercambio.setText(Divisa.fromTo(euro, euro, cantidad).toString());
			else if (moneda2 == "libra")
				intercambio.setText(Divisa.fromTo(euro, libra, cantidad).toString());
			else if (moneda2 == "dolar")
				intercambio.setText(Divisa.fromTo(euro, dolar, cantidad).toString());
			else if (moneda2 == "yen")
				intercambio.setText(Divisa.fromTo(euro, yen, cantidad).toString());
			break;
		case "libra":
			if (moneda2 == "euro")
				intercambio.setText(Divisa.fromTo(libra, euro, cantidad).toString());
			else if (moneda2 == "libra")
				intercambio.setText(Divisa.fromTo(libra, libra, cantidad).toString());
			else if (moneda2 == "dolar")
				intercambio.setText(Divisa.fromTo(libra, dolar, cantidad).toString());
			else if (moneda2 == "yen")
				intercambio.setText(Divisa.fromTo(libra, yen, cantidad).toString());
			break;

		case "dolar":
			if (moneda2 == "euro")
				intercambio.setText(Divisa.fromTo(dolar, euro, cantidad).toString());
			else if (moneda2 == "libra")
				intercambio.setText(Divisa.fromTo(dolar, libra, cantidad).toString());
			else if (moneda2 == "dolar")
				intercambio.setText(Divisa.fromTo(dolar, dolar, cantidad).toString());
			else if (moneda2 == "yen")
				intercambio.setText(Divisa.fromTo(dolar, yen, cantidad).toString());
			break;

		case "yen":
			if (moneda2 == "euro")
				intercambio.setText(Divisa.fromTo(yen, euro, cantidad).toString());
			else if (moneda2 == "libra")
				intercambio.setText(Divisa.fromTo(yen, libra, cantidad).toString());
			else if (moneda2 == "dolar")
				intercambio.setText(Divisa.fromTo(yen, dolar, cantidad).toString());
			else if (moneda2 == "yen")
				intercambio.setText(Divisa.fromTo(yen, yen, cantidad).toString());
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
