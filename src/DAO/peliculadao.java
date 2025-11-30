package DAO;
import DB.DB;
import DML.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class peliculadao {
	public List<Pelicula> obtenerPorGenero(String genero) {
        List<Pelicula> lista = new ArrayList<>();

        String sql = "SELECT * FROM peliculas WHERE genero = ?";

        try (Connection con = DB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error DAO: " + e.getMessage());
        }

        return lista;
    }
}
