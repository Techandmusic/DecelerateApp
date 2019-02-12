package com.apps.adam.decelerateanxietymanager2.data;

import android.os.AsyncTask;

import com.apps.adam.decelerateanxietymanager2.cards.Card;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repository implements DataAccess
{
    private LiveData<List<Card>> allCards;
    private String bookName;
    private CardDatabase cardDatabase;
    private DataAccess dataAccess;

    public Repository(String bookName)
    {
        this.bookName = bookName;
        cardDatabase = new CardDatabase(bookName);

    }

    @Override
    public void insert(String bookName, Card card)
    {
        new InsertCardAsyncTask(dataAccess).execute(card);
    }

    @Override
    public void update(String bookName, Card card)
    {
        new UpdateCardAsyncTask(dataAccess).execute(card);
    }

    @Override
    public void delete(String bookName, Card card)
    {
        new DeleteCardAsyncTask(dataAccess).execute(card);
    }

    @Override
    public void deleteAll(String bookName)
    {
        new DeleteAllCardsAsyncTask(dataAccess).execute();
    }

    @Override
    public LiveData<List<Card>> getAllCards(String bookName)
    {
        return null;
    }

    private static class InsertCardAsyncTask extends AsyncTask<Card, Void, Void>
    {
        //instance of DataAccess
        private DataAccess dataAccess;
        //bookName String
        private String bookName;

        //constructor
        private InsertCardAsyncTask(DataAccess dataAccess)
        {
            this.dataAccess = dataAccess;
        }

        //DoInBackground method
        protected Void doInBackground(Card... cards)
        {
            dataAccess.insert(bookName, cards[0]);
            return null;
        }


    }

    private static class UpdateCardAsyncTask extends AsyncTask<Card, Void, Void>
    {
        //instance of DataAccess
        private DataAccess dataAccess;
        //bookName String
        private String bookName;

        //constructor
        private UpdateCardAsyncTask(DataAccess dataAccess)
        {
            this.dataAccess = dataAccess;
        }

        //DoInBackground method
        @Override
        protected Void doInBackground(Card... cards)
        {
            dataAccess.update(bookName, cards[0]);
            return null;
        }
    }

    private static class DeleteCardAsyncTask extends AsyncTask<Card, Void, Void>
    {
        //instance of DataAccess
        private DataAccess dataAccess;
        //bookName String
        private String bookName;

        //constructor
        private DeleteCardAsyncTask(DataAccess dataAccess)
        {
            this.dataAccess = dataAccess;
        }
        //DoInBackground method

        @Override
        protected Void doInBackground(Card... cards)
        {
            dataAccess.delete(bookName, cards[0]);
            return null;
        }
    }

    private static class DeleteAllCardsAsyncTask extends AsyncTask<Void, Void, Void>
    {
        //instance of DataAccess
        private DataAccess dataAccess;
        //bookName String
        private String bookName;

        //constructor
        private DeleteAllCardsAsyncTask(DataAccess dataAccess)
        {
            this.dataAccess = dataAccess;
        }
        //DoInBackground method

        @Override
        protected Void doInBackground(Void... voids)
        {
            dataAccess.deleteAll(bookName);
            return null;
        }
    }


}
