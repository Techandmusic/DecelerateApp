package com.apps.adam.decelerateanxietymanager2.cards;

import com.apps.adam.decelerateanxietymanager2.cards.Card;

public class GratitudeCard extends Card
{
    public static final int CARD_TYPE = 0;

    //Class constructor
    public GratitudeCard(String cardName)
    {
        setCardName(cardName);
    }

    public int getCardType()
    {
        return CARD_TYPE;
    }
}
