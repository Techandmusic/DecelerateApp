package com.apps.adam.decelerateanxietymanager2.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Card
{
    private String cardName;

    private List<String> cardExtras = new ArrayList<String>();

    public List<String> getCardExtras()
    {
        return cardExtras;
    }

    public String getCardName()
    {
        return cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    public void addExtras(String listItem)
    {
        cardExtras.add(listItem);
    }

    public void removeExtra(int index)
    {
        cardExtras.remove(index);
    }
}
