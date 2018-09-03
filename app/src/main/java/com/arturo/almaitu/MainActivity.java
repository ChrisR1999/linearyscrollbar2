package com.arturo.almaitu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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
    }

    public void iralcomic(View view){
        final ImageButton button = (ImageButton)view.findViewById(view.getId());
        final String company = button.getContentDescription().toString();
        Intent intent = new Intent(this, VisorDeComics.class);
        Toast.makeText(this, company, Toast.LENGTH_SHORT).show();
        intent.putExtra("company", company);
        startActivity(intent);

    }
}
