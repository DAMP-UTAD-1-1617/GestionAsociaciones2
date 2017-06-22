package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionSQL {

	private Properties config;
	private File miFichero;
	private InputStream entrada;
	private OutputStream salida;
	private Connection connection;

	public ObservableList<Persona> personData = FXCollections.observableArrayList();

	public ConexionSQL() {

	}

	public void CargarBBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		// System.out.println(System.getProperty("user.dir"));
		config = new Properties();
		try {
			miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				config.load(entrada);
			} else {
				System.err.println("Fichero no encontrado");
				System.exit(1);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// obtenemos las propiedades y las imprimimos
		String user = config.getProperty("Usuario");
		String pass = config.getProperty("Pass");
		String url = config.getProperty("Url");
		System.out.println("Fichero cargado: " + user + " " + pass + " " + url);

		connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);

			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/gestlic",
			// "root", "");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public String[][] SELECTDatos() {
		String resultados[][] = null;
		try {

			PreparedStatement pstmt = connection

					.prepareStatement("SELECT * FROM solicitud "
							+ "JOIN representante ON solicitud.dni_rep = representante.dni_rep "
							+ "JOIN interesado ON solicitud.dni_int = interesado.dni_int");
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int z = 0;
			while (rset.next()) {
				System.out.println(rset.getString("interesado.nombre") + " " + rset.getString("interesado.apellido")
						+ " " + rset.getString("interesado.razonsocial") + " " + rset.getString("interesado.dni_int")
						+ " " + rset.getString("interesado.direccion") + " " + rset.getString("interesado.municipio")
						+ " " + rset.getString("interesado.codigopostal") + " " + rset.getString("interesado.telefono")
						+ " " + rset.getString("interesado.movil") + " " + rset.getString("interesado.fax") + " "
						+ rset.getString("interesado.correo") + " " + rset.getString("representante.dni_rep") + " "
						+ rset.getString("representante.nombre") + " " + rset.getString("representante.apellido") + " "
						+ rset.getString("representante.razonsocial") + " " + rset.getString("representante.direccion")
						+ " " + rset.getString("representante.municipio") + " "
						+ rset.getString("representante.codigopostal") + " " + rset.getString("representante.telefono")
						+ " " + rset.getString("representante.movil") + " " + rset.getString("representante.fax") + " "
						+ rset.getString("representante.correo") + " " + rset.getString("solicitud.num_sol") + " "
						+ rset.getString("solicitud.estadolicencia") + " " + rset.getString("solicitud.fsolicitud")
						+ " " + rset.getString("solicitud.finicio") + " " + rset.getString("solicitud.tipoactiv") + " "
						+ rset.getString("solicitud.cdni") + " " + rset.getString("solicitud.cimpuestos") + " "
						+ rset.getString("solicitud.cfotos") + " " + rset.getString("solicitud.cescritura") + " "
						+ rset.getString("solicitud.cpago") + " " + rset.getString("solicitud.cmemoriaact") + " "
						+ rset.getString("solicitud.cplanosloc") + " " + rset.getString("solicitud.clicobra") + " "
						+ rset.getString("solicitud.cmodelotec") + " " + rset.getString("solicitud.ccolegio") + " "
						+ rset.getString("solicitud.cotras") + " " + rset.getString("solicitud.cescrituract") + " "
						+ rset.getString("solicitud.cplanosct") + " " + rset.getString("solicitud.clicenciasct") + " "
						+ rset.getString("solicitud.cnexpect"));
				z += 1;
			}

			rset.first();
			rset = pstmt.executeQuery();
			int i = 0;
			resultados = new String[z][rsmd.getColumnCount()];
			while (rset.next()) {
				String fila[] = new String[rsmd.getColumnCount()];
				fila[0] = rset.getString("interesado.nombre");
				fila[1] = rset.getString("apellido");
				fila[2] = rset.getString("razonsocial");
				fila[3] = rset.getString("dni_int");
				fila[4] = rset.getString("direccion");
				fila[5] = rset.getString("municipio");
				fila[6] = rset.getString("codigopostal");
				fila[7] = rset.getString("telefono");
				fila[8] = rset.getString("movil");
				fila[9] = rset.getString("fax");
				fila[10] = rset.getString("correo");

				fila[11] = rset.getString("representante.nombre");
				fila[12] = rset.getString("apellido");
				fila[13] = rset.getString("razonsocial");
				fila[14] = rset.getString("dni_rep");
				fila[15] = rset.getString("direccion");
				fila[16] = rset.getString("municipio");
				fila[17] = rset.getString("codigopostal");
				fila[18] = rset.getString("telefono");
				fila[19] = rset.getString("movil");
				fila[20] = rset.getString("fax");
				fila[21] = rset.getString("correo");

				fila[22] = rset.getString("num_sol");
				fila[23] = rset.getString("estadolicencia");
				fila[24] = rset.getString("fsolicitud");
				fila[25] = rset.getString("finicio");
				fila[26] = rset.getString("tipoactiv");
				fila[27] = rset.getString("tiposuelo");
				fila[28] = rset.getString("cuota");
				fila[29] = rset.getString("rcatastral");
				fila[30] = rset.getString("emplazamiento");
				fila[31] = rset.getString("tipoactiv");

				Boolean check[] = new Boolean[rsmd.getColumnCount()];

				check[1] = rset.getBoolean("solicitud.cdni");
				check[2] = rset.getBoolean("solicitud.cimpuestos");
				check[3] = rset.getBoolean("solicitud.cfotos");
				check[4] = rset.getBoolean("solicitud.cescritura");
				check[5] = rset.getBoolean("solicitud.cpago");
				check[6] = rset.getBoolean("solicitud.cmemoriaact");
				check[7] = rset.getBoolean("solicitud.cplanosloc");
				check[8] = rset.getBoolean("solicitud.clicobra");
				check[9] = rset.getBoolean("solicitud.cmodelotec");
				check[10] = rset.getBoolean("solicitud.ccolegio");
				check[11] = rset.getBoolean("solicitud.cotras");
				check[12] = rset.getBoolean("solicitud.cescrituract");
				check[13] = rset.getBoolean("solicitud.cplanosct");
				check[14] = rset.getBoolean("solicitud.clicenciasct");
				check[15] = rset.getBoolean("solicitud.cnexpect");

				resultados[i] = fila;

				this.personData.add(new Persona(fila[0], fila[1], fila[2], fila[3], fila[4], fila[5], fila[6], fila[7],
						fila[8], fila[9], fila[10], fila[11], fila[12], fila[13], fila[14], fila[15], fila[16],
						fila[17], fila[18], fila[19], fila[20], fila[21], fila[22], fila[23], fila[24], fila[25],
						fila[26], fila[27], fila[28], fila[29], fila[30], fila[31], check[1], check[2], check[3],
						check[4], check[5], check[6], check[7], check[8], check[9], check[10], check[11], check[12],
						check[13], check[14], check[15]));
				i++;
			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return resultados;
	}

	public int insertarDatosi(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "INSERT INTO interesado(dni_int, nombre, apellido, razonsocial, direccion, municipio,"
					+ " codigopostal, telefono, movil, fax, correo) VALUES ('" + iDNI + "','" + iNombre + "','"
					+ iApellido + "','" + iRazonSocial + "','" + iDireccion + "','" + iMunicipio + "','" + iCP + "','"
					+ iTelefono + "','" + iMovil + "','" + iFax + "','" + iCorreo + "')";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			System.out.println("GETINTTTTT");
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int insertarDatosr(String rNombre, String rApellido, String rRazonSocial, String rDNI, String rDireccion,
			String rMunicipio, String rCP, String rTelefono, String rMovil, String rFax, String rCorreo) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "INSERT INTO representante(dni_rep, nombre, apellido, razonsocial, direccion, municipio,"
					+ " codigopostal, telefono, movil, fax, correo) VALUES ('" + rDNI + "','" + rNombre + "','"
					+ rApellido + "','" + rRazonSocial + "','" + rDireccion + "','" + rMunicipio + "','" + rCP + "','"
					+ rTelefono + "','" + rMovil + "','" + rFax + "','" + rCorreo + "')";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int insertarDatoss(String nregistro, String fechaSolicitud, String fechaInicio, String tipoSuelo,
			String catastral, String emplazamiento, String estadoLicencia, String tipoActividad, String cuota,
			String descripcionActividad, int checkDNI, int checkImpuestosActividad, int checkFotografias,
			int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal, int checkLicObra,
			int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT, int checkPlanosCT,
			int checkLicenciaCT, int checkNExpeCT, String iDNI, String rDNI) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "INSERT INTO solicitud(num_sol, fsolicitud, finicio, tiposuelo, rcatastral, emplazamiento,"
					+ " estadolicencia, tipoactiv, cuota, descripactiv, cdni, cimpuestos, cfotos, cescritura, cpago, cmemoriaact,"
					+ " cplanosloc, clicobra, cmodelotec, ccolegio, cotras, cescrituract, cplanosct, clicenciasct, cnexpect"
					+ ", dni_int, dni_rep) VALUES ('" + nregistro + "','" + fechaSolicitud + "','" + fechaInicio + "','"
					+ tipoSuelo + "','" + catastral + "','" + emplazamiento + "','" + estadoLicencia + "','"
					+ tipoActividad + "','" + cuota + "','" + descripcionActividad + "','" + checkDNI + "','"
					+ checkImpuestosActividad + "','" + checkFotografias + "','" + checkEscritura + "','" + checkJdePago
					+ "','" + checkMemoriaActiv + "','" + checkPlanosLocal + "','" + checkLicObra + "','"
					+ checkModeloTecnico + "','" + checkColegio + "','" + checkOtrasAut + "','" + checkEscrituraCT
					+ "','" + checkPlanosCT + "','" + checkLicenciaCT + "','" + checkNExpeCT + "','" + iDNI + "','"
					+ rDNI + "')";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int Deletes(String nregistro) {
		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}
		int idNuevo = -1;
		try {
			String query = "DELETE FROM solicitud WHERE solicitud.num_sol = '" + nregistro + "';";

			System.out.println("MI QUERY Solicitud ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int Deleter(String rDNI) {
		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}
		int idNuevo = -1;
		try {
			String query = "DELETE FROM representante WHERE representante.dni_rep = '" + rDNI + "';";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int Deletei(String iDNI) {
		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}
		int idNuevo = -1;
		try {
			String query = "DELETE FROM interesado WHERE interesado.dni_int = '" + iDNI + "';";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int updateDatosi(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "UPDATE interesado SET dni_int='" + iDNI + "',nombre='" + iNombre + "',apellido='"
					+ iApellido + "',razonsocial='" + iRazonSocial + "',direccion='" + iDireccion + "',municipio='"
					+ iMunicipio + "',codigopostal='" + iCP + "',telefono='" + iTelefono + "',movil='" + iMovil
					+ "',fax='" + iFax + "',correo='" + iCorreo + "' WHERE interesado.dni_int='" + iDNI + "';";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			System.out.println("GETINTTTTT");
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int updateDatosr(String rNombre, String rApellido, String rRazonSocial, String rDNI, String rDireccion,
			String rMunicipio, String rCP, String rTelefono, String rMovil, String rFax, String rCorreo) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "UPDATE representante SET dni_rep='" + rDNI + "',nombre='" + rNombre + "',apellido='"
					+ rApellido + "',razonsocial='" + rRazonSocial + "',direccion='" + rDireccion + "',municipio='"
					+ rMunicipio + "',codigopostal='" + rCP + "',telefono='" + rTelefono + "',movil='" + rMovil
					+ "',fax='" + rFax + "',correo='" + rCorreo + "' WHERE representante.dni_rep='" + rDNI + "';";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	public int updateDatoss(String nregistro, String fechaSolicitud, String fechaInicio, String tipoSuelo,
			String catastral, String emplazamiento, String estadoLicencia, String tipoActividad, String cuota,
			String descripcionActividad, int checkDNI, int checkImpuestosActividad, int checkFotografias,
			int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal, int checkLicObra,
			int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT, int checkPlanosCT,
			int checkLicenciaCT, int checkNExpeCT, String iDNI, String rDNI) {

		if (connection == null) {
			System.out.println("NO EXISTE");
			System.exit(-1);
		}

		int idNuevo = -1;
		try {
			String query = "UPDATE solicitud SET num_sol='" + nregistro + "',fsolicitud='" + fechaSolicitud
					+ "',finicio='" + fechaInicio + "',tiposuelo='" + tipoSuelo + "',rcatastral='" + catastral
					+ "',emplazamiento='" + emplazamiento + "',tipoactiv='" + tipoActividad + "',cuota='" + cuota
					+ "',descripactiv='" + descripcionActividad + "',cdni='" + checkDNI + "',cimpuestos='"
					+ checkImpuestosActividad + "',cfotos='" + checkFotografias + "',cescritura='" + checkEscritura
					+ "',cpago='" + checkJdePago + "',cmemoriaact='" + checkJdePago + "',cplanosloc='"
					+ checkMemoriaActiv + "',clicobra='" + checkLicObra + "',cmodelotec='" + checkModeloTecnico
					+ "',ccolegio='" + checkColegio + "',cotras='" + checkOtrasAut + "',cescrituract='"
					+ checkEscrituraCT + "',cplanosct='" + checkPlanosCT + "',clicenciasct='" + checkLicenciaCT
					+ "',cnexpect='" + checkNExpeCT + "',dni_int='" + iDNI + "',dni_rep='" + rDNI
					+ "' WHERE solicitud.num_sol='" + nregistro + "';";

			System.out.println("MI QUERY ES: " + query);
			PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			if (tableKeys.next()) {
				idNuevo = tableKeys.getInt(1);
				// System.out.print("query executed");
			}
			System.out.println("ID NUEVO : " + idNuevo);
			if (pstmt != null)
				pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

		return idNuevo;
	}

	// Getters y Setters

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public File getMiFichero() {
		return miFichero;
	}

	public void setMiFichero(File miFichero) {
		this.miFichero = miFichero;
	}

	public InputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(InputStream entrada) {
		this.entrada = entrada;
	}

	public OutputStream getSalida() {
		return salida;
	}

	public void setSalida(OutputStream salida) {
		this.salida = salida;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ObservableList<Persona> getPersonData() {
		return personData;
	}

	public void setPersonData(ObservableList<Persona> personData) {
		this.personData = personData;
	}

	public void addPerson(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo, String rNombre,
			String rApellido, String rRazonSocial, String rDNI, String rDireccion, String rMunicipio, String rCP,
			String rTelefono, String rMovil, String rFax, String rCorreo, String nregistro, String fechaSolicitud,
			String fechaInicio, String tipoSuelo, String catastral, String emplazamiento, String estadoLicencia,
			String tipoActividad, String cuota, String descripcionActividad, int checkDNI, int checkImpuestosActividad,
			int checkFotografias, int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal,
			int checkLicObra, int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT,
			int checkPlanosCT, int checkLicenciaCT, int checkNExpeCT) {

		insertarDatosi(iNombre, iApellido, iRazonSocial, iDNI, iDireccion, iMunicipio, iCP, iTelefono, iMovil, iFax,
				iCorreo);
		insertarDatosr(rNombre, rApellido, rRazonSocial, rDNI, rDireccion, rMunicipio, rCP, rTelefono, rMovil, rFax,
				rCorreo);
		insertarDatoss(nregistro, fechaSolicitud, fechaInicio, tipoSuelo, catastral, emplazamiento, estadoLicencia,
				tipoActividad, cuota, descripcionActividad, checkDNI, checkImpuestosActividad, checkFotografias,
				checkEscritura, checkJdePago, checkMemoriaActiv, checkPlanosLocal, checkLicObra, checkModeloTecnico,
				checkColegio, checkOtrasAut, checkEscrituraCT, checkPlanosCT, checkLicenciaCT, checkNExpeCT, iDNI,
				rDNI);

	}

	public void editPerson(String iNombre, String iApellido, String iRazonSocial, String iDNI, String iDireccion,
			String iMunicipio, String iCP, String iTelefono, String iMovil, String iFax, String iCorreo, String rNombre,
			String rApellido, String rRazonSocial, String rDNI, String rDireccion, String rMunicipio, String rCP,
			String rTelefono, String rMovil, String rFax, String rCorreo, String nregistro, String fechaSolicitud,
			String fechaInicio, String tipoSuelo, String catastral, String emplazamiento, String estadoLicencia,
			String tipoActividad, String cuota, String descripcionActividad, int checkDNI, int checkImpuestosActividad,
			int checkFotografias, int checkEscritura, int checkJdePago, int checkMemoriaActiv, int checkPlanosLocal,
			int checkLicObra, int checkModeloTecnico, int checkColegio, int checkOtrasAut, int checkEscrituraCT,
			int checkPlanosCT, int checkLicenciaCT, int checkNExpeCT) {

		updateDatosi(iNombre, iApellido, iRazonSocial, iDNI, iDireccion, iMunicipio, iCP, iTelefono, iMovil, iFax,
				iCorreo);
		updateDatosr(rNombre, rApellido, rRazonSocial, rDNI, rDireccion, rMunicipio, rCP, rTelefono, rMovil, rFax,
				rCorreo);
		updateDatoss(nregistro, fechaSolicitud, fechaInicio, tipoSuelo, catastral, emplazamiento, estadoLicencia,
				tipoActividad, cuota, descripcionActividad, checkDNI, checkImpuestosActividad, checkFotografias,
				checkEscritura, checkJdePago, checkMemoriaActiv, checkPlanosLocal, checkLicObra, checkModeloTecnico,
				checkColegio, checkOtrasAut, checkEscrituraCT, checkPlanosCT, checkLicenciaCT, checkNExpeCT, iDNI,
				rDNI);
		// this.personData.add(personNew);
	}
}
