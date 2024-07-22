package com.mistinite.tarotcitanje;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class FourthActivity extends AppCompatActivity {
    TextView tvKeyWords, tvTitle, tvDesc, tvKeyWords2, tvTitle2, tvDesc2, tvKeyWords3, tvTitle3, tvDesc3, tvCardMeans, tvCardMeans2, tvCardMeans3, rl2, rl3;
    ImageView ivCard, ivCard2,ivCard3;
    int randomCard, randomCardPast, randomCardPresent, randomCardFuture;
    String title, keywords, desc, past, present, future;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        tvKeyWords = findViewById(R.id.tvKeyWords);
        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        ivCard = findViewById(R.id.ivCard);
        tvKeyWords2 = findViewById(R.id.tvKeyWords2);
        tvTitle2 = findViewById(R.id.tvTitle2);
        tvDesc2 = findViewById(R.id.tvDesc2);
        ivCard2 = findViewById(R.id.ivCard2);
        tvKeyWords3 = findViewById(R.id.tvKeyWords3);
        tvTitle3 = findViewById(R.id.tvTitle3);
        tvDesc3 = findViewById(R.id.tvDesc3);
        ivCard3 = findViewById(R.id.ivCard3);
        tvCardMeans = findViewById(R.id.tvCardMeans);
        tvCardMeans2 = findViewById(R.id.tvCardMeans2);
        tvCardMeans3 = findViewById(R.id.tvCardMeans3);


        tvKeyWords2.setVisibility(View.GONE);
        tvTitle2.setVisibility(View.GONE);
        tvDesc2.setVisibility(View.GONE);
        ivCard2.setVisibility(View.GONE);
        tvKeyWords3.setVisibility(View.GONE);
        tvTitle3.setVisibility(View.GONE);
        tvDesc3.setVisibility(View.GONE);
        ivCard3.setVisibility(View.GONE);
        tvCardMeans.setVisibility(View.GONE);
        tvCardMeans2.setVisibility(View.GONE);
        tvCardMeans3.setVisibility(View.GONE);


        randomCard = randomMethod();

        Intent intentThird = getIntent();
        int typeOfTarot = intentThird.getIntExtra("readingFinal", 0);

        if (typeOfTarot != 5) {
            tvTitle.setText(viewTitle(randomCard));
            tvKeyWords.setText(viewKeywords(randomCard));
            ivCard.setImageResource(viewImage(randomCard));
        }
        else {
            randomCardPast = randomMethod3Cards();
            randomCardPresent = randomMethod3Cards();
            randomCardFuture = randomMethod3Cards();
        }


        if (typeOfTarot == 1) {
            tvDesc.setText(viewYesNo(randomCard));
        }
        else if (typeOfTarot == 2) {
            tvDesc.setText(viewDaily(randomCard));
        }
        else if (typeOfTarot == 4) {
            tvDesc.setText(viewCareer(randomCard));
        }
        else if (typeOfTarot == 3) {
            tvDesc.setText(viewLove(randomCard));
        }
        else {
            makeViewsVisible();

            tvTitle.setText(viewTitle(randomCardPast));
            tvKeyWords.setText(viewKeywords(randomCardPast));
            ivCard.setImageResource(viewImagePast(randomCardPast));
            tvDesc.setText(viewPast(randomCardPast));

            tvTitle2.setText(viewTitle(randomCardPresent));
            tvKeyWords2.setText(viewKeywords(randomCardPresent));
            ivCard2.setImageResource(viewImagePresent(randomCardPresent));
            tvDesc2.setText(viewPresent(randomCardPresent));

            tvTitle3.setText(viewTitle(randomCardFuture));
            tvKeyWords3.setText(viewKeywords(randomCardFuture));
            ivCard3.setImageResource(viewImageFuture(randomCardFuture));
            tvDesc3.setText(viewFuture(randomCardFuture));
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(FourthActivity.this,SecondActivity.class);
        startActivity(intent);
        finish();
    }

    int randomMethod() {
      return (int)Math.round(Math.random() * 21);
    }

    int randomMethod3Cards() {
      return (int)Math.round(Math.random() * 77);
    }

    void makeViewsVisible() {
        tvKeyWords2.setVisibility(View.VISIBLE);
        tvTitle2.setVisibility(View.VISIBLE);
        tvDesc2.setVisibility(View.VISIBLE);
        ivCard2.setVisibility(View.VISIBLE);
        tvKeyWords3.setVisibility(View.VISIBLE);
        tvTitle3.setVisibility(View.VISIBLE);
        tvDesc3.setVisibility(View.VISIBLE);
        ivCard3.setVisibility(View.VISIBLE);
        tvCardMeans.setVisibility(View.VISIBLE);
        tvCardMeans2.setVisibility(View.VISIBLE);
        tvCardMeans3.setVisibility(View.VISIBLE);
    }


    String viewTitle(int i) {
        title = getResources().getStringArray(R.array.titles)[i];
        return title;
    }

    String viewKeywords(int i) {
        keywords = getResources().getStringArray(R.array.keywords)[i];
        return keywords;
    }

    String viewDaily(int i) {
        desc = getResources().getStringArray(R.array.shorts)[i];
        return desc;
    }

    String viewYesNo(int i) {
        desc = getResources().getStringArray(R.array.yesno)[i];
        return desc;
    }

    String viewCareer(int i) {
        desc = getResources().getStringArray(R.array.careers)[i];
        return desc;
    }

    String viewLove(int i) {
        desc = getResources().getStringArray(R.array.loves)[i];
        return desc;
    }

    String viewPast(int i) {
        past = getResources().getStringArray(R.array.past)[i];
        return past;
    }

    String viewPresent(int i) {
        present = getResources().getStringArray(R.array.present)[i];
        return present;
    }

    String viewFuture(int i) {
        future = getResources().getStringArray(R.array.future)[i];
        return future;
    }

    int viewImage(int i) {
        String imageName = getResources().getStringArray(R.array.id)[randomCard];
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }

    int viewImagePast(int i) {
        String imageName = getResources().getStringArray(R.array.id)[randomCardPast];
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }

    int viewImagePresent(int i) {
        String imageName = getResources().getStringArray(R.array.id)[randomCardPresent];
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }

    int viewImageFuture(int i) {
        String imageName = getResources().getStringArray(R.array.id)[randomCardFuture];
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }
}
