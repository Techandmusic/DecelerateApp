package com.apps.adam.decelerateanxietymanager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddCard extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card);
        TextView titleText = findViewById(R.id.new_card_title);
        Intent intent = getIntent();
        String titleString = intent.getStringExtra("cardType");
        if (titleString == "Concerns") {
            titleText.setText(R.string.concerns_title);
        } else if (titleString == "Gratitude") {
            titleText.setText(R.string.gratitude_title);
        } else {
            titleText.setText(R.string.belief_title);
        }





    }
}
