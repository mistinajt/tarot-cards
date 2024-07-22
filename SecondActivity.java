package com.mistinite.tarotcitanje;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.interstitial.InterstitialAd;



public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button daneBtn, dnevniBtn, ljubavniBtn, poslovniBtn, karte3Btn;
    String chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        daneBtn = findViewById(R.id.daneBtn);
        dnevniBtn = findViewById(R.id.dnevniBtn);
        ljubavniBtn = findViewById(R.id.ljubavniBtn);
        poslovniBtn = findViewById(R.id.poslovniBtn);
        karte3Btn = findViewById(R.id.karte3Btn);

        daneBtn.setOnClickListener(this);
        dnevniBtn.setOnClickListener(this);
        ljubavniBtn.setOnClickListener(this);
        poslovniBtn.setOnClickListener(this);
        karte3Btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.daneBtn) {
            chosen = "1";
        } else if (view.getId() == R.id.dnevniBtn) {
            chosen = "2";
        } else if (view.getId() == R.id.ljubavniBtn) {
            chosen = "3";
        } else if (view.getId() == R.id.poslovniBtn) {
            chosen = "4";
        } else {
            chosen = "5";
        }

        Intent intentSec = new Intent(SecondActivity.this, ThirdActivity.class);
        intentSec.putExtra("chosenCard", chosen);
        startActivity(intentSec);
        finish();
    }
}

