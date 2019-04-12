package com.example.alumno.clasetres;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alumno on 04/04/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Persona> p;
    AppCompatActivity miapp;

    public MyAdapter(List<Persona> p,MainActivity mipp ) {
        this.p = p;
        this.miapp = mipp;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nuevo_recy,parent,false);
        MyViewHolder mv = new MyViewHolder(v);
        return mv;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Persona p = this.p.get(position);
        holder.tvNombre.setText(p.getNombre());
        holder.tvApellido.setText(p.getApellido());
        holder.personaAux = p;

    }

    @Override
    public int getItemCount() {
        return this.p.size();
    }
}
