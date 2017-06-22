package controlador;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.ConexionSQL;
import modelo.Persona;
import vista.Cdetalle;
import vista.CnuevaSolicitud;
import vista.CventanaPrincipal;

public class Controlador {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private ConexionSQL modelo;
	private CventanaPrincipal detalle;

	public void AbrirVentanaPrincipal(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/ventanaPrincipal.fxml"));
			rootLayout = (AnchorPane) loader.load();
			// Give the controller access to the main app.
			CventanaPrincipal vistacontroller = loader.getController();
			vistacontroller.setVentanaPrincipal(this);
			vistacontroller.setDatos(modelo);
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rotti");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean showPersonEditDialog(Persona person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/nuevaSolicitud.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Contacto");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CnuevaSolicitud controller = loader.getController();
			controller.setControler(this);
			controller.setVentanaDialoge(dialogStage);
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean AbrirDetalle(Persona person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/detalle.fxml"));
			AnchorPane page = (AnchorPane) loader.load(); /**/

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Contacto");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			Cdetalle controller = loader.getController();
			controller.setControler(this);
			controller.setVentanaDetalle(dialogStage);
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void NewPerson() {
		Persona personNew = new Persona(null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, false, false, false, false, false, false, false, false, false, false, false, false, false,
				false, false);
		if (showPersonEditDialog(personNew)) {
		}

	}

	public void newPersonInsert(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo, String rNombre,
			String rApellido, String rRazonSocial, String rDNI, String rDireccion, String rMunicipio, String rCP,
			String rTelefono, String rMovil, String rFax, String rCorreo, String nregistro, String fechaSolicitud,
			String fechaInicio, String tipoSuelo, String catastral, String emplazamiento, String estadoLicencia,
			String tipoActividad, String cuota, String descripcionActividad, int checkDNI, int checkImpuestosActividad,
			int checkFotografias, int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal,
			int checkLicObra, int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT,
			int checkPlanosCT, int checkLicenciaCT, int checkNExpeCT) {
		this.modelo.addPerson(iNombre, iApellido, iRazonSocial, iDNI, iDireccion, iMunicipio, iCP, iTelefono, iMovil,
				iFax, iCorreo, rNombre, rApellido, rRazonSocial, rDNI, rDireccion, rMunicipio, rCP, rTelefono, rMovil,
				rFax, rCorreo, nregistro, fechaSolicitud, fechaInicio, tipoSuelo, catastral, emplazamiento,
				estadoLicencia, tipoActividad, cuota, descripcionActividad, checkDNI, checkImpuestosActividad,
				checkFotografias, checkEscritura, checkJdePago, checkMemoriaActiv, checkPlanosLocal, checkLicObra,
				checkModeloTecnico, checkColegio, checkOtrasAut, checkEscrituraCT, checkPlanosCT, checkLicenciaCT,
				checkNExpeCT);
		System.out.println("EXPLOTOOOOO");
		select();
	}

	public void editPersonInsert(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo, String rNombre,
			String rApellido, String rRazonSocial, String rDNI, String rDireccion, String rMunicipio, String rCP,
			String rTelefono, String rMovil, String rFax, String rCorreo, String nregistro, String fechaSolicitud,
			String fechaInicio, String tipoSuelo, String catastral, String emplazamiento, String estadoLicencia,
			String tipoActividad, String cuota, String descripcionActividad, int checkDNI, int checkImpuestosActividad,
			int checkFotografias, int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal,
			int checkLicObra, int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT,
			int checkPlanosCT, int checkLicenciaCT, int checkNExpeCT) {
		this.modelo.editPerson(iNombre, iApellido, iRazonSocial, iDNI, iDireccion, iMunicipio, iCP, iTelefono, iMovil,
				iFax, iCorreo, rNombre, rApellido, rRazonSocial, rDNI, rDireccion, rMunicipio, rCP, rTelefono, rMovil,
				rFax, rCorreo, nregistro, fechaSolicitud, fechaInicio, tipoSuelo, catastral, emplazamiento,
				estadoLicencia, tipoActividad, cuota, descripcionActividad, checkDNI, checkImpuestosActividad,
				checkFotografias, checkEscritura, checkJdePago, checkMemoriaActiv, checkPlanosLocal, checkLicObra,
				checkModeloTecnico, checkColegio, checkOtrasAut, checkEscrituraCT, checkPlanosCT, checkLicenciaCT,
				checkNExpeCT);
		
		modelo.SELECTDatos();
		System.out.println("select ----------------->");
	}

	public void setpersonData1(ConexionSQL modelo) {
		this.modelo = modelo;
	}

	public void DetallePerson(Persona person, int iIndex) {
		if (AbrirDetalle(person)) {
			modelo.getPersonData().set(iIndex, person);
		}
	}
	
	public void select(){
		modelo.SELECTDatos();
	}
}
