package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPersona extends Persona{

    public ModeloPersona() {
    }

    public ModeloPersona(String idpersona, String nombres, String apellidos, Date fechanac, String telefono, String sexo, double sueldo, int cupo, Byte foto) {
        super(idpersona, nombres, apellidos, fechanac, telefono, sexo, sueldo, cupo, foto);
    }
    
    public List<Persona> ListPersonas() {
            List<Persona> lista = new ArrayList<>();
            String sql = "SELECT idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo FROM \"persona\"";
            ConectPG conpq = new ConectPG();
            ResultSet rs = conpq.Consulta(sql);
        try {            
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setFechanac(rs.getDate("fechanacimiento"));
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));
                //per.setFoto(rs.getByte("foto"));
                lista.add(per);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException GrabaPersonaDB() {
        String sql = "INSERT INTO persona (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, "
                + "sueldo, cupo, foto) VALUES ('" + getIdpersona() + "','" + getNombres() + "','" + getApellidos() + "',"
                + "'" + getFechanac()+ "','" + getTelefono()+ "','" + getSexo() + "', "+ getSueldo()+ ", " + getCupo()+ ", "
                + "'" + getFoto() + "')"; //REVISAR EL INSERT 
        
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public List<Persona> BuscarPersonaBD(String search) {
            List<Persona> lista = new ArrayList<>();
            String sql = "SELECT idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, "
                + "sueldo, cupo FROM persona WHERE idpersona LIKE '%" + search + "%' OR nombres LIKE '%" + search + "%'"
                + "OR apellidos LIKE '%" + search + "%' OR "
                + "telefono LIKE'%" + search + "%' OR sexo LIKE '%" + search + "%'";
            ConectPG conpq = new ConectPG();
            ResultSet rs = conpq.Consulta(sql);
        try {            
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setFechanac(rs.getDate("fechanacimiento"));
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));
                //per.setFoto(rs.getByte("foto"));
                lista.add(per);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException ModficarPersonaDB(String bus) {
        String sql = "UPDATE persona SET  nombres = '" +getNombres() + "', apellidos = '" +getApellidos() + "', fechanacimiento = '"+getFechanac()
                + "', telefono = '" +getTelefono() + "', sexo = '" + getSexo() + "', sueldo = " + getSueldo() + ", cupo = " + getCupo() + ", foto = "
                + "'" +getFoto() + "'" + "WHERE idpersona LIKE '%" + bus + "%'"; 
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public SQLException EliminarPersonaDB(String id) {
        String sql = "DELETE FROM persona WHERE idpersona LIKE '" + id + "'";
        
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    } 
    
}
