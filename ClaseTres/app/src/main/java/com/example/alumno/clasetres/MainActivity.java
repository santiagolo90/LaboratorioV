package com.example.alumno.clasetres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Persona> personas;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnAgregar =(Button) super.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new MyListener(this));


        personas = new ArrayList<Persona>();
        personas.add(new Persona("Juan","Perez","444-444"));
        personas.add(new Persona("Mario","Perez","444-444"));
        personas.add(new Persona("Antonio","Perez","444-444"));
        personas.add(new Persona("Pepe","Perez","444-444"));
        personas.add(new Persona("Santiago","Perez","444-444"));
        personas.add(new Persona("Miguel","Perez","444-444"));
        personas.add(new Persona("Fernado","Perez","444-444"));

        RecyclerView rvPersona = (RecyclerView) super.findViewById(R.id.listaPersonas);

        myAdapter = new MyAdapter(personas , this);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        rvPersona.setAdapter(myAdapter);
        rvPersona.setLayoutManager(lm);

    }


}
