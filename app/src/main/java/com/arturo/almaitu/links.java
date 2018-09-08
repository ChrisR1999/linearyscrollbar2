package com.arturo.almaitu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.arturo.almaitu.Modelos.ModeloDc;

import java.util.ArrayList;

public class links extends AppCompatActivity {

    private LinearLayout ln1;
    private ArrayList<ModeloDc> modelo;
    private String Agarrar;
    private String Type;
    private String desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int heidh = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (heidh * .6));
        iniciar();
    }


    public void iniciar() {
        ln1 = (LinearLayout) findViewById(R.id.linearlinks);
        final Button Link = new Button(this);
        Agarrar = getIntent().getStringExtra("type");
        desc = getIntent().getStringExtra("desc");
        Type = Agarrar;
        Link.setText(desc);
        Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitar();

            }
        });
        if (!Agarrar.equals(null))
            ln1.addView(Link);
    }

    public void visitar() {
        Intent intent = new Intent(this, paginaweb.class);
        intent.putExtra("type", Type);
        startActivity(intent);

    }


}
