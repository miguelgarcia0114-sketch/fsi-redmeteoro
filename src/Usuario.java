
import java.sql.*;

public class Usuario {

    static String todos = "SELECT * FROM usuarios ORDER BY nombre";

    String nombre, nombre_usuario, nip, role, estado;

    public Usuario() {

    }

    public Usuario(String nombre, String nombre_usuario, String nip, String role, String estado) {
        this.nombre = nombre;
        this.nombre_usuario = nombre_usuario;
        this.nip = nip;
        this.role = role;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO usuarios (nombre, nombre_usuario, nip, role, estado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, nombre_usuario);
            ps.setString(3, nip);
            ps.setString(4, role);
            ps.setString(5, estado);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {

        int resultado = 0;
        try {
            String sql = "DELETE FROM usuarios WHERE nombre_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre_usuario);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }

    }

    public int actualizar(Connection con) {
        int resultado = 0;

        try {
            String sql = "UPDATE usuarios SET nombre = ?, nip = ?, role = ?, estado = ? WHERE nombre_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, nip);
            ps.setString(3, role);
            ps.setString(4, estado);
            ps.setString(5, nombre_usuario);

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

}
