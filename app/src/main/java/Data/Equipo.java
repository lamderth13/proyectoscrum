package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Equipo implements Entidad {

    private int idequipo;
    private String nombre_equipo;
    private int miembros_idmiembros;

    public Equipo(String nombre_equipo, int miembros_idmiembros) {
        //this.idequipo = idequipo;
        this.nombre_equipo = nombre_equipo;
        this.miembros_idmiembros = miembros_idmiembros;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public int getMiembros_idmiembros() {
        return miembros_idmiembros;
    }

    @Override
    public long nuevoRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public long ActualizarRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public Cursor buscarRegistro(SQLiteDatabase db, int id) {
        return null;
    }

    @Override
    public Cursor listarRegistro(SQLiteDatabase db, int id) {
        return null;
    }

    public Cursor mostrarTodos(SQLiteDatabase db){
        return db.rawQuery("SELECT "
                +Scrumcontract.EquipoEntry.IDEQUIPO+", "
                +Scrumcontract.EquipoEntry.NOMBRE_EQUIPO
                +" FROM "
                +Scrumcontract.EquipoEntry.TABLE_NAME,null
        );
    }

    @Override
    public long borrarRegistro(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();

        cv.put(Scrumcontract.EquipoEntry.NOMBRE_EQUIPO, getNombre_equipo());
        cv.put(Scrumcontract.EquipoEntry.MIEMBROS_IDMIEMBROS, getMiembros_idmiembros());

        return cv;
    }
}
