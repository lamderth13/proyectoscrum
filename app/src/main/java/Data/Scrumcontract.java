package Data;

import android.provider.BaseColumns;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Scrumcontract {

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME ="user";

        public static final String ID_USER = "id_user";
        public static final String NOMBRE = "nombre";
        public static final String USUARIO = "usuario";
        public static final String CONTRASENA = "contrasena";
        public static final String ESTADOUSER = "estadouser";
    }

    public static abstract class ProyectoEntry implements BaseColumns{
        public static final String TABLE_NAME ="proyecto";

        public static final String IDPROYECTO = "idproyecto";
        public static final String NOMBRE_PROYECTO = "nombre_proyecto";
        public static final String ALCANCE = "alcance";
        public static final String SOCIO = "socio";
        public static final String FECHA_CREACIONP = "fecha_creacionp";
        public static final String USER_ID = "user_iduser";
        public static final String EQUIPO_ID = "equipo_idequipo";
    }

    public static abstract class EquipoEntry implements BaseColumns{
        public static final String TABLE_NAME ="equipo";

        public static final String IDEQUIPO = "idequipo";
        public static final String NOMBRE_EQUIPO = "nombre_equipo";
        public static final String MIEMBROS_IDMIEMBROS = "miembros_idmiembros";

    }
    public static abstract class TareasEntry implements BaseColumns{
        public static final String TABLE_NAME ="tareas";

        public static final String IDTAREAS = "id_tareas";
        public static final String TITULO = "titulo";
        public static final String DESCRIPCION = "descripcion";
        public static final String ESTADO_ID = "estado_idestado";
        public static final String FECHA_CREACIONT = "fecha_creaciont";
        public static final String FECHA_ENTREGAT = "fecha_entregat";
        public static final String FECHA_CIERRE = "fecha_cierre";
        public static final String PROYECTO_ID = "proyecto_idproyecto";
        public static final String MIEMBROS_ID = "miembros_idmiembros";

    }
    public static abstract class EstadoEntry implements BaseColumns{
        public static final String TABLE_NAME ="estado";

        public static final String IDESTADO = "id_estado";
        public static final String NOMBRE_ESTADO = "nombre_estado";

    }

    public static abstract class MiembrosEntry implements BaseColumns{
        public static final String TABLE_NAME ="miembros";

        public static final String IDMIEMBROS = "id_miembros";
        public static final String NOMBRE_MIEMBRO = "nombre_miembro";
        public static final String ROL_ID = "rol_idrol";

    }
    public static abstract class RolEntry implements BaseColumns{
        public static final String TABLE_NAME ="rol";

        public static final String IDROL = "id_rol";
        public static final String NOMBRE_ROL= "nombre_rol";
        public static final String ESTADO_ROL = "estado_rol";

    }
}

