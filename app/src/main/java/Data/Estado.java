package Data;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Estado {

    public int id_estado;
    public String nombre_estado;

    public Estado(int id_estado, String nombre_estado) {
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }
}
