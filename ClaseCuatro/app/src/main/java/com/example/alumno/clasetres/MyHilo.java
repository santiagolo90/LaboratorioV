package com.example.alumno.clasetres;

import android.os.Handler;
import android.os.Message;


/**
 * Created by alumno on 11/04/2019.
 */

public class MyHilo extends Thread {
    Conexion myConeccion = new Conexion();
    Handler handler;
    String url;
    int tipo ;
    int currentIndex;

    public MyHilo(Handler handler, String url, int tipo){
        this.handler = handler;
        this.url = url;
        this.tipo = tipo;
    }

    public MyHilo(Handler handler, String url, int tipo, int currentIndex){
        this(handler, url, tipo);
        this.currentIndex = currentIndex;
    }

    @Override
    public void run(){
        Message mensaje = new Message();
        mensaje.arg1 = tipo;
        if (this.tipo == MainActivity.TEXTO){
            //String respues = myConeccion.conectarseString(url);
            //mensaje.obj = respues;
            String respues = myConeccion.conectarseString(url);
            mensaje.obj = ParseXml.getPersonas(respues);
        }else if(this.tipo == MainActivity.IMAGEN){
            byte[] respues = myConeccion.conectarseImagen(url);
            mensaje.obj = respues;

            mensaje.arg2 = currentIndex;
        }else if(this.tipo == MainActivity.MyJson){
            String respues = myConeccion.doInBackground(url);
            mensaje.obj = respues;


        }

        this.handler.sendMessage(mensaje);
    }


}
