package Data;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Rol {

    public int id_rol;
    public String nombre_rol;
    public boolean estado_rol;

    public Rol(int id_rol, String nombre_rol, boolean estado_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.estado_rol = estado_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public boolean isEstado_rol() {
        return estado_rol;
    }
}
