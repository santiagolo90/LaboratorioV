package com.example.alumno.myapplication;


import android.util.Log;
import android.view.View;


/**
 * Created by alumno on 28/03/2019.
 */

public class MyListenerControlador implements View.OnClickListener{
    PersonaView view;
    PersonaModel model;



    public MyListenerControlador(PersonaModel model) {


        this.model = model;

    }

    @Override
    public void onClick(View v) {
        model = new PersonaModel();
        model.setNombre(view.etNombre.getText().toString());
        model.setApellido(view.etApellido.getText().toString());
        model.setDni(Integer.valueOf(view.etDni.getText().toString()));
        if(view.rbMasculino.isChecked()){
            model.setSexo(view.rbMasculino.getText().toString());
        }else{
            model.setSexo(view.rbFemenino.getText().toString());
        }

        Log.d("Nueva persona",model.toString());


    }

    public void setView(PersonaView view){
        this.view = view;
    }
}
