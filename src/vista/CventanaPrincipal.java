package vista;

import controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import modelo.ConexionSQL;
import modelo.Persona;

public class CventanaPrincipal {

	@FXML
	private TextField txtfBuscador;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnCT;
	@FXML
	private Button btnDetalle;
	@FXML
	private SplitMenuButton menuEstado;
	@FXML
	private Button btnBorrar;

	@FXML
	public TableView<Persona> Tabla;
	@FXML
	private TableColumn<Persona, String> ColDNIi;
	@FXML
	private TableColumn<Persona, String> ColDNIr;
	@FXML
	private TableColumn<Persona, String> ColNombre;
	@FXML
	private TableColumn<Persona, String> ColRazonSocial;
	@FXML
	private TableColumn<Persona, String> ColRegistro;
	@FXML
	private TableColumn<Persona, String> ColActividad;
	@FXML
	private TableColumn<Persona, String> ColSuelo;
	@FXML
	private TableColumn<Persona, String> ColCatastral;
	@FXML
	private TableColumn<Persona, String> ColEmplazamiento;
	@FXML
	private TableColumn<Persona, String> ColEstadoLicencia;
	@FXML
	private TableColumn<Persona, String> ColCheck;

	// Reference to the Controlador and data.
	private Controlador controlador;
	private ConexionSQL personData44;
	private CnuevaSolicitud cns;

	public void setVentanaPrincipal(Controlador controlador) {
		// TODO Auto-generated method stub
		this.controlador = controlador;
	}

	/*
	 * public void setDatos1(ConexionSQL personData44) { // TODO Auto-generated
	 * method stub this.personData44 = personData44; //
	 * Tabla.setItems(this.personData.getPersonData());
	 * 
	 * ColDNIi.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("iDNI")); ColDNIr.setCellValueFactory(new
	 * PropertyValueFactory<Persona, String>("rDNI"));
	 * ColNombre.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("iNombre")); ColRazonSocial.setCellValueFactory(new
	 * PropertyValueFactory<Persona, String>("iRazonSocial"));
	 * ColRegistro.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("nregistro")); ColActividad.setCellValueFactory(new
	 * PropertyValueFactory<Persona, String>("TipoActividad"));
	 * ColSuelo.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("TipoSuelo")); ColCatastral.setCellValueFactory(new
	 * PropertyValueFactory<Persona, String>("Catastral"));
	 * ColEmplazamiento.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("Emplazamiento")); ColEstadoLicencia.setCellValueFactory(new
	 * PropertyValueFactory<Persona, String>("EstadoLicencia"));
	 * ColCheck.setCellValueFactory(new PropertyValueFactory<Persona,
	 * String>("checkDNI")); }
	 */
	public void setDatos(ConexionSQL personData) {
		// TODO Auto-generated method stub
		this.personData44 = personData;

		Tabla.setItems(this.personData44.getPersonData());

		ColDNIi.setCellValueFactory(new PropertyValueFactory<Persona, String>("iDNI"));
		ColDNIr.setCellValueFactory(new PropertyValueFactory<Persona, String>("rDNI"));
		ColNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("iNombre"));
		ColRazonSocial.setCellValueFactory(new PropertyValueFactory<Persona, String>("iRazonSocial"));
		ColRegistro.setCellValueFactory(new PropertyValueFactory<Persona, String>("nregistro"));
		ColActividad.setCellValueFactory(new PropertyValueFactory<Persona, String>("TipoActividad"));
		ColSuelo.setCellValueFactory(new PropertyValueFactory<Persona, String>("TipoSuelo"));
		ColCatastral.setCellValueFactory(new PropertyValueFactory<Persona, String>("Catastral"));
		ColEmplazamiento.setCellValueFactory(new PropertyValueFactory<Persona, String>("Emplazamiento"));
		ColEstadoLicencia.setCellValueFactory(new PropertyValueFactory<Persona, String>("EstadoLicencia"));
		ColCheck.setCellValueFactory(new PropertyValueFactory<Persona, String>("checkDNI"));
	}

	@FXML
	private void handleNewPerson() {

		//Limpia la tabla antes de actualizarla pero da igual donde lo ponga que explota
		//Tabla.getItems().clear();
		//controlador.select();
		controlador.NewPerson();
		setDatos(personData44);
		Tabla.setItems(this.personData44.getPersonData());
	}

	@FXML
	private void handleDeletePerson() {
		int selectedIndex = Tabla.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			TablePosition pos = Tabla.getSelectionModel().getSelectedCells().get(0);
			int row = pos.getRow();
			// Item here is the table view type:
			Persona item = Tabla.getItems().get(row);
			String colRegistro = ColRegistro.getCellData(item);
			String colDNIi = ColDNIi.getCellData(item);
			String colDNIr = ColDNIr.getCellData(item);
			personData44.Deletes(colRegistro);
			// Borrar solo la solicitud pero no al interesado y representante ??
			personData44.Deletei(colDNIi);
			personData44.Deleter(colDNIr);
			this.personData44.getPersonData().remove(selectedIndex);
			Tabla.setItems(this.personData44.getPersonData());
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			ShowAlertNoSelectionPerson(alert);
		}
		/*
		 * if (selectedIndex >= 0) { this.personData44.Delete(selectedIndex);
		 * //this.personData44.getPersonData().remove(selectedIndex);
		 * Tabla.setItems(this.personData44.getPersonData());
		 * 
		 * } else { // Nothing selected. Alert alert = new
		 * Alert(AlertType.WARNING); ShowAlertNoSelectionPerson(alert); }
		 */
	}

	@FXML
	private void handleDetallePerson() {
		Persona selectedPerson = Tabla.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			int iIndex = Tabla.getSelectionModel().getSelectedIndex();
			controlador.DetallePerson(selectedPerson, iIndex);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			ShowAlertNoSelectionPerson(alert);
		}
		Tabla.setItems(this.personData44.getPersonData());
	}

	private void ShowAlertNoSelectionPerson(Alert alert) {

		alert.setTitle("No Seleccionado");
		alert.setHeaderText("Persona no seleccionada");
		alert.setContentText("Por favor, seleccione una persona de la tabla");
		alert.showAndWait();
	}

	public void limpiar() {
		Tabla.getItems().clear();
		System.out.println("clear");
	}

}
