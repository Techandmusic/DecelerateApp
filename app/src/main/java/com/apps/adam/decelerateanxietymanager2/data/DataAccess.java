package com.apps.adam.decelerateanxietymanager2.data;

import com.apps.adam.decelerateanxietymanager2.cards.Card;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface DataAccess
{
    void insert(String bookName, Card card);

    void update(String bookName, Card card);

    void delete(String bookName, Card card);

    void deleteAll(String bookName);

    LiveData<List<Card>> getAllCards(String bookName);


}
