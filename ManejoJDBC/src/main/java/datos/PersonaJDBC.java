package datos;

import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Garfias
 */
public class PersonaJDBC {
    
    private static final String SQL_SELCT = "select id_persona, nombre, apellido, email, telefono from persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    
    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = Conexion.getConnection();
            stat = conn.prepareStatement(SQL_SELCT);
            rs = stat.executeQuery();
            while(rs.next()){
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            Conexion.closeRS(rs);
            Conexion.closeRS(rs);
            Conexion.closeCon(conn);
        }
        return personas;
    }
}
