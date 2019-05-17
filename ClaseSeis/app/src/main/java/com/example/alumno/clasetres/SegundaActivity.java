package com.example.alumno.clasetres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Button btnVolver =(Button) super.findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new MyListener(this));

        Intent i = getIntent();
        btnVolver.setText(i.getStringExtra(MyListener.VALOR_STRING));
    }
}
