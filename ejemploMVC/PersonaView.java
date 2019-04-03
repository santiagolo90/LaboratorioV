package com.example.alumno.myapplication;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by alumno on 28/03/2019.
 */

public class PersonaView {
    EditText etNombre;
    EditText etApellido;
    EditText etDni;
    RadioButton rbMasculino;
    RadioButton rbFemenino;

    public PersonaView(Activity activity,MyListenerControlador controlador) {
        Button btn = (Button)activity.findViewById(R.id.btn);

        btn.setOnClickListener(controlador);


        etNombre =(EditText)activity.findViewById(R.id.etNombre);
        etDni =(EditText)activity.findViewById(R.id.etDni);
        etApellido =(EditText)activity.findViewById(R.id.etApellido);
        rbMasculino =(RadioButton)activity.findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton)activity.findViewById(R.id.rbFemenino);
    }


}
