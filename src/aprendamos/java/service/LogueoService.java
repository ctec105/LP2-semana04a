package aprendamos.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import aprendamos.java.util.MySqlConexion;
import bean.ClienteDTO;

public class LogueoService {

	public ClienteDTO validaUsuario(ClienteDTO objCli) {
		ClienteDTO objCliente = null;
		Connection con = MySqlConexion.obtenerConexion();
		try {
			String sql = "select * from tb_cliente where mail=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, objCli.getEmail());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				objCliente = new ClienteDTO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getLong(6));
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objCliente;
	}

}