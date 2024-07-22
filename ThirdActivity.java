package com.mistinite.tarotcitanje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    TextView chooseNumOfCards;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20;
    Button seeCardsBtn;
    String typeOfBtn;
    int typeOfReading, numberOfChoosing;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //interstitial add
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
           @Override
           public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
            AdRequest adRequest = new AdRequest.Builder().build();

            // working  ca-app-pub-7000356114864560/1460201261 testing ca-app-pub-3940256099942544/1033173712
           InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                  new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                            mInterstitialAd = interstitialAd;
                            Log.i("tag", "onAdLoaded");
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            Log.d("tag", loadAdError.toString());
                            mInterstitialAd = null;
                        }
                    });
        // interstitial add end




        seeCardsBtn = findViewById(R.id.seeCardsBtn);
        seeCardsBtn.setVisibility(View.GONE);
        findViews();
        displayBack();

        Intent intentSec = getIntent();
        typeOfBtn = intentSec.getStringExtra("chosenCard");
        typeOfReading = Integer.parseInt(typeOfBtn);
        if (typeOfReading == 5) {
            numberOfChoosing = 3;
            chooseNumOfCards.setText(R.string.odaberi_3_karte);
        }
        else {
            numberOfChoosing = 1;
            chooseNumOfCards.setText(R.string.odaberi_kartu);
        }

    }

    public void findViews() {
        chooseNumOfCards = findViewById(R.id.chooseNumOfCards);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView19 = findViewById(R.id.imageView19);
        imageView20 = findViewById(R.id.imageView20);
    }

    public void displayBack() {
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        imageView10.setOnClickListener(this);
        imageView11.setOnClickListener(this);
        imageView12.setOnClickListener(this);
        imageView13.setOnClickListener(this);
        imageView14.setOnClickListener(this);
        imageView15.setOnClickListener(this);
        imageView16.setOnClickListener(this);
        imageView17.setOnClickListener(this);
        imageView18.setOnClickListener(this);
        imageView19.setOnClickListener(this);
        imageView20.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (numberOfChoosing == 3) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                params.setMargins(-20, -20, 0, 0);
                view.setLayoutParams(params);
                numberOfChoosing = 2;
                chooseNumOfCards.setText(R.string.odaberi_2_karte);
    }
        else if (numberOfChoosing == 2) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
            params.setMargins(-20, -20, 0, 0);
            view.setLayoutParams(params);
            numberOfChoosing = 1;
            chooseNumOfCards.setText(R.string.odaberi_kartu);
        }
        else if (numberOfChoosing == 1) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
            params.setMargins(-20, -20, 0, 0);
            view.setLayoutParams(params);
            numberOfChoosing = 0;
            seeCardsBtn.setVisibility(View.VISIBLE);
        }
        else {
            view.setEnabled(false);
        }

        seeCardsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentThird = new Intent(ThirdActivity.this, FourthActivity.class);
                intentThird.putExtra("readingFinal", typeOfReading);
                startActivity(intentThird);
                finish();

                //interst ad calling
                if (mInterstitialAd != null) {
                   mInterstitialAd.show(ThirdActivity.this);
               } else {
                   Log.d("TAG", "The interstitial ad wasn't ready yet.");
               }
                //interst ad calling end
            }
        });
    }


}