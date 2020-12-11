package aprendamos.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import aprendamos.java.util.MySqlConexion;
import bean.ClienteDTO;

public class MantenerClienteService {

	public List<ClienteDTO> listadoClientes(String nom) {
		ClienteDTO cli = null;
		Connection con = MySqlConexion.obtenerConexion();
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		try {
			String sql = "select * from tb_cliente where nombre like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + nom + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cli = new ClienteDTO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getLong(6));
				lista.add(cli);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}