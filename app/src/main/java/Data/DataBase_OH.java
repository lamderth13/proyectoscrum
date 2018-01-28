package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ESTACION on 23/01/2018.
 */

public class DataBase_OH extends SQLiteOpenHelper {

    private static final int version=4;
    private static final String name="scrumapp.db";
    private String tabla1;
    private String tabla2;
    private String tabla3;
    private String tabla4;
    private String tabla5;
    private String tabla6;
    private String tabla7;


    public DataBase_OH(Context context) {
        super(context, name, null, version);
        tabla1 = "CREATE TABLE "+Scrumcontract.UserEntry.TABLE_NAME
                +"("+Scrumcontract.UserEntry.ID_USER+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Scrumcontract.UserEntry.NOMBRE+" TEXT NOT NULL,"
                +Scrumcontract.UserEntry.USUARIO+" TEXT NOT NULL,"
                +Scrumcontract.UserEntry.CONTRASENA+" TEXT NOT NULL,"
                +Scrumcontract.UserEntry.ESTADOUSER+" INTEGER NOT NULL)";


         tabla2 = "CREATE TABLE "+Scrumcontract.RolEntry.TABLE_NAME
                 +"("+Scrumcontract.RolEntry.IDROL+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                 +Scrumcontract.RolEntry.NOMBRE_ROL+" TEXT NOT NULL,"
                 +Scrumcontract.RolEntry.ESTADO_ROL+" TEXT NOT NULL)";

         tabla3 = "CREATE TABLE "+Scrumcontract.MiembrosEntry.TABLE_NAME
                 +"("+Scrumcontract.MiembrosEntry.IDMIEMBROS+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                 +Scrumcontract.MiembrosEntry.NOMBRE_MIEMBRO+" TEXT NOT NULL,"
                 +Scrumcontract.MiembrosEntry.ROL_ID+" INTEGER NOT NULL,"
                 +"FOREIGN KEY("+ Scrumcontract.MiembrosEntry.ROL_ID+") REFERENCES "
                + Scrumcontract.RolEntry.TABLE_NAME +"("+ Scrumcontract.RolEntry.IDROL+"))";

         tabla4 = "CREATE TABLE "+Scrumcontract.EstadoEntry.TABLE_NAME
                +"("+Scrumcontract.EstadoEntry.IDESTADO+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Scrumcontract.EstadoEntry.NOMBRE_ESTADO+" TEXT NOT NULL)";

         tabla5 = "CREATE TABLE "+Scrumcontract.EquipoEntry.TABLE_NAME
                 +"("+Scrumcontract.EquipoEntry.IDEQUIPO+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                 +Scrumcontract.EquipoEntry.NOMBRE_EQUIPO+" TEXT NOT NULL,"
                 +Scrumcontract.EquipoEntry.MIEMBROS_IDMIEMBROS+" INTEGER NOT NULL,"
                 +"FOREIGN KEY("+Scrumcontract.EquipoEntry.MIEMBROS_IDMIEMBROS+") REFERENCES "
                 +Scrumcontract.MiembrosEntry.TABLE_NAME+"("+ Scrumcontract.MiembrosEntry.IDMIEMBROS+"))";

         tabla6= "CREATE TABLE "+Scrumcontract.ProyectoEntry.TABLE_NAME
                +"("+Scrumcontract.ProyectoEntry.IDPROYECTO+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Scrumcontract.ProyectoEntry.NOMBRE_PROYECTO+" TEXT NOT NULL,"
                 +Scrumcontract.ProyectoEntry.ALCANCE+" TEXT NOT NULL,"
                 +Scrumcontract.ProyectoEntry.SOCIO+" TEXT NOT NULL,"
                 +Scrumcontract.ProyectoEntry.FECHA_CREACIONP+" TEXT NOT NULL,"
                 +Scrumcontract.ProyectoEntry.USER_ID+" INTEGER NOT NULL,"
                 +Scrumcontract.ProyectoEntry.EQUIPO_ID+" INTEGER NOT NULL,"
                 +"FOREIGN KEY("+Scrumcontract.ProyectoEntry.USER_ID+") REFERENCES "
                 +Scrumcontract.UserEntry.TABLE_NAME+"("+ Scrumcontract.UserEntry.ID_USER+"),"
                 +"FOREIGN KEY("+Scrumcontract.ProyectoEntry.EQUIPO_ID+") REFERENCES "
                 +Scrumcontract.EquipoEntry.TABLE_NAME+"("+ Scrumcontract.EquipoEntry.IDEQUIPO+"))";

         tabla7= "CREATE TABLE "+Scrumcontract.TareasEntry.TABLE_NAME
                +"("+Scrumcontract.TareasEntry.IDTAREAS+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Scrumcontract.TareasEntry.TITULO+" TEXT NOT NULL,"
                +Scrumcontract.TareasEntry.DESCRIPCION+" TEXT NOT NULL,"
                +Scrumcontract.TareasEntry.FECHA_CREACIONT+" TEXT NOT NULL,"
                +Scrumcontract.TareasEntry.FECHA_ENTREGAT+" TEXT,"
                +Scrumcontract.TareasEntry.FECHA_CIERRE+" TEXT,"
                 +Scrumcontract.TareasEntry.ESTADO_ID+" INTEGER NOT NULL,"
                 +Scrumcontract.TareasEntry.PROYECTO_ID+" INTEGER NOT NULL,"
                 +Scrumcontract.TareasEntry.MIEMBROS_ID+" INTEGER NOT NULL,"
                 +"FOREIGN KEY("+Scrumcontract.TareasEntry.ESTADO_ID+") REFERENCES "
                 +Scrumcontract.EstadoEntry.TABLE_NAME+"("+ Scrumcontract.EstadoEntry.IDESTADO+"),"
                 +"FOREIGN KEY("+Scrumcontract.TareasEntry.PROYECTO_ID+") REFERENCES "
                 +Scrumcontract.ProyectoEntry.TABLE_NAME+"("+ Scrumcontract.ProyectoEntry.IDPROYECTO+"),"
                 +"FOREIGN KEY("+Scrumcontract.TareasEntry.MIEMBROS_ID+") REFERENCES "
                 +Scrumcontract.MiembrosEntry.TABLE_NAME+"("+ Scrumcontract.MiembrosEntry.IDMIEMBROS+"))";

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.tabla1);
        sqLiteDatabase.execSQL(this.tabla2);
        sqLiteDatabase.execSQL(this.tabla3);
        sqLiteDatabase.execSQL(this.tabla4);
        sqLiteDatabase.execSQL(this.tabla5);
        sqLiteDatabase.execSQL(this.tabla6);
        sqLiteDatabase.execSQL(this.tabla7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();

        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.UserEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.RolEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.MiembrosEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.EstadoEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.EquipoEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.ProyectoEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE "+Scrumcontract.TareasEntry.TABLE_NAME);

        sqLiteDatabase.execSQL(this.tabla1);
        sqLiteDatabase.execSQL(this.tabla2);
        sqLiteDatabase.execSQL(this.tabla3);
        sqLiteDatabase.execSQL(this.tabla4);
        sqLiteDatabase.execSQL(this.tabla5);
        sqLiteDatabase.execSQL(this.tabla6);
        sqLiteDatabase.execSQL(this.tabla7);

        values.put(Scrumcontract.RolEntry.NOMBRE_ROL, "Desarrolador");
        values.put(Scrumcontract.RolEntry.ESTADO_ROL, 1);

        sqLiteDatabase.insert(Scrumcontract.RolEntry.TABLE_NAME, null, values);

        values2.put(Scrumcontract.MiembrosEntry.NOMBRE_MIEMBRO, "Ralph");
        values2.put(Scrumcontract.MiembrosEntry.ROL_ID, 1);

        sqLiteDatabase.insert(Scrumcontract.MiembrosEntry.TABLE_NAME, null, values2);

        values3.put(Scrumcontract.EquipoEntry.NOMBRE_EQUIPO, "ScrumTest");
        values3.put(Scrumcontract.EquipoEntry.MIEMBROS_IDMIEMBROS, 1);

        sqLiteDatabase.insert(Scrumcontract.EquipoEntry.TABLE_NAME, null, values3);
    }
}
