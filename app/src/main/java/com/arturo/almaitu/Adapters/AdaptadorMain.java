package com.arturo.almaitu.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arturo.almaitu.Alerts.AlertLinks;
import com.arturo.almaitu.Modelos.ModeloDc;
import com.arturo.almaitu.R;
import com.arturo.almaitu.VisorDeComics;
import com.google.android.gms.ads.InterstitialAd;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AdaptadorMain extends BaseAdapter {

    private Activity activity;
    private ArrayList<ModeloDc> items;
    private Context contexto;
    private InterstitialAd mInterstitialAd;

    public AdaptadorMain(Activity activity, ArrayList<ModeloDc> items, Context contexto, InterstitialAd mInterstitialAd) {
        this.activity = activity;
        this.items = items;
        this.contexto = contexto;
        this.mInterstitialAd = mInterstitialAd;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        final ModeloDc dir;
        final TextView comicName;
        final ImageView comicImage;
        final Button button;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.comiccard, null);
        }

        dir = items.get(position);
        comicName = (TextView) v.findViewById(R.id.comicName);
        comicImage = (ImageView) v.findViewById(R.id.comicImage);
        button = (Button) v.findViewById(R.id.buttonLink);
        comicName.setText(dir.getNombre());
        comicImage.setImageDrawable(createImage(dir));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                openDialog(dir.getNombre());
            }
        });
        return v;
    }


    private RoundedBitmapDrawable createImage(ModeloDc dir) {
        Bitmap bmp = BitmapFactory.decodeResource(contexto.getResources(), contexto.getResources().getIdentifier(dir.getNombreImagen(), "mipmap", contexto.getPackageName()));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(null, bmp);
        roundedDrawable.setCornerRadius(8);
        return roundedDrawable;
    }

    private void openDialog(String comicName) {
        AlertLinks alert = new AlertLinks(activity, contexto, comicName);
    }

}