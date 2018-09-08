package com.arturo.almaitu.Alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.arturo.almaitu.Controladores.ControladorLinks;
import com.arturo.almaitu.Modelos.ModeloDc;
import com.arturo.almaitu.paginaweb;

import java.util.ArrayList;

public class AlertLinks extends AlertDialog {

    private String title;
    private Context context;
    private Activity activity;

    public AlertLinks(Activity activity, Context context, String title) {
        super(context);
        this.activity = activity;
        this.context = context;
        this.title = title;
        initDialog();
    }

    private void initDialog() {
        final ArrayList<ModeloDc> linkList = new ControladorLinks(context).getLinksAndDescriptions(title);
        final AlertDialog.Builder build = new AlertDialog.Builder(context);
        final LinearLayout linear = new LinearLayout(context);
        for (final ModeloDc s : linkList) {
            final Button[] link = new Button[3];
            for (int i = 0; i < link.length; i++) {
                link[i] = new Button(context);
                addLink(linear, link[i], i, s);
            }
        }

        build.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        linear.setGravity(Gravity.CENTER);
        linear.setOrientation(LinearLayout.VERTICAL);
        build.setTitle(title);
        build.setView(linear);
        build.create();
        build.show();
    }

    public void addLink(LinearLayout linear, Button button, int index, ModeloDc model) {
        String link = "";
        String description = " ";
        switch (index) {
            case 0:
                link = model.getLink();
                description = model.getDescripcion();
                break;
            case 1:
                link = model.getLink2();
                description = model.getDescripcion2();
                break;
            case 2:
                link = model.getLink3();
                description = model.getDescripcion3();
                break;
        }
        if ((link != null) && (description != null)) {
            button.setText(description);
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            );
            final String finalLink = link;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //final Intent intent = new Intent(activity, paginaweb.class);
                    //intent.putExtra("link", finalLink);
                    //activity.startActivity(intent);
                    apretar(finalLink);
                }
            });
            linear.addView(button);
        }
    }

    public void apretar(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        activity.startActivity(intent);
    }
}
