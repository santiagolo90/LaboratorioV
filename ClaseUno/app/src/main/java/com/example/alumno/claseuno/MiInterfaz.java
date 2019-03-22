package com.example.alumno.claseuno;


import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by alumno on 21/03/2019.
 */

public class MiInterfaz implements View.OnClickListener {

    MainActivity miActividad;
    public MiInterfaz(MainActivity a){
        this.miActividad = a;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        TextView miTxt =(TextView)this.miActividad.findViewById(R.id.miTxt);
        EditText txtUno =(EditText)this.miActividad.findViewById(R.id.txtUno);
        if (v.getId() == R.id.btnUno){
            miTxt.setText(txtUno.getText());
            Log.d("click","Se hizo click agregar texto");
        }
        if (v.getId() == R.id.btnDos){
            Log.d("click","Se hizo click borrar");
            miTxt.setText("");

        }


    }
}
