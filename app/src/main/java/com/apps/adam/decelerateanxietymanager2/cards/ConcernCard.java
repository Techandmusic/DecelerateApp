package com.apps.adam.decelerateanxietymanager2.cards;

public class ConcernCard extends Card
{
    public static final int CARD_TYPE = 1;

    //Class constructor
    public ConcernCard(String cardName)
    {
        this.setCardName(cardName);
    }

    public int getCardType()
    {
        return CARD_TYPE;
    }
}
