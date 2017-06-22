package modelo;

public class Persona {

	private String iNombre;
	private String iApellido;
	private String iRazonSocial;
	private String iDNI;
	private String iDireccion;
	private String iMunicipio;
	private String iCP;
	private String iTelefono;
	private String iMovil;
	private String iFax;
	private String iCorreo;

	private String rNombre;
	private String rApellido;
	private String rRazonSocial;
	private String rDNI;
	private String rDireccion;
	private String rMunicipio;
	private String rCP;
	private String rTelefono;
	private String rMovil;
	private String rFax;
	private String rCorreo;

	private String nregistro;
	private String estadoLicencia;
	// HAY QUE COMPROBAR SI LAS FECHAS LAS PONEMOS COMO DATE O STRING
	private String fechaSolicitud;
	private String fechaInicio;
	// ****************
	private String tipoActividad;
	private String tipoSuelo;
	private String cuota;
	private String catastral;
	private String emplazamiento;
	private String descripcionActividad;

	private boolean checkDNI;
	private boolean checkImpuestosActividad;
	private boolean checkFotografias;
	private boolean checkEscritura;
	private boolean checkJdePago;
	private boolean checkMemoriaActiv;
	private boolean checkPlanosLocal;
	private boolean checkLicObra;
	private boolean checkModeloTecnico;
	private boolean checkColegio;
	private boolean checkOtrasAut;

	private boolean checkEscrituraCT;
	private boolean checkPlanosCT;
	private boolean checkLicenciaCT;
	private boolean checkNExpeCT;

	// Constructor con los campos de una nueva solicitud

	public Persona(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo, String rNombre,
			String rApellido, String rRazonSocial, String rDNI, String rDireccion, String rMunicipio, String rCP,
			String rTelefono, String rMovil, String rFax, String rCorreo, String nregistro, String estadoLicencia,
			String fechaSolicitud, String fechaInicio, String tipoActividad, String tipoSuelo, String cuota,
			String catastral, String emplazamiento, String descripcionActividad, boolean checkDNI,
			boolean checkImpuestosActividad, boolean checkFotografias, boolean checkEscritura, boolean checkJdePago,
			boolean checkMemoriaActiv, boolean checkPlanosLocal, boolean checkLicObra, boolean checkModeloTecnico,
			boolean checkColegio, boolean checkOtrasAut, boolean checkEscrituraCT, boolean checkPlanosCT,
			boolean checkLicenciaCT, boolean checkNExpeCT) {

		
		
		//System.out.println();
		this.iNombre = iNombre;
		this.iApellido = iApellido;
		this.iRazonSocial = iRazonSocial;
		this.iDNI = iDNI;
		this.iDireccion = iDireccion;
		this.iMunicipio = iMunicipio;
		this.iCP = iCP;
		this.iTelefono = iTelefono;
		this.iMovil = iMovil;
		this.iFax = iFax;
		this.iCorreo = iCorreo;

		this.rNombre = rNombre;
		this.rApellido = rApellido;
		this.rRazonSocial = rRazonSocial;
		this.rDNI = rDNI;
		this.rDireccion = rDireccion;
		this.rMunicipio = rMunicipio;
		this.rCP = rCP;
		this.rTelefono = rTelefono;
		this.rMovil = rMovil;
		this.rFax = rFax;
		this.rCorreo = rCorreo;

		this.nregistro = nregistro;
		this.estadoLicencia = estadoLicencia;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.tipoActividad = tipoActividad;
		this.tipoSuelo = tipoSuelo;
		this.cuota = cuota;
		this.catastral = catastral;
		this.emplazamiento = emplazamiento;
		this.descripcionActividad = descripcionActividad;

		this.checkDNI = checkDNI;
		this.checkImpuestosActividad = checkImpuestosActividad;
		this.checkFotografias = checkFotografias;
		this.checkEscritura = checkEscritura;
		this.checkJdePago = checkJdePago;
		this.checkMemoriaActiv = checkMemoriaActiv;
		this.checkPlanosLocal = checkPlanosLocal;
		this.checkLicObra = checkLicObra;
		this.checkModeloTecnico = checkModeloTecnico;
		this.checkColegio = checkColegio;
		this.checkOtrasAut = checkOtrasAut;

		this.checkEscrituraCT = checkEscrituraCT;
		this.checkPlanosCT = checkPlanosCT;
		this.checkLicenciaCT = checkLicenciaCT;
		this.checkNExpeCT = checkNExpeCT;

	}
	
