package com.arturo.almaitu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.arturo.almaitu.R;
import com.arturo.almaitu.Adapters.AdaptadorMain;
import com.arturo.almaitu.Controladores.ControladorLinks;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class VisorDeComics extends AppCompatActivity {

    private ListView listComics;
    private ArrayList comicsCards;
    private AdaptadorMain adapter;
    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visordecomics);
        initComponents();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



    }

    private void initComponents() {
        final String company = getIntent().getStringExtra("company");
        comicsCards = new ArrayList();
        listComics = (ListView) findViewById(R.id.listMain);
        listComics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView nameView = (TextView) view.findViewById(R.id.comicName);
                final String comicName = nameView.getText().toString();
            }
        });
        getAllComics(company);
    }

    private void getAllComics(String company) {
        ControladorLinks controller = new ControladorLinks(this);
        comicsCards = controller.getAllComicsByCompany(company);
        adapter = new AdaptadorMain(this, comicsCards, this);
        listComics.setAdapter(adapter);
    }
}
