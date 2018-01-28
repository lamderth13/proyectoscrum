package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class User implements Entidad{

    private int id_user;
    private String nombre;
    private String usuario;
    private String contrasena;
    private int estadouser;

    public User(String nombre, String usuario, String contrasena, int estadouser) {
        //this.id_user = id_user;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estadouser = estadouser;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getEstadouser() {
        return estadouser;
    }

    @Override
    public long nuevoRegistro(SQLiteDatabase db) {
        return db.insert(Scrumcontract.UserEntry.TABLE_NAME, null, toContentValues());
    }

    @Override
    public long ActualizarRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public Cursor buscarRegistro(SQLiteDatabase db, int id) {
        return db.query(Scrumcontract.UserEntry.TABLE_NAME,null, Scrumcontract.UserEntry.ID_USER+"= ?",new String[]{id+""},null,null,null);
    }

    public Cursor autenticar(SQLiteDatabase db, String usr, String pass){
        return db.rawQuery("SELECT "+Scrumcontract.UserEntry.ID_USER+", "
                +Scrumcontract.UserEntry.USUARIO+", "
                +Scrumcontract.UserEntry.CONTRASENA
                +" FROM "
                +Scrumcontract.UserEntry.TABLE_NAME+" WHERE "
                +Scrumcontract.UserEntry.USUARIO+" = '"
                +usr+"' AND "
                +Scrumcontract.UserEntry.CONTRASENA+" = '"
                +pass+"'", null);
    }

    public Cursor getLastId(SQLiteDatabase db) {
        return db.rawQuery(" SELECT * FROM "+Scrumcontract.UserEntry.TABLE_NAME+" ORDER BY "+Scrumcontract.UserEntry.ID_USER+" DESC LIMIT 1 ", null);
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
        cv.put(Scrumcontract.UserEntry.USUARIO, getUsuario());
        //cv.put(Scrumcontract.UserEntry.ID_USER, getId_user());
        cv.put(Scrumcontract.UserEntry.CONTRASENA, getContrasena());
        cv.put(Scrumcontract.UserEntry.ESTADOUSER, getEstadouser());
        cv.put(Scrumcontract.UserEntry.NOMBRE, getNombre());

        return cv;
    }
}
