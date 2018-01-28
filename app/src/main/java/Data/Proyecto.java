package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Proyecto implements Entidad {

    private int idproyecto;
    private String nombre_proyecto;
    private String alcance;
    private String socio;
    private Date fecha_creacionp;
    private int user_iduser;
    private int equipo_idequipo;

    public Proyecto(String nombre_proyecto, String alcance,
                    String socio, Date fecha_creacionp, int user_iduser, int equipo_idequipo) {
        //this.idproyecto = idproyecto;
        this.nombre_proyecto = nombre_proyecto;
        this.alcance = alcance;
        this.socio = socio;
        this.fecha_creacionp = fecha_creacionp;
        this.user_iduser = user_iduser;
        this.equipo_idequipo = equipo_idequipo;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public String getAlcance() {
        return alcance;
    }

    public String getSocio() {
        return socio;
    }

    public Date getFecha_creacion() {
        return fecha_creacionp;
    }

    public int getUser_iduser() {
        return user_iduser;
    }

    public int getEquipo_idequipo() {
        return equipo_idequipo;
    }

    @Override
    public long nuevoRegistro(SQLiteDatabase db) {
        return db.insert(Scrumcontract.ProyectoEntry.TABLE_NAME, null, toContentValues());
    }

    @Override
    public long ActualizarRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public Cursor buscarRegistro(SQLiteDatabase db, int id) {
        return db.rawQuery("SELECT * FROM "
                +Scrumcontract.ProyectoEntry.TABLE_NAME
                +" WHERE "
                +Scrumcontract.ProyectoEntry.USER_ID+" = "
                +id,null
        );
    }

    @Override
    public Cursor listarRegistro(SQLiteDatabase db, int id) {
        return null;
    }

    @Override
    public long borrarRegistro(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();

        cv.put(Scrumcontract.ProyectoEntry.NOMBRE_PROYECTO, getNombre_proyecto());
        cv.put(Scrumcontract.ProyectoEntry.ALCANCE, getAlcance());
        cv.put(Scrumcontract.ProyectoEntry.SOCIO, getSocio());
        cv.put(Scrumcontract.ProyectoEntry.FECHA_CREACIONP, String.valueOf(getFecha_creacion()));
        cv.put(Scrumcontract.ProyectoEntry.USER_ID, getUser_iduser());
        cv.put(Scrumcontract.ProyectoEntry.EQUIPO_ID, getEquipo_idequipo());

        return cv;
    }
}
