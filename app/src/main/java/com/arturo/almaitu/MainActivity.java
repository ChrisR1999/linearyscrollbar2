package com.arturo.almaitu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-5146175048698339~1301771677");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
       // MobileAds.initialize(this, "ca-app-pub-5146175048698339~1301771677");

    }

    public void iralcomic(View view){
        final ImageButton button = (ImageButton)view.findViewById(view.getId());
        final String company = button.getContentDescription().toString();
        Intent intent = new Intent(this, VisorDeComics.class);
        //Toast.makeText(this, company, Toast.LENGTH_SHORT).show();

            intent.putExtra("company", company);

            // Si hay conexión a Internet en este momento

            startActivity(intent);



    }
}
