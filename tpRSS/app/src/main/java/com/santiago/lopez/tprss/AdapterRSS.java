package com.santiago.lopez.tprss;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdapterRSS extends RecyclerView.Adapter<ViewHolderRSS> {

    List<Noticia> noticias;
    MainActivity miapp;

    public AdapterRSS(List<Noticia> noticias, MainActivity miapp) {
        this.noticias = noticias;
        this.miapp = miapp;
    }

    @Override
    public ViewHolderRSS onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_recyclerview, viewGroup, false);
        ViewHolderRSS vh = new ViewHolderRSS(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolderRSS holder, int position) {
        //TODO

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
