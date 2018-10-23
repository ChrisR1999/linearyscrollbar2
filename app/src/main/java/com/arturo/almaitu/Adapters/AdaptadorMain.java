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
import android.widget.Toast;

import com.arturo.almaitu.Alerts.AlertLinks;
import com.arturo.almaitu.Modelos.ModeloDc;
import com.arturo.almaitu.R;
import com.arturo.almaitu.VisorDeComics;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.InterstitialAd;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AdaptadorMain extends BaseAdapter {

    private Activity activity;
    private ArrayList<ModeloDc> items;
    private Context contexto;
    private InterstitialAd mInterstitialAd;
     String foto = "";
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
        //comicImage.setImageDrawable(createImage(dir));
        createImage(dir);
        Glide.with(contexto).load(foto).placeholder(R.mipmap.alitas).into(comicImage);
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


    private /*RoundedBitmapDrawable*/void createImage(ModeloDc dir) {
       // foto ="https://scontent.fmex11-1.fna.fbcdn.net/v/t31.0-8/19574980_127581701164679_6324430080905368172_o.jpg?_nc_cat=102&oh=e32e64b07b872f0db35604d3c6beb684&oe=5C61D08E";
       // Toast.makeText(contexto,""+dir.getNombreImagen(),Toast.LENGTH_LONG).show();
        foto =dir.getNombreImagen();
        /*  Bitmap bmp = BitmapFactory.decodeResource(contexto.getResources(), contexto.getResources().getIdentifier(dir.getNombreImagen(), "mipmap", contexto.getPackageName()));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(null, bmp);


        roundedDrawable.setCornerRadius(0);
        return roundedDrawable;*/
    }

    private void openDialog(String comicName) {
        AlertLinks alert = new AlertLinks(activity, contexto, comicName);
    }

}