	// Getters & Setters

	public String getINombre() {
		return iNombre;
	}

	public void setINombre(String iNombre) {
		this.iNombre = iNombre;
	}

	public String getiApellido() {
		return iApellido;
	}

	public void setiApellido(String iApellido) {
		this.iApellido = iApellido;
	}

	public String getIRazonSocial() {
		return iRazonSocial;
	}

	public void setIRazonSocial(String iRazonSocial) {
		this.iRazonSocial = iRazonSocial;
	}

	public String getIDNI() {
		return iDNI;
	}

	public void setIDNI(String iDNI) {
		this.iDNI = iDNI;
	}

	public String getiDireccion() {
		return iDireccion;
	}

	public void setiDireccion(String iDireccion) {
		this.iDireccion = iDireccion;
	}

	public String getiMunicipio() {
		return iMunicipio;
	}

	public void setiMunicipio(String iMunicipio) {
		this.iMunicipio = iMunicipio;
	}

	public String getiCP() {
		return iCP;
	}

	public void setiCP(String iCP) {
		this.iCP = iCP;
	}

	public String getiTelefono() {
		return iTelefono;
	}

	public void setiTelefono(String iTelefono) {
		this.iTelefono = iTelefono;
	}

	public String getiMovil() {
		return iMovil;
	}

	public void setiMovil(String iMovil) {
		this.iMovil = iMovil;
	}

	public String getiFax() {
		return iFax;
	}

	public void setiFax(String iFax) {
		this.iFax = iFax;
	}

	public String getiCorreo() {
		return iCorreo;
	}

	public void setiCorreo(String iCorreo) {
		this.iCorreo = iCorreo;
	}

	public String getrNombre() {
		return rNombre;
	}

	public void setrNombre(String rNombre) {
		this.rNombre = rNombre;
	}

	public String getrApellido() {
		return rApellido;
	}

	public void setrApellido(String rApellido) {
		this.rApellido = rApellido;
	}

	public String getrRazonSocial() {
		return rRazonSocial;
	}

	public void setrRazonSocial(String rRazonSocial) {
		this.rRazonSocial = rRazonSocial;
	}

	public String getRDNI() {
		return rDNI;
	}
	
	public void setRDNI(String rDNI) {
		this.rDNI = rDNI;
	}

	public String getrDireccion() {
		return rDireccion;
	}

	public void setrDireccion(String rDireccion) {
		this.rDireccion = rDireccion;
	}

	public String getrMunicipio() {
		return rMunicipio;
	}

	public void setrMunicipio(String rMunicipio) {
		this.rMunicipio = rMunicipio;
	}

	public String getrCP() {
		return rCP;
	}

	public void setrCP(String rCP) {
		this.rCP = rCP;
	}

	public String getrTelefono() {
		return rTelefono;
	}

	public void setrTelefono(String rTelefono) {
		this.rTelefono = rTelefono;
	}

	public String getrMovil() {
		return rMovil;
	}

	public void setrMovil(String rMovil) {
		this.rMovil = rMovil;
	}

	public String getrFax() {
		return rFax;
	}

	public void setrFax(String rFax) {
		this.rFax = rFax;
	}

	public String getrCorreo() {
		return rCorreo;
	}

	public void setrCorreo(String rCorreo) {
		this.rCorreo = rCorreo;
	}

