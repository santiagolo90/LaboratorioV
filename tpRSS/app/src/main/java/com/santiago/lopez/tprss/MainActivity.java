package com.santiago.lopez.tprss;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    List<Noticia> noticias;
    AdapterRSS adapterRSS;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticias = new ArrayList<Noticia>();

        RecyclerView rvRSS = (RecyclerView) super.findViewById(R.id.listaNoticias);
        adapterRSS = new AdapterRSS(noticias , this);

        /*
        * Para que se vea como lista
        * */
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvRSS.setLayoutManager(lm);



        rvRSS.setAdapter(adapterRSS);
        rvRSS.setLayoutManager(lm);

        //implementa  Handler.Callback
        handler = new Handler(this);

    }

    @Override
    public boolean handleMessage(Message msg) {
        this.adapterRSS.notifyDataSetChanged();
        return false;
    }
}
