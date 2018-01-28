package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import Data.DataBase_OH;
import Data.Proyecto;

public class Proyectos extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    ListView lista_proy;
    Button crear_proyc;
    String nombrp, alcanp, sociop;
    Date fecha_crep;
    int idusrp, idequp;
    ArrayList<String> listaProyectos;
    ArrayAdapter<String> listaP;
    Cursor resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        Proyecto u = new Proyecto(nombrp, alcanp, sociop, fecha_crep, idusrp, idequp);
        resultado = u.buscarRegistro(helper.getReadableDatabase(), Integer.parseInt(getIntent().getExtras().getString("id_usr")));

        lista_proy = (ListView)findViewById(R.id.lista_proy);

        listaProyectos = new ArrayList<String>();
        while(resultado.moveToNext()){
            listaProyectos.add(resultado.getString(1));
            Toast.makeText(this, "test "+resultado.getString(1), Toast.LENGTH_LONG).show();
        }

        listaP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProyectos);
        lista_proy.setAdapter(listaP);

        crear_proyc = (Button) findViewById(R.id.crear_proyc);
        crear_proyc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(crear_proyc)){
            Intent intent = new Intent(this, Crear_proyecto.class);
            intent.putExtra("id_usr", getIntent().getExtras().getString("id_usr"));
            startActivity(intent);
        }
    }
}