	public String getNregistro() {
		return nregistro;
	}

	public void setNregistro(String nregistro) {
		this.nregistro = nregistro;
	}

	public String getEstadoLicencia() {
		return estadoLicencia;
	}

	public void setEstadoLicencia(String estadoLicencia) {
		this.estadoLicencia = estadoLicencia;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getTipoSuelo() {
		return tipoSuelo;
	}

	public void setTipoSuelo(String tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}

	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getCatastral() {
		return catastral;
	}

	public void setCatastral(String catastral) {
		this.catastral = catastral;
	}

	public String getEmplazamiento() {
		return emplazamiento;
	}

	public void setEmplazamiento(String emplazamiento) {
		this.emplazamiento = emplazamiento;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public boolean isCheckDNI() {
		return checkDNI;
	}

	public void setCheckDNI(boolean checkDNI) {
		this.checkDNI = checkDNI;
	}

	public boolean isCheckImpuestosActividad() {
		return checkImpuestosActividad;
	}

	public void setCheckImpuestosActividad(boolean checkImpuestosActividad) {
		this.checkImpuestosActividad = checkImpuestosActividad;
	}

	public boolean isCheckFotografias() {
		return checkFotografias;
	}

	public void setCheckFotografias(boolean checkFotografias) {
		this.checkFotografias = checkFotografias;
	}

	public boolean isCheckEscritura() {
		return checkEscritura;
	}

	public void setCheckEscritura(boolean checkEscritura) {
		this.checkEscritura = checkEscritura;
	}

	public boolean isCheckJdePago() {
		return checkJdePago;
	}

	public void setCheckJdePago(boolean checkJdePago) {
		this.checkJdePago = checkJdePago;
	}

	public boolean isCheckMemoriaActiv() {
		return checkMemoriaActiv;
	}

	public void setCheckMemoriaActiv(boolean checkMemoriaActiv) {
		this.checkMemoriaActiv = checkMemoriaActiv;
	}

	public boolean isCheckPlanosLocal() {
		return checkPlanosLocal;
	}

	public void setCheckPlanosLocal(boolean checkPlanosLocal) {
		this.checkPlanosLocal = checkPlanosLocal;
	}

	public boolean isCheckLicObra() {
		return checkLicObra;
	}

	public void setCheckLicObra(boolean checkLicObra) {
		this.checkLicObra = checkLicObra;
	}

	public boolean isCheckModeloTecnico() {
		return checkModeloTecnico;
	}

	public void setCheckModeloTecnico(boolean checkModeloTecnico) {
		this.checkModeloTecnico = checkModeloTecnico;
	}

	public boolean isCheckColegio() {
		return checkColegio;
	}

	public void setCheckColegio(boolean checkColegio) {
		this.checkColegio = checkColegio;
	}

	public boolean isCheckOtrasAut() {
		return checkOtrasAut;
	}

	public void setCheckOtrasAut(boolean checkOtrasAut) {
		this.checkOtrasAut = checkOtrasAut;
	}

	public boolean isCheckEscrituraCT() {
		return checkEscrituraCT;
	}

	public void setCheckEscrituraCT(boolean checkEscrituraCT) {
		this.checkEscrituraCT = checkEscrituraCT;
	}

	public boolean isCheckPlanosCT() {
		return checkPlanosCT;
	}

	public void setCheckPlanosCT(boolean checkPlanosCT) {
		this.checkPlanosCT = checkPlanosCT;
	}

	public boolean isCheckLicenciaCT() {
		return checkLicenciaCT;
	}

	public void setCheckLicenciaCT(boolean checkLicenciaCT) {
		this.checkLicenciaCT = checkLicenciaCT;
	}

	public boolean isCheckNExpeCT() {
		return checkNExpeCT;
	}

	public void setCheckNExpeCT(boolean checkNExpeCT) {
		this.checkNExpeCT = checkNExpeCT;
	}

}
