package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ESTACION on 24/01/2018.
 */

public interface Entidad {
    public long nuevoRegistro(SQLiteDatabase db);
    public long ActualizarRegistro(SQLiteDatabase db);
    public Cursor buscarRegistro(SQLiteDatabase db, int id);
    public Cursor listarRegistro(SQLiteDatabase db, int id);
    public long borrarRegistro(SQLiteDatabase db, int id);

    public ContentValues toContentValues();
}
