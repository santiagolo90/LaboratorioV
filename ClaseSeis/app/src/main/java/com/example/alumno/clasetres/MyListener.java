package com.example.alumno.clasetres;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MyListener implements View.OnClickListener {
    Activity miapp;
    public final static String VALOR_STRING = "STRING";

    public MyListener(Activity miapp) {
        this.miapp = miapp;
    }

    @Override
    public void onClick(View v) {
        //this.miapp.personas.add(new Persona("Nueva","Persona","555-555"));
        if (v.getId() == R.id.btnAgregar){
            Intent i = new Intent(miapp,SegundaActivity.class);
            i.putExtra(VALOR_STRING,"Cambio el texto del boton");
            miapp.startActivity(i);
        }else{
            miapp.finish();
        }
        //this.miapp.myAdapter.notifyDataSetChanged();

    }
}
