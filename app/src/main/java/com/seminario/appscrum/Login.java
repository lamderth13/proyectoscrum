package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Data.DataBase_OH;
import Data.User;

public class Login extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    TextView registro;
    Button go;
    EditText user;
    EditText password;
    String nombre_usr;
    String usr;
    String passw;
    String resl_usr;
    String resl_pass;
    String resl_id;
    String usr_aut;
    String passw_aut;
    int estado = 1;
    Cursor resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);

        registro = (TextView)findViewById(R.id.resgistro);
        registro.setOnClickListener(this);

        go = (Button)findViewById(R.id.go);
        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(registro)){
            Intent intent = new Intent(this, Registro_user.class);
            startActivity(intent);
        }

        if(view.equals(go)){
            usr_aut = user.getText().toString();
            passw_aut = password.getText().toString();

            User u = new User(nombre_usr, usr, passw, estado);
            resultado = u.autenticar(helper.getReadableDatabase(), usr_aut, passw_aut);

            if(resultado.moveToFirst()==true){
                resl_id=resultado.getString(0);
                resl_usr=resultado.getString(1);
                resl_pass=resultado.getString(2);

                Intent intent = new Intent(this, Proyectos.class);
                intent.putExtra("id_usr", resl_id);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Usuario y contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
        }
    }
}
