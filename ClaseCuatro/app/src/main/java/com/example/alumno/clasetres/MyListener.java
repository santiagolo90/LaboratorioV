package com.example.alumno.clasetres;

import android.view.View;

public class MyListener implements View.OnClickListener {
    MainActivity miapp;

    public MyListener(MainActivity miapp) {
        this.miapp = miapp;
    }

    @Override
    public void onClick(View v) {
        //this.miapp.personas.add(new Persona("Nueva","Persona","555-555"));
        this.miapp.myAdapter.notifyDataSetChanged();

    }
}
