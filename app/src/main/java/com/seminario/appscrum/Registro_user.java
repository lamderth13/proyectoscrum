package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Data.DataBase_OH;
import Data.User;

public class Registro_user extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    EditText nombre;
    EditText usuario;
    EditText contrasena;
    Button guardar_usuario;
    String nombre_usr;
    String usr;
    String passw;
    String id_usr;
    int estado = 1;
    Cursor resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_user);

        nombre = (EditText)findViewById(R.id.nombre);
        usuario = (EditText)findViewById(R.id.usuario);
        contrasena = (EditText)findViewById(R.id.contrasena);

        guardar_usuario = (Button)findViewById(R.id.guardar_usuario);
        guardar_usuario.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(guardar_usuario)){
            nombre_usr=nombre.getText().toString();
            usr=usuario.getText().toString();
            passw=contrasena.getText().toString();

            User u = new User(nombre_usr, usr, passw, estado);
            u.nuevoRegistro(helper.getWritableDatabase());

            resultado = u.getLastId(helper.getReadableDatabase());

            Intent intent = new Intent(this, Proyectos.class);

            while(resultado.moveToNext()){
                id_usr = resultado.getString(0);
            }

            intent.putExtra("id_usr", id_usr);
            startActivity(intent);
        }
    }
}
