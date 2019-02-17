package com.apps.adam.decelerateanxietymanager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.adam.decelerateanxietymanager2.cards.Card;
import com.apps.adam.decelerateanxietymanager2.cards.ConcernCard;
import com.apps.adam.decelerateanxietymanager2.cards.GratitudeCard;
import com.apps.adam.decelerateanxietymanager2.data.Repository;
import com.apps.adam.decelerateanxietymanager2.models.CardViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddCard extends AppCompatActivity
{
    private CardViewModel viewModel;
    private Card newCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card);
        TextView titleText = findViewById(R.id.new_card_title);
        Intent intent = getIntent();
        final String titleString = intent.getStringExtra("cardType");
        if (titleString == "Concerns") {
            titleText.setText(R.string.concerns_title);
        } else if (titleString == "Gratitude") {
            titleText.setText(R.string.gratitude_title);
        } else {
            titleText.setText(R.string.belief_title);
        }

        Button button = findViewById(R.id.add_card_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText cardTitle = findViewById(R.id.add_card_input);
                String cardName = cardTitle.getText().toString();
                if (titleString == "Concerns") {
                    newCard = new ConcernCard(cardName);
                } else {
                    newCard = new GratitudeCard(cardName);
                }

                viewModel.insert(titleString, newCard);


            }


        });





    }
}
