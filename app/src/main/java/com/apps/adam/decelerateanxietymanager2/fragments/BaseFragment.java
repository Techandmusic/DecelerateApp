package com.apps.adam.decelerateanxietymanager2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.adam.decelerateanxietymanager2.R;
import com.apps.adam.decelerateanxietymanager2.cards.Card;
import com.apps.adam.decelerateanxietymanager2.cards.CardAdapter;
import com.apps.adam.decelerateanxietymanager2.models.CardViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseFragment extends Fragment
{
    private RecyclerView recyclerView;
    private CardViewModel cardViewModel;
    private String bookName;
    private OnButtonClickListener listener;
    private FloatingActionButton FAB;


    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public OnButtonClickListener getListener()
    {
        return listener;
    }

    public FloatingActionButton getFAB()
    {
        return FAB;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_recycler_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        final CardAdapter adapter = new CardAdapter();
        recyclerView.setAdapter(adapter);
        cardViewModel = ViewModelProviders.of(this).get(CardViewModel.class);
        cardViewModel.getAllCards(bookName).observe(this, new Observer<List<Card>>()
        {
            @Override
            public void onChanged(List<Card> cards)
            {
                adapter.submitList(cards);
            }
        });





        return view;
    }



    public interface OnButtonClickListener
    {
        void onButtonClicked(FloatingActionButton fab);
    }
}
