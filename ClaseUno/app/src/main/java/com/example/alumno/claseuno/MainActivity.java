package com.example.alumno.claseuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView miTxt =(TextView)super.findViewById(R.id.miTxt);
        miTxt.setText("esperando texto");


        MiInterfaz mi = new MiInterfaz(this);


        Button botonUno = (Button)super.findViewById(R.id.btnUno);
        Button botonDos = (Button)super.findViewById(R.id.btnDos);
        botonUno.setOnClickListener(new MiInterfaz(this));
        botonDos.setOnClickListener(new MiInterfaz(this));
        //botonUno.setOnClickListener(new onCreatePanelView().hasOnClickListeners());
        //botonUno.callOnClick();
    }
}
