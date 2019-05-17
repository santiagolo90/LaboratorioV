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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    List<Persona> personas;
    List<Carrusel> carrusels;
    MyAdapter myAdapter;
    String myImagenURL;
    Handler handler;
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
    public static final int MyJson = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAgregar =(Button) super.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new MyListener(this));


        personas = new ArrayList<Persona>();
 /*       personas.add(new Persona("Juan","Perez","444-444"));
        personas.add(new Persona("Mario","Perez","444-444"));
        personas.add(new Persona("Antonio","Perez","444-444"));
        personas.add(new Persona("Pepe","Perez","444-444"));
        personas.add(new Persona("Santiago","Perez","444-444"));
        personas.add(new Persona("Miguel","Perez","444-444"));
        personas.add(new Persona("Fernado","Perez","444-444"));
*/


        RecyclerView rvPersona = (RecyclerView) super.findViewById(R.id.listaPersonas);

        myAdapter = new MyAdapter(personas , this);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        rvPersona.setAdapter(myAdapter);
        rvPersona.setLayoutManager(lm);

        //handler = new Handler(this);

        //MyHilo hilo = new MyHilo(handler,"http://192.168.2.154:8080/listaPersonasImg.xml",TEXTO);
        //hilo.start();

        //MyHilo hilo2 = new MyHilo(handler,"https://onemoretry.eu/assets/fotos/carrusel/2019-02-05_18:23:56.jpg",IMAGEN);
        //hilo2.start();

       // MyHilo hilo3 = new MyHilo(handler,"https://onemoretry.eu/PHP/carrusel/traerTodos",MyJson);
        //hilo3.start();


    }


    @Override
    public boolean handleMessage(Message msg) {

        if (msg.arg1 == MainActivity.TEXTO){

            for (Persona p: (List<Persona>)msg.obj){
                Log.d("desde el hilo texto",p.toString());
            }

            this.personas.addAll((List<Persona>)msg.obj);
            this.myAdapter.notifyDataSetChanged();
        }else if(msg.arg1  == MainActivity.IMAGEN){
            //Log.d("desde el hilo",msg.obj.toString());
            Log.d("desde el hilo imagen",msg.obj.toString());

            this.personas.get(msg.arg2).setImagenes((byte[])msg.obj);
            this.myAdapter.notifyItemChanged(msg.arg2);
            /*ImageView imagen =(ImageView) super.findViewById(R.id.imagenTest);
            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])msg.obj, 0, ((byte[])msg.obj).length);
            imagen.setImageBitmap(bitmap);*/
        }else if(msg.arg1  == MainActivity.MyJson){
            convertToJson(msg.obj.toString());

            for (int i = 0; i < carrusels.size(); i++) {
                Log.d("desde el hilo MyJson",carrusels.get(i).toString());
            }
        }

        return false;
    }

    protected void convertToJson(String datos) {
        carrusels = new ArrayList<Carrusel>();
        try {
            JSONArray jsonarray = new JSONArray(datos);
            //ArrayList<HashMap<String, String>> personas = new ArrayList<>();
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject c = jsonarray.getJSONObject(i);
                Number idCarrusel = c.getInt("idCarrusel");
                String titulo = c.getString("titulo");
                String subtitulo = c.getString("subtitulo");
                String orden = c.getString("orden");
                String tipo_carrusel = c.getString("tipo_carrusel");
                String foto = c.getString("foto");
                carrusels.add(new Carrusel(idCarrusel,titulo,subtitulo,orden,tipo_carrusel,foto));
                this.myImagenURL = foto;

            }

            Handler handler = new Handler(this);
            MyHilo hilo4 = new MyHilo(handler,this.myImagenURL,IMAGEN);
            hilo4.start();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return null;
    }


}
