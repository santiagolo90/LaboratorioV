package com.example.alumno.clasetres;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
            /*
            Intent i = new Intent(miapp,SegundaActivity.class);
            i.putExtra(VALOR_STRING,"Cambio el texto del boton");
            miapp.startActivity(i);
            */
            Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:44444444"));

            if (ContextCompat.checkSelfPermission(this.miapp, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this.miapp, new String[]{Manifest.permission.CALL_PHONE}, 0);
            }else{
                this.miapp.startActivity(callIntent);
            }
        }else{
            miapp.finish();
        }
        //this.miapp.myAdapter.notifyDataSetChanged();

    }
}
