package vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

public class CnuevaSolicitud {

	@FXML
	private TextField iNombre;
	@FXML
	private TextField iApellido;
	@FXML
	private TextField iRazonSocial;
	@FXML
	private TextField iDNI;
	@FXML
	private TextField iDireccion;
	@FXML
	private TextField iMunicipio;
	@FXML
	private TextField iCP;
	@FXML
	private TextField iTelefono;
	@FXML
	private TextField iMovil;
	@FXML
	private TextField iFax;
	@FXML
	private TextField iCorreo;

	@FXML
	private TextField rNombre;
	@FXML
	private TextField rApellido;
	@FXML
	private TextField rRazonSocial;
	@FXML
	private TextField rDNI;
	@FXML
	private TextField rDireccion;
	@FXML
	private TextField rMunicipio;
	@FXML
	private TextField rCP;
	@FXML
	private TextField rTelefono;
	@FXML
	private TextField rMovil;
	@FXML
	private TextField rFax;
	@FXML
	private TextField rCorreo;

	@FXML
	private TextField nregistro;
	@FXML
	private MenuButton estadoLicencia;
	@FXML
	private DatePicker fechaSolicitud;
	@FXML
	private DatePicker fechaInicio;
	@FXML
	private MenuButton tipoActividad;
	@FXML
	private MenuButton tipoSuelo;
	@FXML
	private TextField cuota;
	@FXML
	private TextField catastral;
	@FXML
	private TextField emplazamiento;
	@FXML
	private TextArea descripcionActividad;

	@FXML
	private CheckBox checkDNI;
	@FXML
	private CheckBox checkImpuestosActividad;
	@FXML
	private CheckBox checkFotografias;
	@FXML
	private CheckBox checkEscritura;
	@FXML
	private CheckBox checkJdePago;
	@FXML
	private CheckBox checkMemoriaActiv;
	@FXML
	private CheckBox checkPlanosLocal;
	@FXML
	private CheckBox checkLicObra;
	@FXML
	private CheckBox checkModeloTecnico;
	@FXML
	private CheckBox checkColegio;
	@FXML
	private CheckBox checkOtrasAut;

	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnAceptar;

	private Stage ventanaDos;
	private Persona persona;
	private Controlador controler;
	private boolean okClicked = false;
	public int aceptar=0;

	public Controlador getControler() {
		return controler;
	}

	public void setControler(Controlador controler) {
		this.controler = controler;
	}

	@FXML
	private void initialize() {
	}

