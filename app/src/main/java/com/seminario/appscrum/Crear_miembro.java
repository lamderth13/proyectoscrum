package com.seminario.appscrum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import Data.DataBase_OH;

public class Crear_miembro extends AppCompatActivity implements OnClickListener {

    DataBase_OH helper = new DataBase_OH(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_miembro);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
