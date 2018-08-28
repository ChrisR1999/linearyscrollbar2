package com.arturo.almaitu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