	/**
	 * Establece el Stage de esta ventana para poder cerrarla
	 */
	public void setVentanaDialoge(Stage ventanaDos) {
		this.ventanaDos = ventanaDos;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 */
	public void setPerson(Persona persona) {
		this.persona = persona;
		iNombre.setText(persona.getINombre());
		iApellido.setText(persona.getiApellido());
		iRazonSocial.setText(persona.getIRazonSocial());
		iDNI.setText(persona.getIDNI());
		iDireccion.setText(persona.getiDireccion());
		iMunicipio.setText(persona.getiMunicipio());
		iCP.setText(persona.getiCP());
		iTelefono.setText(persona.getiTelefono());
		iMovil.setText(persona.getiMovil());
		iFax.setText(persona.getiFax());
		iCorreo.setText(persona.getiCorreo());

		rNombre.setText(persona.getrNombre());
		rApellido.setText(persona.getrApellido());
		rRazonSocial.setText(persona.getrRazonSocial());
		rDNI.setText(persona.getRDNI());
		rDireccion.setText(persona.getrDireccion());
		rMunicipio.setText(persona.getrMunicipio());
		rCP.setText(persona.getrCP());
		rTelefono.setText(persona.getrTelefono());
		rMovil.setText(persona.getrMovil());
		rFax.setText(persona.getrFax());
		rCorreo.setText(persona.getrCorreo());

		nregistro.setText(persona.getNregistro());
		estadoLicencia.setText("Estado Inicial de la Licencia");
		fechaSolicitud.setAccessibleText(persona.getFechaSolicitud());
		fechaInicio.setAccessibleText(persona.getFechaInicio());
		tipoActividad.setText("Tipo de Actividad");
		tipoSuelo.setText("Tipo de Suelo");
		cuota.setText(persona.getCuota());
		catastral.setText(persona.getCatastral());
		emplazamiento.setText(persona.getEmplazamiento());
		descripcionActividad.setText(persona.getDescripcionActividad());

		checkDNI.isSelected();
		checkImpuestosActividad.isSelected();
		checkFotografias.isSelected();
		checkEscritura.isSelected();
		checkJdePago.isSelected();
		checkMemoriaActiv.isSelected();
		checkPlanosLocal.isSelected();
		checkLicObra.isSelected();
		checkModeloTecnico.isSelected();
		checkColegio.isSelected();
		checkOtrasAut.isSelected();

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		
		int cdni = 0;
		int cia = 0;
		int cfg = 0;
		int cesc = 0;
		int cjp = 0;
		int cma = 0;
		int cpl = 0;
		int clo = 0;
		int cmt = 0;
		int ccol = 0;
		int coa = 0;
		
		if (checkDNI.isSelected()) {
			cdni = 1;
		} else {
			cdni = 0;
		}

		if (checkImpuestosActividad.isSelected()) {
			cia = 1;
		} else {
			cia = 0;
		}
		if (checkFotografias.isSelected()) {
			cfg = 1;
		} else {
			cfg = 0;
		}
		if (checkEscritura.isSelected()) {
			cesc = 1;
		} else {
			cesc = 0;
		}
		if (checkJdePago.isSelected()) {
			cjp = 1;
		} else {
			cjp = 0;
		}
		if (checkMemoriaActiv.isSelected()) {
			cma = 1;
		} else {
			cma = 0;
		}
		if (checkPlanosLocal.isSelected()) {
			cpl = 1;
		} else {
			cpl = 0;
		}
		if (checkLicObra.isSelected()) {
			clo = 1;
		} else {
			clo = 0;
		}
		if (checkModeloTecnico.isSelected()) {
			cmt = 1;
		} else {
			cmt = 0;
		}
		if (checkColegio.isSelected()) {
			ccol = 1;
		} else {
			ccol = 0;
		}
		if (checkOtrasAut.isSelected()) {
			coa = 1;
		} else {
			coa = 0;
		}
		
		aceptar=1;

		System.out.println(iNombre.getText() + " " + iApellido.getText() + " " + iRazonSocial.getText() + " "
				+ iDNI.getText() + " " + iDireccion.getText() + " " + iMunicipio.getText() + " " + iCP.getText() + " "
				+ iTelefono.getText() + " " + iMovil.getText() + " " + iFax.getText() + " " + iCorreo.getText() + " "
				+ rNombre.getText() + " " + rApellido.getText() + " " + rRazonSocial.getText() + " " + rDNI.getText()
				+ " " + rDireccion.getText() + " " + rMunicipio.getText() + " " + rCP.getText() + " "
				+ rTelefono.getText() + " " + rMovil.getText() + " " + rFax.getText() + " " + rCorreo.getText() + " "
				+ nregistro.getText() + " " + "2017-06-01" + " " + "2017-06-16" + " " + tipoSuelo.getText() + " "
				+ catastral.getText() + " " + emplazamiento.getText() + " " + estadoLicencia.getText() + " "
				+ tipoActividad.getText() + " " + cuota.getText() + " " + descripcionActividad.getText() + " " + cdni
				+ " " + cia + " " + cfg + " " + cesc + " " + cjp + " " + cma + " " + cpl + " " + clo + " " + cmt + " "
				+ ccol + " " + coa + " " + 0 + " " + 0 + " " + 0 + " " + 0 + " ");
		try {
			controler.newPersonInsert(iNombre.getText(), iApellido.getText(), iRazonSocial.getText(), iDNI.getText(),
					iDireccion.getText(), iMunicipio.getText(), iCP.getText(), iTelefono.getText(), iMovil.getText(),
					iFax.getText(), iCorreo.getText(), rNombre.getText(), rApellido.getText(), rRazonSocial.getText(),
					rDNI.getText(), rDireccion.getText(), rMunicipio.getText(), rCP.getText(), rTelefono.getText(),
					rMovil.getText(), rFax.getText(), rCorreo.getText(), nregistro.getText(), "2017-06-01",
					"2017-06-16", tipoSuelo.getText(), catastral.getText(), emplazamiento.getText(),
					estadoLicencia.getText(), tipoActividad.getText(), cuota.getText(), descripcionActividad.getText(),
					cdni, cia, cfg, cesc, cjp, cma, cpl, clo, cmt, ccol, coa, 0, 0, 0, 0);
		} catch (NullPointerException s) {
			s.printStackTrace();
		}
		// okClicked = true;
		ventanaDos.close();

		// System.out.println("A ver que pasa con las fechas ... :" +
		// fechaSolicitud.getAccessibleText());

		/*
		 * if (isInputValid()) { persona.setiNombre(iNombre.getText());
		 * persona.setiApellido(iApellido.getText());
		 * persona.setiDNI(iDNI.getText());
		 * 
		 * 
		 * okClicked = true; ventanaDos.close(); }
		 * 
		 */
	}

	// Cambian el texto de los MenuButton al seleccionar el MenuItem

	@FXML
	private void elSelectedMenuItem1() {
		estadoLicencia.setText("En Trámite");
	}

	@FXML
	private void taSelectedMenuItem1() {
		tipoActividad.setText("Actividades en suelo calificado como industrial");
	}

	@FXML
	private void taSelectedMenuItem2() {
		tipoActividad.setText("Actividades en suelo urbano no calificado como industrial");
	}

	@FXML
	private void taSelectedMenuItem3() {
		tipoActividad.setText("Cajas de Ahorro, Bancos, Entidades Financieras");
	}

	@FXML
	private void taSelectedMenuItem4() {
		tipoActividad.setText("Compañías de seguros y reaseguros, cajas de pensiones");
	}

	@FXML
	private void taSelectedMenuItem5() {
		tipoActividad.setText("Bares, Cafeterías, Restaurantes y similares");
	}

	@FXML
	private void taSelectedMenuItem6() {
		tipoActividad.setText("Salones recreativos y de juegos");
	}

	@FXML
	private void taSelectedMenuItem7() {
		tipoActividad.setText("Establecimientos del sector alimenticio");
	}

	@FXML
	private void taSelectedMenuItem8() {
		tipoActividad.setText("Hoteles, Hostales y Pensiones");
	}

	@FXML
	private void taSelectedMenuItem9() {
		tipoActividad.setText("Terrazas de verano y similares");
	}

	@FXML
	private void taSelectedMenuItem10() {
		tipoActividad.setText("Gasolineras, Depósitos de Combustible y similares");
	}

	@FXML
	private void tsSelectedMenuItem1() {
		tipoSuelo.setText("Suelo Rústico");
	}

	@FXML
	private void tsSelectedMenuItem2() {
		tipoSuelo.setText("Suelo Urbano");
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		ventanaDos.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */

	/*
	 * private boolean isInputValid() { String errorMessage = "";
	 * 
	 * if (iNombre.getText() == null || iNombre.getText().length() == 0) {
	 * errorMessage += "Nombre no válido!\n"; } if (iDNI.getText() == null ||
	 * iDNI.getText().length() == 0) { errorMessage += "Apellido no válido!\n";
	 * } else { // try to parse the postal code into an int. try {
	 * Integer.parseInt(iDNI.getText()); } catch (NumberFormatException e) {
	 * errorMessage += "Teléfono no válido!\n"; } }
	 * 
	 * if (errorMessage.length() == 0) { return true; } else { Alert alert = new
	 * Alert(AlertType.ERROR); alert.setTitle("Error");
	 * alert.setHeaderText("Campos incorrectos!!");
	 * alert.setContentText("Por favor, corrija campos incorrectos");
	 * 
	 * alert.showAndWait(); return false; } }
	 */

}
