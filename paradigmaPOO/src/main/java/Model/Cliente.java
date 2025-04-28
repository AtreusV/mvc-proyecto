
package Model;

//ENTIDAD
public class Cliente {
    public int ID;
    public String TipoID;
    public String Nombre;
    public String Apellido;
    public String Usuario;
    public String password;
    public Long NroCelular;
    public String email;

    public Cliente(int ID, String TipoID, String Nombre, String Apellido, String Usuario, String password, Long NroCelular, String email) {
        this.ID = ID;
        this.TipoID = TipoID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.password = password;
        this.NroCelular = NroCelular;
        this.email = email;
    }
    
    public Cliente(String TipoID, String Nombre, String Apellido, String Usuario, String password, Long  NroCelular, String email) {
        this.TipoID = TipoID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.password = password;
        this.NroCelular = NroCelular;
        this.email = email;
    }
    
    
    //GETTERS
    public int getID() {
        return ID;
    }

    public String getTipoID() {
        return TipoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return password;
    }

    public Long getNroCelular() {
        return NroCelular;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    
    
    //SETTERS
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTipoID(String TipoID) {
        this.TipoID = TipoID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNroCelular(Long NroCelular) {
        this.NroCelular = NroCelular;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    
    //toString
    @Override
    public String toString() {
        return "Cliente{" + "ID=" + ID + ", TipoID=" + TipoID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Usuario=" + Usuario + ", password=" + password + ", NroCelular=" + NroCelular + ", email=" + email + '}';
    }
}
