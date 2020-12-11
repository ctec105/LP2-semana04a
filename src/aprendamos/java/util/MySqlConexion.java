package aprendamos.java.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {

	static {
		try {
			// CARGAR EL CONTROLADOR DE BD
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection obtenerConexion() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jugando?serverTimezone=UTC", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}