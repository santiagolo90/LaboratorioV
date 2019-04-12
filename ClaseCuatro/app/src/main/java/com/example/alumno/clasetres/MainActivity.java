package com.example.alumno.clasetres;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    List<Persona> personas;
    MyAdapter myAdapter;
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
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

        Handler handler = new Handler(this);

        MyHilo hilo = new MyHilo(handler,"http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",TEXTO);
        hilo.start();

        MyHilo hilo2 = new MyHilo(handler,"http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png",IMAGEN);
        hilo2.start();

    }


    @Override
    public boolean handleMessage(Message msg) {
        if (msg.arg1 == MainActivity.TEXTO){
            Log.d("desde el hilo texto",msg.obj.toString());
        }else if(msg.arg1  == MainActivity.IMAGEN){
            //Log.d("desde el hilo",msg.obj.toString());
            Log.d("desde el hilo imagen",msg.obj.toString());
            ImageView imagen =(ImageView) super.findViewById(R.id.imagenTest);
            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])msg.obj, 0, ((byte[])msg.obj).length);
            imagen.setImageBitmap(bitmap);
        }

        return false;
    }
}
