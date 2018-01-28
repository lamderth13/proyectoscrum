package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Data.DataBase_OH;
import Data.Equipo;
import Data.Proyecto;

public class Crear_proyecto extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    EditText nomb_proyec;
    EditText socio;
    EditText fecha_creacion;
    Spinner equipo;
    EditText alcance;
    Button guardar;

    String nombre_equ;
    int idmienbro;
    int cont = 0;

    String cod_equip;

    Cursor resultado;
    HashMap<Integer,String> lista_equ;
    List<String> ls_equ;
    ArrayAdapter<String> combo;
    //String idmie, nombr_eq;
    Equipo u = new Equipo(nombre_equ, idmienbro);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_proyecto);

        nomb_proyec = (EditText)findViewById(R.id.nomb_proyec);
        socio = (EditText)findViewById(R.id.socio);
        fecha_creacion = (EditText)findViewById(R.id.fecha_creacion);
        equipo = (Spinner)findViewById(R.id.equipo);
        alcance = (EditText)findViewById(R.id.alcance);
        guardar = (Button)findViewById(R.id.guardar);

        Equipo u = new Equipo(nombre_equ, idmienbro);
        resultado = u.mostrarTodos(helper.getReadableDatabase());

        ls_equ = new ArrayList<String>();
        lista_equ = new HashMap<Integer, String>();
        while(resultado.moveToNext()){
            lista_equ.put(cont, resultado.getString(0));
            ls_equ.add(resultado.getString(1));
            cont++;
        }

        combo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ls_equ);
        combo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        equipo.setAdapter(combo);

        guardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(guardar)){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha_creacionp = new Date();

            //nombr_eq = equipo.getSelectedItem().toString();
            cod_equip = lista_equ.get(equipo.getSelectedItemPosition());
            String nombrep= nomb_proyec.getText().toString();
            String sociop = socio.getText().toString();

            try {
                fecha_creacionp = dateFormat.parse(fecha_creacion.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String alcancep = alcance.getText().toString();

            int id_usurio = Integer.parseInt(getIntent().getExtras().getString("id_usr"));

            Proyecto u = new Proyecto(nombrep, alcancep, sociop, fecha_creacionp, id_usurio, id_usurio);
            u.nuevoRegistro(helper.getWritableDatabase());

            Intent intent = new Intent(this, Proyectos.class);
            intent.putExtra("id_usr", getIntent().getExtras().getString("id_usr"));
            startActivity(intent);
        }
    }
}
