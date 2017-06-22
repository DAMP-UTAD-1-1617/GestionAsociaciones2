package vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

public class Cdetalle {

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
	private MenuItem tsRustico;
	@FXML
	private MenuItem tsUrbano;
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
	private CheckBox checkEscrituraCT;
	@FXML
	private CheckBox checkPlanosCT;
	@FXML
	private CheckBox checkLicenciaCT;
	@FXML
	private CheckBox checkNExpeCT;

	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancel;

	private Stage ventanaD;
	private Persona persona;
	private Controlador controler;

	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setVentanaDetalle(Stage ventanaD) {
		this.ventanaD = ventanaD;

	}

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
		estadoLicencia.setText(persona.getEstadoLicencia());
		fechaSolicitud.setAccessibleText(persona.getFechaSolicitud());
		fechaInicio.setAccessibleText(persona.getFechaInicio());
		tipoActividad.setText(persona.getTipoActividad());
		tipoSuelo.setText(persona.getTipoSuelo());
		cuota.setText(persona.getCuota());
		catastral.setText(persona.getCatastral());
		emplazamiento.setText(persona.getEmplazamiento());
		descripcionActividad.setText(persona.getDescripcionActividad());

		// Comprueba si el CheckBox está seleccionado en la base de datos e
		// imprime un tic o no en la vista

		if (persona.isCheckDNI() == true) {
			checkDNI.setSelected(true);
			checkDNI.setIndeterminate(false);
		} else if (persona.isCheckDNI() == false) {
			checkDNI.setSelected(false);
		}

		if (persona.isCheckImpuestosActividad() == true) {
			checkImpuestosActividad.setSelected(true);
			checkImpuestosActividad.setIndeterminate(false);
		} else if (persona.isCheckImpuestosActividad() == false) {
			checkImpuestosActividad.setSelected(false);
		}

		if (persona.isCheckFotografias() == true) {
			checkFotografias.setSelected(true);
			checkFotografias.setIndeterminate(false);
		} else if (persona.isCheckFotografias() == false) {
			checkFotografias.setSelected(false);
		}

		if (persona.isCheckEscritura() == true) {
			checkEscritura.setSelected(true);
			checkEscritura.setIndeterminate(false);
		} else if (persona.isCheckEscritura() == false) {
			checkEscritura.setSelected(false);
		}

		if (persona.isCheckJdePago() == true) {
			checkJdePago.setSelected(true);
			checkJdePago.setIndeterminate(false);
		} else if (persona.isCheckJdePago() == false) {
			checkJdePago.setSelected(false);
		}

		if (persona.isCheckMemoriaActiv() == true) {
			checkMemoriaActiv.setSelected(true);
			checkMemoriaActiv.setIndeterminate(false);
		} else if (persona.isCheckMemoriaActiv() == false) {
			checkMemoriaActiv.setSelected(false);
		}

		if (persona.isCheckPlanosLocal() == true) {
			checkPlanosLocal.setSelected(true);
			checkPlanosLocal.setIndeterminate(false);
		} else if (persona.isCheckPlanosLocal() == false) {
			checkPlanosLocal.setSelected(false);
		}

		if (persona.isCheckLicObra() == true) {
			checkLicObra.setSelected(true);
			checkLicObra.setIndeterminate(false);
		} else if (persona.isCheckLicObra() == false) {
			checkLicObra.setSelected(false);
		}

		if (persona.isCheckModeloTecnico() == true) {
			checkModeloTecnico.setSelected(true);
			checkModeloTecnico.setIndeterminate(false);
		} else if (persona.isCheckModeloTecnico() == false) {
			checkModeloTecnico.setSelected(false);
		}

		if (persona.isCheckColegio() == true) {
			checkColegio.setSelected(true);
			checkColegio.setIndeterminate(false);
		} else if (persona.isCheckColegio() == false) {
			checkColegio.setSelected(false);
		}

		if (persona.isCheckOtrasAut() == true) {
			checkOtrasAut.setSelected(true);
			checkOtrasAut.setIndeterminate(false);
		} else if (persona.isCheckOtrasAut() == false) {
			checkOtrasAut.setSelected(false);
		}

		if (persona.isCheckEscrituraCT() == true) {
			checkEscrituraCT.setSelected(true);
			checkEscrituraCT.setIndeterminate(false);
		} else if (persona.isCheckEscrituraCT() == false) {
			checkEscrituraCT.setSelected(false);
		}

		if (persona.isCheckPlanosCT() == true) {
			checkPlanosCT.setSelected(true);
			checkPlanosCT.setIndeterminate(false);
		} else if (persona.isCheckPlanosCT() == false) {
			checkPlanosCT.setSelected(false);
		}
		if (persona.isCheckLicenciaCT() == true) {
			checkLicenciaCT.setSelected(true);
			checkLicenciaCT.setIndeterminate(false);
		} else if (persona.isCheckLicenciaCT() == false) {
			checkLicenciaCT.setSelected(false);
		}
		if (persona.isCheckNExpeCT() == true) {
			checkNExpeCT.setSelected(true);
			checkNExpeCT.setIndeterminate(false);
		} else if (persona.isCheckNExpeCT() == false) {
			checkNExpeCT.setSelected(false);
		}

		System.out.println(" checkDNI " + persona.isCheckDNI());
	}

	public boolean isOkClicked() {
		return okClicked;
	}

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
		int cep = 0;
		int cpd = 0;
		int cda = 0;
		int cne = 0;

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
		if (checkEscrituraCT.isSelected()) {
			cep = 1;
		} else {
			cep = 0;
		}
		if (checkPlanosCT.isSelected()) {
			cpd = 1;
		} else {
			cpd = 0;
		}
		if (checkLicenciaCT.isSelected()) {
			cda = 1;
		} else {
			cda = 0;
		}
		if (checkNExpeCT.isSelected()) {
			cne = 1;
		} else {
			cne = 0;
		}

		try {
			System.out.println("editpersoninsert");
			controler.editPersonInsert(iNombre.getText(), iApellido.getText(), iRazonSocial.getText(), iDNI.getText(),
					iDireccion.getText(), iMunicipio.getText(), iCP.getText(), iTelefono.getText(), iMovil.getText(),
					iFax.getText(), iCorreo.getText(), rNombre.getText(), rApellido.getText(), rRazonSocial.getText(),
					rDNI.getText(), rDireccion.getText(), rMunicipio.getText(), rCP.getText(), rTelefono.getText(),
					rMovil.getText(), rFax.getText(), rCorreo.getText(), nregistro.getText(), "2017-06-01",
					"2017-06-16", tipoSuelo.getText(), catastral.getText(), emplazamiento.getText(),
					estadoLicencia.getText(), tipoActividad.getText(), cuota.getText(), descripcionActividad.getText(),
					cdni, cia, cfg, cesc, cjp, cma, cpl, clo, cmt, ccol, coa, cep, cpd, cda, cne);
		} catch (NullPointerException s) {
			s.printStackTrace();
		}
		
		okClicked = true;
		ventanaD.close();

	}

	// Cambian el texto de los MenuButton al seleccionar el MenuItem

	@FXML
	private void elSelectedMenuItem1() {
		estadoLicencia.setText("En Trámite");
	}

	public Controlador getControler() {
		return controler;
	}

	public void setControler(Controlador controler) {
		this.controler = controler;
	}

	@FXML
	private void elSelectedMenuItem2() {
		estadoLicencia.setText("Caducada");
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

	// Cuando se pulsa el boton de cancelar se cierra la ventana
	@FXML
	private void handleCancel() {
		ventanaD.close();
	}

}
