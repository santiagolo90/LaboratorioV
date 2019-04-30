package com.santiago.lopez.tprss;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class ViewHolderRSS extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ViewHolderRSS(View itemView) {
        super(itemView);

        //TODO

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO abrir la noticia en un nuevo dialogo
        Log.d("Click","abro la noticia");
    }
}
