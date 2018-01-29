package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Data.DataBase_OH;
import Data.Proyecto;

public class Proyectos extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    ListView lista_proy;
    Button crear_proyc;
    String nombrp, alcanp, sociop;
    Date fecha_crep;
    int idusrp, idequp;
    HashMap<Integer,String> lisPoyectos_detalles;
    ArrayList<String> listaProyectos;
    ArrayAdapter<String> listaP;
    Cursor resultado;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        Proyecto u = new Proyecto(nombrp, alcanp, sociop, fecha_crep, idusrp, idequp);
        resultado = u.buscarRegistro(helper.getReadableDatabase(), Integer.parseInt(getIntent().getExtras().getString("id_usr")));

        lista_proy = (ListView)findViewById(R.id.lista_proy);

        listaProyectos = new ArrayList<String>();
        lisPoyectos_detalles = new HashMap<Integer, String>();
        while(resultado.moveToNext()){
            listaProyectos.add(resultado.getString(1));
            lisPoyectos_detalles.put(cont, resultado.getString(0));
            cont++;
        }

        listaP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProyectos);
        listaP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista_proy.setAdapter(listaP);

        lista_proy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id_p = "id: "+lisPoyectos_detalles.get(i);

                Toast.makeText(getApplicationContext(), "id "+id_p, Toast.LENGTH_LONG).show();
            }
        });

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
