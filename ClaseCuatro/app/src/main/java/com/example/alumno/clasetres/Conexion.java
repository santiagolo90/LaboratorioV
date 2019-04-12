package com.example.alumno.clasetres;


import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alumno on 11/04/2019.
 */

public class Conexion {

    public byte[] conectarse(String miUrl){
        try {
            URL url = new URL(miUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int res = connection.getResponseCode();
            if (res == 200){
                InputStream is = connection.getInputStream();//enlace de comunicacion lo uso para leer //esta en el servidor porque no tiene new
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
}
