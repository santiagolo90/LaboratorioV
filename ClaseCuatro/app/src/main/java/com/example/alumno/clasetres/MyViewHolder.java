package com.example.alumno.clasetres;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 04/04/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvNombre;
    public TextView tvApellido;
    public Persona personaAux;

    public MyViewHolder(View itemView) {
        super(itemView);

        this.tvNombre = (TextView)itemView.findViewById(R.id.etNombre);
        this.tvApellido = (TextView)itemView.findViewById(R.id.etApellido);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Click",personaAux.toString());
    }
}
