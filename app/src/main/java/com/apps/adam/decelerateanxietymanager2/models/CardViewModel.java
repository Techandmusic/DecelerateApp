package com.apps.adam.decelerateanxietymanager2.models;

import com.apps.adam.decelerateanxietymanager2.cards.Card;
import com.apps.adam.decelerateanxietymanager2.data.DataAccess;
import com.apps.adam.decelerateanxietymanager2.data.Repository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CardViewModel extends ViewModel implements DataAccess
{
    private Repository repository;

    private LiveData<List<Card>> liveCards;

    private String bookName;

    private LiveData<List<Card>> allCards;

    public CardViewModel(String bookName)
    {
        this.bookName = bookName;
        repository = new Repository(bookName);

    }

    @Override
    public void insert(String bookName, Card card)
    {
        repository.insert(bookName, card);
    }

    @Override
    public void update(String bookName, Card card)
    {
        repository.update(bookName, card);
    }

    @Override
    public void delete(String bookName, Card card)
    {
        repository.delete(bookName, card);
    }

    @Override
    public void deleteAll(String bookName)
    {
        repository.deleteAll(bookName);
    }

    @Override
    public LiveData<List<Card>> getAllCards(String bookName)
    {
        return allCards;
    }
}
