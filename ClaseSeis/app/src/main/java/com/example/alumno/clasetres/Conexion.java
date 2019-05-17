package com.example.alumno.clasetres;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alumno on 11/04/2019.
 */

public class Conexion extends AsyncTask<String,String,String> {

    //ArrayList<HashMap<String, String>> listaCarrusel;
    List<Carrusel> carrusels;

    public byte[] conectarse(String miUrl){
        try {
            URL url = new URL(miUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int res = connection.getResponseCode();
            if (res == 200){
                InputStream is = connection.getInputStream();//enlace de comunicacion lo uso para leer
                // esta en el servidor porque no tiene new
                ByteArrayOutputStream myByte = new ByteArrayOutputStream();//como hice new esta en memoria
                byte[] arrayByte = new byte[1024];
                int cant = 0;
                //int cantidad = is.read(arrayByte);//lee la cantidad que tiene y guarda en el array de bytes
                while ((cant = is.read(arrayByte))!= -1){
                    myByte.write(arrayByte,0,cant);//objeto que escribe, desde donde hasta donde
                }
                is.close();

                return myByte.toByteArray();
            }else{
                //throw new RuntimeException("No responde el serviodr");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] conectarseImagen(String miUrl){

        return this.conectarse(miUrl);
    }

    public String conectarseString(String miUrl){
        String respuesta = new String(this.conectarse(miUrl));
        return respuesta;

    }

    @Override
    protected String doInBackground(String... miUrl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(miUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            //StringBuffer buffer = new StringBuffer();
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            String buffer = sb.toString();
            return buffer;

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Deprecated
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

                // tmp hash map for json
                //HashMap<String, String> myCarusel = new HashMap<>();

                // adding each child node to HashMap key => value
                //myCarusel.put("idCarrusel", idCarrusel);
                //myCarusel.put("titulo", titulo);
                //myCarusel.put("subtitulo", subtitulo);
                //myCarusel.put("tipo_carrusel", tipo_carrusel);
                //myCarusel.put("foto", foto);
                //personas.add(myCarusel);
                //return myCarusel;

            }/*
            for (int i = 0; i < carrusels.size(); i++) {
                Log.d("lista",String.valueOf(carrusels.get(i)));
            }
            */



        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return null;
    }




}
