package com.example.alumno.clasedos;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by alumno on 28/03/2019.
 */

public class MiListener implements View.OnClickListener {

    private AppCompatActivity activity;

    EditText etNombre;
    EditText etApellido;
    EditText etDni;
    RadioButton rbMasculino;
    RadioButton rbFemenino;
    String sexo;

    public MiListener(AppCompatActivity miApp) {

        this.activity = miApp;

        etNombre =(EditText)activity.findViewById(R.id.nombre);
        etDni =(EditText)activity.findViewById(R.id.dni);
        etApellido =(EditText)activity.findViewById(R.id.apellido);
        rbMasculino =(RadioButton)activity.findViewById(R.id.hombre);
        rbFemenino = (RadioButton)activity.findViewById(R.id.mujer);


    }

    @Override
    public void onClick(View v) {

        if(rbMasculino.isChecked()){
            this.sexo ="Hombre";
        }else{
            this.sexo ="Mujer";
        }

        if (v.getId() == R.id.btnGuardar){
            //Log.d("click PersonaModel", String.valueOf(this.etDni.getText().toString()));

            String num = String.valueOf(this.etDni.getText());
            if (num.isEmpty()){
                num = "1";
            }
            PersonaModel p = new PersonaModel(
                    etNombre.getText().toString(),
                    etApellido.getText().toString(),
                    Integer.valueOf(num),
                    this.sexo.toString());

            Log.d("click PersonaModel",p.toString());
        }

    }


}
