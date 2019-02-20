package com.apps.adam.decelerateanxietymanager2.data;

import com.apps.adam.decelerateanxietymanager2.cards.Card;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import io.paperdb.Paper;

public class CardDatabase extends Paper implements DataAccess
{
    private String key;
    private String bookName;
    private LiveData<List<Card>> allCards;
    private DataAccess dataAccess;

    public CardDatabase(String bookName)
    {
        this.bookName = bookName;
    }

    @Override
    public void insert(String bookName, Card card)
    {
        Paper.book(bookName).write(key, card);
    }

    @Override
    public void update(String bookName, Card card)
    {
        Paper.book(bookName).delete(key);
        Paper.book(bookName).write(key, card);
    }

    @Override
    public void delete(String bookName, Card card)
    {
        Paper.book().delete(key);
    }

    @Override
    public void deleteAll(String bookName)
    {
        Paper.book().destroy();
    }

    @Override
    public LiveData<List<Card>> getAllCards(String bookName)
    {
        allCards = Paper.book().read(bookName);
        return allCards;
    }

//TODO evaluate options of trying to create LiveData from List, or migrating to room with type conversion
}
