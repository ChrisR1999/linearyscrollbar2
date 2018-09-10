package com.arturo.almaitu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.arturo.almaitu.Adapters.AdaptadorMain;
import com.arturo.almaitu.Controladores.ControladorLinks;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class inicio extends AppCompatActivity {

    private ListView listComics;
    private ArrayList comicsCards;
    private AdaptadorMain adapter;
    private Toolbar toolbar;
    private EditText searchBar;
    public InterstitialAd mInterstitialAd;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visordecomics);
        initComponents();
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
          /*//Esta tambien esta en Adaptador main esta es una prueba para cuando se abra la activity
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }*/
    }

    private void initComponents() {

        int numero = (int) (Math.random() * 20) + 1;
        final String company = Integer.toString(numero); ;//;getIntent().getStringExtra("company");
        comicsCards = new ArrayList();
        listComics = (ListView) findViewById(R.id.listMain);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchBar = (EditText) findViewById(R.id.comicSearch);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String search = searchBar.getText().toString();
                getSearchedComics(search, company);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listComics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView nameView = (TextView) view.findViewById(R.id.comicName);
                final String comicName = nameView.getText().toString();
            }
        });

        MobileAds.initialize(this, "ca-app-pub-5146175048698339~1301771677");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5146175048698339/2631165212");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        getAllComics(company);
    }

    private void getAllComics(String company) {
        ControladorLinks controller = new ControladorLinks(this);
        comicsCards = controller.getAllComicsByRandom(company);
        adapter = new AdaptadorMain(this, comicsCards, this, mInterstitialAd);
        listComics.setAdapter(adapter);
    }

    private void getSearchedComics(String search, String company){
        ControladorLinks controller = new ControladorLinks(this);
        comicsCards = controller.getSearchedComics(search, company);
        adapter = new AdaptadorMain(this, comicsCards, this, mInterstitialAd);
        listComics.setAdapter(adapter);
    }
}
