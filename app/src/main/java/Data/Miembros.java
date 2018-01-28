package Data;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Miembros {

    private int id_miembros;
    private String nombre_miembro;
    private int rol_idrol;

    public Miembros(int id_miembros, String nombre_miembro, int rol_idrol) {
        this.id_miembros = id_miembros;
        this.nombre_miembro = nombre_miembro;
        this.rol_idrol = rol_idrol;
    }

    public int getId_miembros() {
        return id_miembros;
    }

    public String getNombre_miembro() {
        return nombre_miembro;
    }

    public int getRol_idrol() {
        return rol_idrol;
    }
}
